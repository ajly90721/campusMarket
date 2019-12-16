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

import model.product.Product;
import model.product.ProductJDBCTemplate;
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
	
	@CrossOrigin	(origins = "*")
	@RequestMapping(value="/loginPage")
	public String loginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";
	}
	@RequestMapping(value="/indexPage")
	public String indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "index";
	}
	@RequestMapping(value="/registerPage")
	public String registerPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "register";
	}

	@RequestMapping(value="/aboutPage")
	public String aboutPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "about";
	}

	@CrossOrigin	(origins = "*")
	@RequestMapping	(value="/login", method=RequestMethod.POST)
	public void login(
			@RequestParam("id")			String id,
			@RequestParam("password")	String password,
										HttpServletRequest request,
										HttpServletResponse response) throws IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			
			ArrayList<User> user = userDAO.getUserByIdAndPassword(id, password);
			if(user.isEmpty()==true)
				response.sendRedirect("loginerror");
			else
				{
				request.getSession().setAttribute("user",user.get(0));
				response.sendRedirect("indexPage");
				}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			HttpTools.writeJSON(response, "fail");
		}
	}
	
	@CrossOrigin	(origins = "*")
	@RequestMapping	(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public void register(
			@RequestParam("file")		MultipartFile file,
			@RequestParam("id")			String id,
			@RequestParam("name")		String name,
			@RequestParam("password")	String password,
			@RequestParam("gender")		String gender,
			@RequestParam("school")		String school,
			@RequestParam("campus")		String campus,
			@RequestParam("telephone")	String telephone,
										HttpServletRequest request,
										HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			System.out.println("image name : " + file.getOriginalFilename());
			System.out.println("RegisterInfo : " + id + " " + 
			name + " " + password + " " + gender + " " + school + " " + campus + " " + telephone);
			
			String path = request.getServletContext().getRealPath("/Image/");
			String iconPath = ImageTools.saveImage(file, id + "_" + file.getOriginalFilename(), path);

			context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			
			User newUser = userDAO.addUser(id, name, password, gender, school, campus, iconPath, telephone);
			HttpTools.writeJSON(response, newUser.toString());
		} catch (IOException e) {
			e.printStackTrace();
			HttpTools.writeJSON(response, "fail");
		}
	}
	
	@CrossOrigin	(origins = "*")
	@RequestMapping	(value="/updateUser", method=RequestMethod.POST)

	public void updateUser(
			@RequestParam("file")		MultipartFile file,
			@RequestParam("id")			String id,
			@RequestParam("name")		String name,
			@RequestParam("password")	String password,
			@RequestParam("gender")		String gender,
			@RequestParam("school")		String school,
			@RequestParam("campus")		String campus,
			@RequestParam("telephone")	String telephone,
										HttpServletRequest request,
										HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String path = request.getServletContext().getRealPath("/Image/");
			String iconPath = ImageTools.saveImage(file, id + "_" + file.getOriginalFilename(), path);

			context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
			UserDAO userDAO = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			
			User newUser = userDAO.updateUser(id, name, password, gender, school, campus, iconPath, telephone);
			HttpTools.writeJSON(response, newUser.toString());
		} catch(IOException e) {
			e.printStackTrace();
			HttpTools.writeJSON(response, "fail");
		}
	}
	@CrossOrigin	(origins = "*")
	@RequestMapping	(value="/updatePassword", method=RequestMethod.POST)
	@ResponseBody
	public boolean updatePassword(

			@RequestParam("oldpassword")	String opwd,
			@RequestParam("newpassword")	String npwd,


										HttpServletRequest request,
										HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			User u=(User) request.getSession().getAttribute("user");
			UserJDBCTemplate ut = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
			System.out.print(npwd+" "+opwd);
			u=ut.updatePassword(u.getId(), npwd);
			if(opwd.equals(u.getPassword()))
			{
				request.getSession().setAttribute("user",u);
				return true;
			}

		} catch(IOException e) {
			e.printStackTrace();
			HttpTools.writeJSON(response, "fail");
		}
		return false;
	}
}
