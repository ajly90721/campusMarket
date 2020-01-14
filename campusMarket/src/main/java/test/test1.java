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
			String path = "classpath:Beans.xml";
			FileSystemXmlApplicationContext context =new FileSystemXmlApplicationContext(path);
			//user search test
			UserJDBCTemplate pt =(UserJDBCTemplate)context.getBean("UserJDBCTemplate");
			ArrayList<User> p=pt.getUserByIdAndPassword("201700301230", "303303303");
			System.out.println(p.isEmpty());
//			ProductJDBCTemplate t =(ProductJDBCTemplate)context.getBean("ProductJDBCTemplate");
//			ArrayList<Product> p=t.getAll();
//			System.out.println(p.toString());
//			boolean p1=pt.deleteProduct("20");
//			System.out.println(p1);
			//CutString test
//			String s="笔记本电脑鼠标";
//			CutString.Cut(s);




	}

}
