package test;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import model.product.Product;
import model.product.ProductJDBCTemplate;
import model.user.User;
import model.user.UserJDBCTemplate;
import tools.CutString;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			// TODO Auto-generated method stub
		//product test
//			String path = "classpath:Beans.xml";
//			FileSystemXmlApplicationContext context =new FileSystemXmlApplicationContext(path);
//			//user test
//			UserJDBCTemplate pt =(UserJDBCTemplate)context.getBean("UserJDBCTemplate");
//			ArrayList<User> p=pt.getUserByIdAndPassword("201700301230", "303303303");
//			System.out.println(p.isEmpty());
//			ProductJDBCTemplate t =(ProductJDBCTemplate)context.getBean("ProductJDBCTemplate");
//			ArrayList<Product> p=t.getAll();
//			System.out.println(p.toString());
//			boolean p=pt.deleteProduct("20");
//			System.out.println(p);
		String s="笔记本 电 脑鼠标";
		CutString.Cut(s);




	}

}
