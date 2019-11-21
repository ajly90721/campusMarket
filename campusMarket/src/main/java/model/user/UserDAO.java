/**
 * 
 */
package model.user;

import java.util.ArrayList;
/**
 * 
 * User Data Access Object
 * Provide interfaces to access database, used for User management
 * Should be implemented by a Class User[API]Template, e.g. UserJDBCTemplate
 * @author Mithrandir
 *
 */
public interface UserDAO {
	/**
	 * Return all founded Users (even more than one founded)
	 * @param id
	 * @param password
	 * @return
	 * 
	 */
	public ArrayList<User> getUserByIdAndPassword(String id, String password);
	
	/**
	 * @param id
	 * should be Unique
	 * @param name
	 * can be duplicated
	 * @param password
	 * @param gender
	 * @param school
	 * @param campus
	 * @param iconPath
	 * can be empty
	 * @return
	 * Return newly added user
	 */
	public User addUser(String id, String name, String password, String gender, String school, String campus, String iconPath);
	
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param gender
	 * @param school
	 * @param campus
	 * @param iconPath
	 * @return
	 * Return newly updated user
	 */
	public User updateUser(String id, String name, String password, String gender, String school, String campus, String iconPath);
}
