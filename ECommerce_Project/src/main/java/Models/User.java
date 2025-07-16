package Models;

public class User 
{
	private long userId;
	private String username;
	private String email;
	private long phonenumber;
	private String password;
	private String role;
	private String address;
	
	public User() {
		super();
	}
	
	public User(int userId, String username, String email, long phonenumber, String password,String role, String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.role = role;
		this.address = address;
	}

	public User(String username, String email, long phonenumber, String password,String role, String address) {
		super();
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.role = role;
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", phonenumber=" + phonenumber + ", address=" + address + "]";
	}
	
	
}
