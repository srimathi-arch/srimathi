package com.example.demo;

public class employee {

	private String name;
	private Integer age;
	private String department;
	private String gender;
	private Integer salary;
	
	public employee(String name, Integer age, String department, String gender,Integer salary) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.gender = gender;
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return "employee [name=" + name + ", age=" + age + ", department=" + department + ", gender=" + gender + ", salary=" + salary + "]";
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
