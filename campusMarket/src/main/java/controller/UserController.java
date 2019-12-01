/**
 * 
 */
package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.user.*;
import tools.*;

/**
 * @author Mithrandir
 *
 */
@Controller
public class UserController {
	private ApplicationContext context;
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/loginPage")
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String id = (String)request.getParameter("id");
			String password = (String)request.getParameter("password");
			context = new ClassPathXmlApplicationContext("Beans.xml");
			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public void register(
			@RequestParam("file")MultipartFile file,
			@RequestParam("id")String id,
			@RequestParam("name")String name,
			@RequestParam("password")String password,
			@RequestParam("gender")String gender,
			@RequestParam("school")String school,
			@RequestParam("campus")String campus,
			@RequestParam("telephone")String telephone,
			HttpServletRequest request,
			HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			System.out.println("image name : " + file.getOriginalFilename());
			System.out.println("RegisterInfo : " + id + " " + 
			name + " " + password + " " + gender + " " + school + " " + campus + " " + telephone);
			
			String path = request.getServletContext().getRealPath("/Image/");
			String iconPath = ImageTools.saveImage(file, id + "_" + file.getOriginalFilename(), path);

			context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
			System.out.println(context.getBeanDefinitionCount());

			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			User newUser = userDAO.addUser(id, name, password, gender, school, campus, iconPath, telephone);
			System.out.println(newUser);
			response.getWriter().println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public void updateUser(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		
	}
}
