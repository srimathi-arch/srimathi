package com.example.demo;

public class Students {

	private String name;
	private String gender ;
	private Integer age ;
	private String dep  ;
	private Integer fees ;
	
	
	public Students(String name, String gender, Integer age, String dep, Integer fees) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dep = dep;
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return "Students [name=" + name + ", gender=" + gender + ", age=" + age + ", dep=" + dep + ", fees=" + fees
				+ "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public Integer getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	
	
}
