package model.user;

import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserJDBCTemplate implements UserDAO {
	
	private DataSource dataSource; //Auto injected, no need to initalize
	private JdbcTemplate jdbcTemplateObject;
	
	public DataSource getDatasource() {
		return dataSource;
	}

	public void setDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}



	@Override
	public ArrayList<User> getUserByIdAndPassword(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(String id, String name, String password, String gender, String school, String campus,
			String iconPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String id, String name, String password, String gender, String school, String campus,
			String iconPath) {
		// TODO Auto-generated method stub
		return null;
	}

}
