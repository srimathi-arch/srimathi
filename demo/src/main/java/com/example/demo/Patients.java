package com.example.demo;

public class Patients {

	private String name ;
	private int age ;
	private String Disease;
	private int amount;
	
	public Patients(String name, int age, String disease, int amount) {
		super();
		this.name = name;
		this.age = age;
		Disease = disease;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Patients [name=" + name + ", age=" + age + ", Disease=" + Disease + ", amount=" + amount + "]";
	}
	
}
