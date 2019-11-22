package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ProductJDBCTemplate implements ProductDAO {

	private DriverManagerDataSource dataSource;
	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	//Auto injected, no need to initalize
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	private JdbcTemplate jdbcTemplateObject;

	@Override
	public Product addProduct(String name, String userId, String price, String time, String description,
			String iconPath) {
		// TODO Auto-generated method stub
		String sql="insert into Product(pname,uid,price,time,description,iconPath) values "+"(?,?,?,?,?,?)";
		GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplateObject.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst=con.prepareStatement(sql,new String[] {"pid"});
				pst.setString(1, name);
				pst.setString(2, userId);
				pst.setString(3, price);
				pst.setString(4, time);
				pst.setString(5, description);
				pst.setString(6, iconPath);
				return pst;
			}
			
		},
				keyHolder);		
		Product p=new Product();
		p.setDescription(description);
		p.setIconPath(iconPath);
		p.setName(name);
		p.setTime(time);
		p.setUserId(userId);
		p.setId(keyHolder.getKey().toString());
		return p;
	}

	@Override
	public boolean deleteProduct(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product updateProduct(String id, String name, String userId, String price, String time, String description,
			String iconPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> searchProduct(String name, String school, String campus) {
		// TODO Auto-generated method stub
/*		Product p= (Product) jdbcTemplateObject.query("insert into Product(pname,uid,price,time,description,iconPath) values "+"'"+name+"'"+"'"+userId+"'"+"'"+price+"'"+"'"+time+"'"+"'"+description+"'"+"'"+iconPath+"'", new ResultSetExtractor() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Product pp=new Product();
				while (rs.next()) {  
                    pp.setId(rs.getInt("N_ID"));  
                    pp.setName(rs.getString("C_NAME"));  

                 }  
                 return pp;  
			}
			});
			*/
		return null;
	}


}
