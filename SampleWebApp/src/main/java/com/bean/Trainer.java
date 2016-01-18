package com.bean;

public class Trainer {

	private int trainer_id;
    private String trainer_name;
    private String city;
    private String email;
    
    
	public Trainer() {
		super();
	}
	public Trainer(String trainer_name, String city,
			String email) {
		super();
		this.trainer_name = trainer_name;
		this.city = city;
		this.email = email;
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
	@Override
	public String toString() {
		return "Trainer [trainer_id=" + trainer_id + ", trainer_name="
				+ trainer_name + ", city=" + city + ", email=" + email + "]";
	}
    
    
    

}
