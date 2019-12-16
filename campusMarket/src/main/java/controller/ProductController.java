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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import model.product.*;
import model.user.User;
import model.user.UserDAO;
import model.user.UserJDBCTemplate;
import tools.*;
/**
 * @author Mithrandir
 *
 */
@Controller
public class ProductController {
	private ApplicationContext context;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	@ResponseBody
	public void addProduct(
			@RequestParam("files")		MultipartFile[] files,
			@RequestParam("name")		String name,
			@RequestParam("userId")		String userId,
			@RequestParam("price")		String price,
			@RequestParam("time")		String time,
			@RequestParam("description")String description,
			@RequestParam("directory")	String directory,
										HttpServletResponse response,
										HttpServletRequest  request) {
		response.setCharacterEncoding("UTF-8");
		context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
		ProductDAO productDAO = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
		String imgPath = request.getServletContext().getRealPath("/ProductImage/");
		String iconPath = "";
		int count = 1;
		for(MultipartFile file : files) {
			String temp = ImageTools.saveImage(file, name + "_" + time + "_" + count + file.getOriginalFilename(), imgPath);
			iconPath += "#" + temp;
			count++;
			//#Path1#Path2#Path3...
		}
		Product newProduct = productDAO.addProduct(name, userId, price, time, description, iconPath, directory);
		HttpTools.writeJSON(response, newProduct.toString());
	}
	
	@RequestMapping(value="deleteProduct", method=RequestMethod.POST)
	@ResponseBody
	public void deleteProduct(@RequestParam("id")String id, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
		ProductDAO productDAO = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
		boolean ret = productDAO.deleteProduct(id);
		if(ret) {
			HttpTools.writeJSON(response, "success");
		} else {
			HttpTools.writeJSON(response, "fail");
		}
	}
	
	@RequestMapping(value="searchProduct", method=RequestMethod.POST)
	@ResponseBody
	public void searchProduct(
			@RequestParam("name")		String name,
			@RequestParam("school")		String school,
			@RequestParam("campus")		String campus,
			@RequestParam("directory")	String directory,
										HttpServletResponse	response) {
		response.setCharacterEncoding("UTF-8");
		context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
		ProductDAO productDAO = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
		ArrayList<Product> results = productDAO.searchProduct(name, school, campus, directory);
		String result = JSONObject.toJSON(results).toString();
		HttpTools.writeJSON(response, result);
	}
	
	@RequestMapping(value="updateProduct", method=RequestMethod.POST)
	@ResponseBody
	public void updateProduct(
			@RequestParam("files")		MultipartFile[] files,
			@RequestParam("id")			String id,
			@RequestParam("name")		String name,
			@RequestParam("userId")		String userId,
			@RequestParam("price")		String price,
			@RequestParam("time")		String time,
			@RequestParam("description")String description,
			@RequestParam("directory")	String directory,
										HttpServletResponse response,
										HttpServletRequest	request) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
		ProductDAO productDAO = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
		if(files != null && files.length > 0)
		{
			String imgPath = request.getServletContext().getRealPath("/ProductImage/");
			String iconPath = "";
			int count = 1;
			for(MultipartFile file : files) {
				String temp = ImageTools.saveImage(file, name + "_" + time + "_" + count + file.getOriginalFilename(), imgPath);
				iconPath += "#" + temp;
				count++;
				//#Path1#Path2#Path3...
			}
			Product newProduct = productDAO.updateProduct(id, name, userId, price, time, description, iconPath, directory);
			HttpTools.writeJSON(response, newProduct.toString());
		}
	}
	
	@RequestMapping(value="commodityPage")
	public String commodityPage(
			
										HttpServletResponse response,
										HttpServletRequest	request) 
	{
		try 
			{
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
				ProductJDBCTemplate pt = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
				
				ArrayList<Product> p = pt.getAll();
	
				request.setAttribute("product", p);
			} 
		catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
				HttpTools.writeJSON(response, "fail");
			}
		
		return "commodity";
	}
	
	@RequestMapping(value="searchByDirectory")
	public String searchByDirectory(
			@RequestParam("directory")		String directory,
										HttpServletResponse response,
										HttpServletRequest	request) 
	{
		try 
			{
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
				ProductJDBCTemplate pt = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
				
				ArrayList<Product> p = pt.searchByDirectory(directory);
	
				request.setAttribute("result", p);
			} 
		catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
				HttpTools.writeJSON(response, "fail");
			}
		return "result";
	}
	
	@RequestMapping(value="detailsPage")
	public String detailsPage(
			@RequestParam("code")		String id,
										HttpServletResponse response,
										HttpServletRequest	request) 
	{
		try 
			{
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
				ProductJDBCTemplate pt = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
				UserJDBCTemplate ut = context.getBean("UserJDBCTemplate", UserJDBCTemplate.class);
				
				ArrayList<Product> p = pt.getById(id);
				ArrayList<User> u=ut.getById(p.get(0).getUserId());
				ArrayList<String> pic=pt.getPics(id);
				
				request.setAttribute("pics", pic);
				request.setAttribute("user", u);
				request.setAttribute("product", p);
			} 
		catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
				HttpTools.writeJSON(response, "fail");
			}
		return "details";
	}
	
	@RequestMapping(value="/managePage")
	public String managePage(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			context = new ClassPathXmlApplicationContext("classpath*:Beans.xml");
			ProductJDBCTemplate pt = context.getBean("ProductJDBCTemplate", ProductJDBCTemplate.class);
			
			User u=(User)request.getSession().getAttribute("user");
			ArrayList<Product> p=pt.getByUserId(u.getId());

			System.out.println(u.toString()+"		/n"+p.toString());
			  
			request.setAttribute("myproduct", p);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			HttpTools.writeJSON(response, "fail");
		}
		return "manage";
	}
	@RequestMapping(value="/addPage")
	public String addPage(HttpServletRequest request, HttpServletResponse response) {
		

		return "addproduct";
	}

	

}
