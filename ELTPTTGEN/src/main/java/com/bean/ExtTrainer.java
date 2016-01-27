package com.bean;

public class ExtTrainer {

	private int trainer_id;
	private String trainer_name;
	private String city;
	private String email;
	private Subject subject;
	public ExtTrainer() {
		super();
	}
	public ExtTrainer(int trainer_id, String trainer_name, String city,
			String email, Subject subject) {
		super();
		this.trainer_id = trainer_id;
		this.trainer_name = trainer_name;
		this.city = city;
		this.email = email;
		this.subject = subject;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "ExtTrainer [trainer_id=" + trainer_id + ", trainer_name="
				+ trainer_name + ", city=" + city + ", email=" + email
				+ ", subject=" + subject + "]";
	}



}
