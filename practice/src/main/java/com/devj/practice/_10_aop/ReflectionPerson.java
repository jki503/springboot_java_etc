package com.devj.practice._10_aop;

public class ReflectionPerson {

	private String name;
	private Integer age;
	private String address;

	public ReflectionPerson(String name, Integer age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public ReflectionPerson() {};

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
}
