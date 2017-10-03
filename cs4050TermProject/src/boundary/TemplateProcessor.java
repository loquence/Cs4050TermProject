package boundary;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class TemplateProcessor {

	private String templateDir;
	private String templateName;
	private Configuration cfg;
	
	public TemplateProcessor(String templateDir, ServletContext servletContext) {
		this.templateDir   = templateDir;
		cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setServletContextForTemplateLoading(servletContext, templateDir);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
	}
	
	public void processTemplate(String templateName, SimpleHash root, HttpServletRequest request, HttpServletResponse response) {
		this.templateName  = templateName;
		Template template = null;
		try {
			template = cfg.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Writer out = response.getWriter();
			response.setContentType("text/html");
			template.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of processTemplate	

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Configuration getCfg() {
		return cfg;
	}

	public void setCfg(Configuration cfg) {
		this.cfg = cfg;
	}
	
	
}
