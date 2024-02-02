package com.prac.project;

public class Connection {

	public static void main(String[] args) {

		DB db = new DB();
		db.createConnection();
		
		BakeryEmp bakEmp = new BakeryEmp();
		bakEmp.setEmp_name("Josiah Gullivan");
		bakEmp.setEmp_age(44);
		bakEmp.setEmp_email("jg@example.com");
		bakEmp.setEmp_submission("2015-05-30");
		bakEmp.setEmp_salary(1800);
			
		db.createEmp(bakEmp);

		db.resultSet();
		db.closeConnection();
		
	}
}