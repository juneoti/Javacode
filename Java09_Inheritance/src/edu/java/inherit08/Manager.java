package edu.java.inherit08;

public class Manager extends Employee {
	private String type;

	public Manager() {}

	public Manager(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void test() {
		System.out.println("매니저");
	}

	
}
