package com.naz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naz.model.User;

public class UserDao {
	
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/snakes_and_ladders?useSSL=false";
	private static final String jdbcUsername = "root";
	private static final String jdbcPassword = "root";
	private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (first_name, last_name, email, password) VALUES "
			+ " (?, ?, ?, ?);";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void saveUser(User user) {
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Boolean validUser(User user) {
		 try {  
			 Connection connection = getConnection();
			 String sql = "select email, password from user where email = '" + user.getEmail() + "'";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 ResultSet rs = preparedStatement.executeQuery();
			 while(rs.next()) {
				 String emai = rs.getString("email");
		         String pass = rs.getString("password");
				 if(emai.equals(user.getEmail()) && pass.equals(user.getPassword())) {
					 return true;
				 }
			}
		 } catch(SQLException e) {
				e.printStackTrace();
		 }
		 return false;
	}

}
