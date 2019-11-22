package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import model.product.Product;

public class UserJDBCTemplate implements UserDAO {
	
	private DriverManagerDataSource dataSource; //Auto injected, no need to initalize
	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate jdbcTemplateObject;
	




	@Override
	public ArrayList<User> getUserByIdAndPassword(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(String id, String name, String password, String gender, String school, String campus,
			String iconPath) {
		// TODO Auto-generated method stub
		String sql="insert into user(uname,uid,password,gender,school,campus,iconPath) values "+"(?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, id);
				pst.setString(3, password);
				pst.setString(4, gender);
				pst.setString(5, school);
				pst.setString(6, campus);
				pst.setString(7, iconPath);
				return pst;
			}
			
		});		
		User u=new User();
		u.setCampus(campus);
		u.setGender(gender);
		u.setIconPath(iconPath);
		u.setPassword(password);
		u.setSchool(school);
		u.setName(name);
		u.setId(id);
		return u;
	}

	@Override
	public User updateUser(String id, String name, String password, String gender, String school, String campus,
			String iconPath) {
		// TODO Auto-generated method stub
		return null;
	}

}