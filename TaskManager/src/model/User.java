package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String nickname;
	private String firstname;
	private String lastname;
	private String password;
	private String salt;
	private ArrayList<Task> allTasks;
	
	public String getId() {
		return user_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setId(String user_id) {
		this.user_id = user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public ArrayList<Task> getAllTasks() {
		return allTasks;
	}
	public void setAllTasks(ArrayList<Task> allTasks) {
		this.allTasks = allTasks;
	}
}
