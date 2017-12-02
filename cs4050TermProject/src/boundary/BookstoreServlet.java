package boundary;
import logiclayer.BookstoreLogicImpl;
import objectlayer.*;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boundary.TemplateProcessor;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateModelException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.NamingException;
import javax.activation.*;


/**
 * Servlet implementation class BookstoreServlet
 * @author Ryan
 */
@WebServlet("/BookstoreServlet")
public class BookstoreServlet extends HttpServlet {
	/**
	 * serialVersionUID: Default version for the template processor
	 * unVerified: default value for an unverified user
	 * verified: default value for a verified user
	 * 
	 * @seeTemplateProcessor#TemplateProcessor()
	 * TemplateProcessor processor: processor object from class TemplateProcessor
	 * templateDir: default template directory for the template processor to look for
	 */
	private static final long serialVersionUID = 1L;
    private TemplateProcessor processor;
    private static String templateDir = "/WEB-INF/templates"; 
    
       
    /**
     * @see HttpServlet#HttpServlet()
     * Super constructor for Servlet
     */
    public BookstoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Servlet init function.
     * Sets processor to a new TemplateProcessor with the 
     * templateDir being the templateDir from above, and
     * the ServletContext to the server settings from the 
     * xml file.
     */
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Processes get requests
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gets the name parameter and stores it in page
		String page = request.getParameter("name");
		
		response.setContentType("text/html;charset=UTF-8");

 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * handles post requests
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * creation of necessary variables that will be used later
		 */
		String page = request.getParameter("page");//gets page value of the given page
		String template ="login.html";//default template page is currently login.html, can be changed later
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(processor.getCfg().getVersion());//object wrapper to be used for Freemarker Hashmap
		SimpleHash root = new SimpleHash(db.build());//the hashmap
		root.put("name", page);//putting name into the hashmap, currently not in use
		
		RandomStringGen rg = new RandomStringGen();
		/*
		 * logicImplementation object from the logicImplementation class
		 * May not be used in future versions of this project as the persistLayer
		 * is going to be accessed from the Object Layer instead of the Logic Layer
		 */
		BookstoreLogicImpl bookstoreLogicImpl = new BookstoreLogicImpl();
		if(page.equals("email")) {
			checkEmail(request,response);
		}
		
		if(page.equals("index")) {
			processor.processTemplate("index.html", root, request, response);
		}
		/*
		 * Checks if page who sent post request is the signup page
		 * Currently this form is being handled by an ajax call.
		 */
		if (page.equals("signup")) {
			
			/*
			 * If signup sent the post request,
			 * gathers all the parameter values 
			 * in the form and puts them into strings
			 */
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			//Creates a new customer based off those values, sets its verified value to unVerified
			Customer u = new Customer(fname,lname,email,pwd,Status.UNVERIFIED);
			Mailer ml = new Mailer();//creates Mailer object
			
			
			/*
			 * Calls checkMail on the customer, to verify if the email is available.
			 * This has been implemented in ajax and may not be needed in the future.
			 */
			User checkEmail = u.checkEmail();
			//If checking if the email is null or not, if its not null, it is taken
			if (checkEmail.getEmail() != null) {
				//Extra check just incase, for some reason, it gave back the wrongemail
				if (checkEmail.getEmail().equals(email)) {
					root.put("emailExists", true);
					template ="../../signup.html";
					processor.processTemplate("../../signup.html", root, request, response);
				}
			}
			//Else the email is not in database, and is available
			else {
				int check = 0;
				int test = u.createUser();
				
				if (test== -1) {
					root.put("database", true);
					processor.processTemplate("signup.html", root, request, response);
				}
				else {
					
					try {
						/*
						 * Calls send(email,subject,msg) which tries to send
						 * a mail to email with subject and msg. Catches namingexception
						 * and sets response to what send returns
						 */
						String rando = null;
						int checkCode = -1;
						while(checkCode==-1) {
							rando=RandomStringGen.getString();
							checkCode= bookstoreLogicImpl.checkCode(rando); 
						}
						
						u.addCode(rando);
						check = ml.send(u.getEmail(),"Verify your Email account!","Thank you for registering!\n Here is your account verification code: " + rando);
					} catch (NamingException e) {
					
					e.printStackTrace();
					check = -1;
					}
					/*
					 * If send returns < 0, the email could not be sent
					 * and the email is not valid. Output response to the user.
					 * Output is not currently working. Instead of using the processor,
					 * the future plan is to use response.write("failure") or something along those lines
					 * to an ajax request which will then reload the signup form with
					 * a message saying the email does not exist
					 */
					if (check < 0){
						
						root.put("checkEmail", true);
						processor.processTemplate("signup.html",root,request,response);
						/*delete the added user here in future*/
					}
				/*
				 * else, the email is valid and the mail is sent
				 * 
				 * 
				 * Currently, this sends the email first before trying to create the user in the database, but there could be an error
				 * in creating the user in the database in which the user does not get created in the database but gets sent an email anyway.
				 * The optimal method should be, create user in database and check if it is created before sending email. If it fails,
				 * do not sent email, but if it succeeds, send the email. If the email fails, then delete the user from the database
				 * and output the problem to the user: either that the email is not valid, or that there is some problem with the database.
				 * Atm there shouldnt be any problem inputting to the database but this is just a failsafe.
				 */
				else {
					
					/*
					 * Sends this html response to the ajax method that sent this request.
					 * 
					 */
						root.put("email", u.getEmail());
						template="verify.html";
						processor.processTemplate("verify.html", root, request, response);
					}
				}
			}	
		}
			
