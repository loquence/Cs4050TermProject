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
 */
@WebServlet("/BookstoreServlet")
public class BookstoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int unVerified = 0;
	private static final int verified = 1;
    private TemplateProcessor processor;
    private static String templateDir = "/WEB-INF/templates"; 
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookstoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("name");
		
		if (page.equals("fillBooks")) {
			response.setContentType("text/html");
			response.getWriter().write("noot noot");
		}
		if(page.equals("email")) {
			checkEmail(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		String template ="login.html";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		root.put("name", page);
		HttpSession session = request.getSession(false);
		BookstoreLogicImpl bookstoreLogic = new BookstoreLogicImpl();
		if (page.equals("signup")) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			Customer u = new Customer(fname,lname,email,pwd,unVerified);
			
			session=request.getSession();
			synchronized(session) {
				session.setAttribute("email", email);
				session.setAttribute("logged", false);
			}
			String to = email;
			Mailer ml = new Mailer();
			User checkEmail = bookstoreLogic.checkEmail(email);
			if (checkEmail.getEmail() != null) {
				if (checkEmail.getEmail().equals(email)) {
					root.put("emailExists", true);
					processor.processTemplate("../../signup.html", root, request, response);
				}
			}
			else {
				int check = 0;
			
				try {
					check = ml.send(to,"test","test");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					check = -1;
				}
				if (check < 0){
					root.put("checkEmail", true);
					processor.processTemplate("signup.html",root,request,response);
				}
				else {
					int test = bookstoreLogic.createCustomer(u);
					if (test == -1) {
						root.put("database", true);
						processor.processTemplate("signup.html", root, request, response);
					}
					else {
						response.setContentType("text/html");
						response.getWriter().write("index.html");
					}
				}
			
			}
		} 
		if (page.equals("signin")) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			User u = new User("","",email,pwd);
			int check = u.login();
			if (check == 0) {
				
			}
			
		}
		if (page.equals("profile")) {
			template = "profile.html";
			processor.processTemplate(template, root, request, response);
		}
	}
	
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		User u = new User("","",email,"");
		User test = u.checkEmail();
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(test));
		
	}

}
