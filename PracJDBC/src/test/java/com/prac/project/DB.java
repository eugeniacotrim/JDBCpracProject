package com.prac.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	Connection conn;
	Statement stmt;
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void createConnection() {
		String url = "jdbc:mysql://localhost:3306/pracproject";
		String username = "root";
		String password = "";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createEmp(BakeryEmp bakEmp) {
		try {
			stmt = conn.createStatement();
			String sqlString = "insert into bakeryEmp values(null, '"+bakEmp.getEmp_name()
								+"', "+bakEmp.getEmp_age()+", '"+bakEmp.getEmp_email()
								+"', '"+bakEmp.getEmp_submission()+"', "+bakEmp.getEmp_salary()+")";

			int result = stmt.executeUpdate(sqlString);
			
			String message = result > 0 ? "Employee record created..." : "Record creation UNSUCCESSFUL...";
			System.out.println(message);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void resultSet() {		
		try {
			String selectQuery = "select * from bakeryEmp";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);

			while(rs.next()) {
				Integer emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				Integer emp_age = rs.getInt("emp_age");
				String emp_email = rs.getString("emp_email");
				String emp_submission = rs.getString("emp_submission");
				Integer emp_salary = rs.getInt("emp_salary");
				System.out.println(emp_id+ " | " +emp_name+ " | " +emp_age+ " | " 
								+emp_email+ " | " +emp_submission+ " | $" +emp_salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if(conn != null) {
				conn.close();	
			} else {
				System.out.println("Connection was NOT created successfully...");
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
}
