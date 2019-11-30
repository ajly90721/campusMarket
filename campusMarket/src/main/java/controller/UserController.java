/**
 * 
 */
package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.user.*;

/**
 * @author Mithrandir
 *
 */
public class UserController {
	private ApplicationContext context;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String id = (String)request.getParameter("id");
			String password = (String)request.getParameter("password");
			System.out.println("POST:" + id + password);
			context = new ClassPathXmlApplicationContext("Beans.xml");
			
			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			
		} catch (UnsupportedEncodingException e) {
			
		}
		
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public void updateUser(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
