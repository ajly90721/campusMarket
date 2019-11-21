/**
 * 
 */
package model.product;

/**
 * @author Mithrandir
 *
 */
public class Product {
	private String id;
	private String name;
	private String userId;
	private String price;
	private String time;
	private String description;
	private String iconPath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", userId=" + userId + ", price=" + price
				+ ", time=" + time + ", description=" + description + ", iconPath=" + iconPath + "]";
	}
	
}
