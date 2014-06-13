package ua.epamcourses.task4.domain;

public class User {

	public static final Integer UNKNOWN_USER = 0;
	public static final Integer NURSE = 1;
	public static final Integer DOCTOR = 2;
	public static final Integer ADMINISTRATOR = 3;
	
	public static final User GUEST = new User(0, "Guest", UNKNOWN_USER, "");
	
	private Integer userID;
	private String login;
	private Integer role;
	private String password;
	
	public User() {	}

	public User(Integer userID, String login, Integer role, String password) {
		this.userID = userID;
		this.login = login;
		this.role = role;
		this.password = password;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
