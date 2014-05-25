package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String nickname;
	private String firstname;
	private String lastname;
	private String password;
	private ArrayList<Team> teams; //TODO: Can a user be a member of more than one team?
	private ArrayList<Task> allTasks;
	
	public int getId() {
		return user_id;
	}
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
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
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public ArrayList<Task> getAllTasks() {
		return allTasks;
	}
	public void setAllTasks(ArrayList<Task> allTasks) {
		this.allTasks = allTasks;
	}
}