		/*
		 * Checks if the page that sent the request is signin
		 * Need to implement ajax for the signin form as ajax
		 * will handle the form just like signup
		 */
		if (page.equals("signin")) {
			/*
			 * Gets email and pwd and verifies it with the database
			 * In the future, this should return the type of user from the database
			 * So the server knows what to load (ex: Admin view, or Customer view)
			 */
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			User u = new User("","",email,pwd,Status.UNVERIFIED,UserType.CUSTOMER);
			HttpSession session = request.getSession(true);//getting the current session on startup
			session.setMaxInactiveInterval(1800);
			int check = u.login();
			if (check > 0 && u.getStatus().equals(Status.VERIFIED)) {
				root.put("user", u.getFname());
				root.put("type", u.getType());
				
				
				synchronized(session) {
					session.setAttribute("email", u.getEmail());
					session.setAttribute("fname", u.getFname());
					session.setAttribute("lname", u.getLname());
					session.setAttribute("type", u.getType());
				}
				processor.processTemplate("homepage.html", root, request, response);
				
				
			}
			else if (!u.getStatus().equals(Status.VERIFIED)) {
				template="verify.html";
				//processor.processTemplate(template, root, request, response);
			}
			else {
				response.setContentType("text/html");
				response.getWriter().write("" + u.getStatus());
				//processor.processTemplate("../../signin.html", root, request, response);
			}
			
			
			
		}
		
		if (page.equals("verify")) {
			String code = request.getParameter("code");
			String email= request.getParameter("em");
			User u = new User("","",email,"",Status.VERIFIED, UserType.CUSTOMER);
			int check = u.verifyCode(code);
			if(check == -1) {
				
				response.setContentType("text/html");
				response.getWriter().write(email + " "+ check);
			}
			else {
				//remove code from code thing here
				//update verified
				//update session for logging in
				//add cookie?? << not sure if that will work with freemarker template
				HttpSession session = request.getSession(true);//getting the current session on startup
				session.setMaxInactiveInterval(1800);
				root.put("type", session.getAttribute("type"));
				processor.processTemplate("homepage.html", root, request, response);
			}
		}
		
		/*
		 * Everything after here is once a user is already logged in.
		 * The if statements checks if the session still exists, and if it doesnt
		 * redirects to the index page
		 */
		HttpSession session = request.getSession(false);
		if (session != null) {
			/*
			 * checks if profile submits a request
			 * Currently nothing is implemented for the profile form
			 */
			if (page.equals("profile")) {
				template = "profile.html";
				processor.processTemplate(template, root, request, response);
				
			}
			if(session.getAttribute("type").equals(UserType.ADMIN)) {
				root.put("user", session.getAttribute("fname"));
				if (page.equals("addBook")) {
					
					Admin a = new Admin("","","","",Status.VERIFIED);
					
					
					
					
					//attempting to add book
					String title = request.getParameter("title");
					String author = request.getParameter("author");
					String publisher = request.getParameter("publisher");
					String genre = request.getParameter("genre");
					String ISBN = request.getParameter("isbn");
					String pubYear = request.getParameter("pubYear");
					String edition = request.getParameter("edition");
					String threshold = request.getParameter("min");
					String sellP = request.getParameter("sellPrice");
					String buyP = request.getParameter("buyPrice");
					String cover = request.getParameter("cover");
					String quant = request.getParameter("quantity");
					
					
					
					Integer pubY = Integer.valueOf(pubYear);
					Integer ed = Integer.valueOf(edition);
					Integer minThresh = Integer.valueOf(threshold);
					Integer quantity = Integer.valueOf(quant);
					double sell = Double.parseDouble(sellP);
					double buy = Double.parseDouble(buyP);
					
					Book b = new Book(ISBN, title, genre, author, ed, publisher, pubY, quantity, /*int rating,*/ cover, sell, buy, minThresh);
					int check = a.addBook(b);
					
				}
				if(page.equals("addBookPage")) {
					template="addBook.html";
					processor.processTemplate(template, root, request, response);
				}
				if (page.equals("editBooks")) {
					template="editBook.html";
					processor.processTemplate(template, root, request, response);
				}
				
			}
			
		}
	}
	
	/**
	 *checks the email in the database
	 */
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * Gets the email value from the request
		 * puts it in a new user with no values but for email
		 * calls checkEmail which returns a user object
		 * sends the user back to the page that requested the 
		 * email to be checked, where it checks if the email value 
		 * of test is null or not
		 */
		String email = request.getParameter("email");
		User u = new Customer("","",email,"",Status.VERIFIED);
		User test = u.checkEmail();
		Gson gson = new Gson();//gson object
		response.setContentType("application/json");//set responseType to json
		response.getWriter().write(gson.toJson(test));//converts test object to json
		
	}

}