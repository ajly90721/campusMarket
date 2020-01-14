package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

@Component
public class ProductJDBCTemplate implements ProductDAO {

	@Autowired
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
			String iconPath, String directory) {
		// TODO Auto-generated method stub
		String sql="insert into Product(name,userid,price,time,description,iconPath,directory) values (?,?,?,?,?,?,?)";
		GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplateObject.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst=con.prepareStatement(sql,new String[] {"id"});
				pst.setString(1, name);
				pst.setString(2, userId);
				pst.setString(3, price);
				pst.setString(4, time);
				pst.setString(5, description);
				pst.setString(6, iconPath);
				pst.setString(7, directory);
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
		p.setPrice(price);
		p.setDirectory(directory);
		p.setId(keyHolder.getKey().toString());
		return p;
	}

	@Override
	public boolean deleteProduct(String id) {
		// TODO Auto-generated method stub
		String sql="update Product set status = 'deleted' where id='"+id+"'";

	    int count=jdbcTemplateObject.update(sql);
	    if(count!=0) {
	        return true;
	    }
	    return false;
	    
	}

	@Override
	public Product updateProduct(String id, String name, String userId, String price, String time, String description,
			String iconPath, String directory) {
		// TODO Auto-generated method stub
		String sql="update Product set (name,userid,price,time,description,iconPath,directory) = (?,?,?,?,?,?) where id="+id;

		jdbcTemplateObject.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, userId);
				pst.setString(3, price);
				pst.setString(4, time);
				pst.setString(5, description);
				pst.setString(6, iconPath);
				pst.setString(7, directory);
				return pst;
			}
			
		});		
		Product p=new Product();
		p.setDescription(description);
		p.setIconPath(iconPath);
		p.setName(name);
		p.setTime(time);
		p.setUserId(userId);
		p.setId(id);
		p.setPrice(price);
		p.setDirectory(directory);
		return p;
	}

	@Override
	public ArrayList<Product> searchProduct(String name, String school, String campus, String directory) {
		// TODO Auto-generated method stub
		String sql="select * from Product natural join user where name='"+name+"'"+" and directory='"+directory+"'"+" and school ='"+school+"' and campus ='"+campus+"'";

		
		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					return p;
				}
				
				});
		return list;
	}
	
	public ArrayList<Product> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from Product";

		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					return p;
				}
				
				});
		return list;
	}
	
	public ArrayList<Product> searchByDirectory(String directory) {
		// TODO Auto-generated method stub
		String sql="select * from Product where directory ='"+directory+"'";

		
		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					return p;
				}
				
				});
		return list;
	}
	
	public ArrayList<Product> getById(String Id) {
		// TODO Auto-generated method stub
		String sql="select * from Product where id ="+Id+"";

		
		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					
					return p;
				}
				
				});
		return list;
	}
	
	public ArrayList<Product> getByUserId(String UserId) {
		// TODO Auto-generated method stub
		String sql="select * from Product where userid ='"+UserId+"'";

		
		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					
					return p;
				}
				
				});
		return list;
	}
	
	public ArrayList<String> getPics(String Id) {
		// TODO Auto-generated method stub
		String sql="select * from product_pics where id ='"+Id+"'";

		
		 ArrayList<String> list = (ArrayList<String>) jdbcTemplateObject.query(sql, new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					return rs.getString("iconPath");
				}
				
				});
		return list;
	}
	
	public ArrayList<Product> getLimits(int limit) {
		// TODO Auto-generated method stub
		String sql="select * from Product LIMIT "+limit;

		
		 ArrayList<Product> list = (ArrayList<Product>) jdbcTemplateObject.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Product p=new Product();
					p.setDescription(rs.getString("description"));
					p.setIconPath(rs.getString("iconPath"));
					p.setName(rs.getString("name"));
					p.setTime(rs.getString("time"));
					p.setUserId(rs.getString("userid"));
					p.setId(rs.getString("id"));
					p.setPrice(rs.getString("price"));
					p.setDirectory(rs.getString("directory"));
					
					return p;
				}
				
				});
		return list;
	}
	
}
