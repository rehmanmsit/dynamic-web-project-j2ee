package com.naz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naz.model.GameBoard;

public class GameBoardDao {

	private static final String jdbcURL = "jdbc:mysql://localhost:3306/snakes_and_ladders?useSSL=false";
	private static final String jdbcUsername = "root";
	private static final String jdbcPassword = "root";
	private static final String INSERT_USERS_SQL = "INSERT INTO game_board" + "  (user_name, colour, room_colour, place) VALUES "
			+ " (?, ?, ?, ?);";
	
	private static final String UPDATE_USERS_SQL = "UPDATE game_board set place = ? where user_name = ? ;";
	
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

	public void createBoard(GameBoard gameBoard) {

		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, gameBoard.getUserName());
			preparedStatement.setString(2, gameBoard.getColour());
			preparedStatement.setString(3, gameBoard.getRoomColour());
			preparedStatement.setInt(4, gameBoard.getPlace());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateBoard(GameBoard gameBoard) {

		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			preparedStatement.setInt(1, gameBoard.getPlace());
			preparedStatement.setString(2, gameBoard.getUserName());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public GameBoard fetchByEmail(String email) {

		try {  
			Connection connection = getConnection();
			String sql = "select * from game_board where user_name = '" + email + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			GameBoard gameBoard;
			while(rs.next()) {
				String userName = rs.getString("user_name");
				String colour = rs.getString("colour");
				String roomColour = rs.getString("room_colour");
				int place = rs.getInt("place");
				gameBoard = new GameBoard(userName, colour, roomColour, place);
				System.out.println(userName +" "+ colour +" "+ roomColour);
				return gameBoard;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<GameBoard> fetchByRoom(String room) {

		try {  
			Connection connection = getConnection();
			String sql = "select * from game_board where room_colour = '" + room + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<GameBoard> gameBoards = new ArrayList<GameBoard>();
			while(rs.next()) {
				String userName = rs.getString("user_name");
				String colour = rs.getString("colour");
				String roomColour = rs.getString("room_colour");
				int place = rs.getInt("place");
				GameBoard gameBoard = new GameBoard(userName, colour, roomColour, place);
				gameBoards.add(gameBoard);
			}
			return gameBoards;
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<String> fetchRooms() {
		try {  
			Connection connection = getConnection();
			String sql = "select DISTINCT(room_colour) from game_board";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			List<String> roomClours = new ArrayList<String>();
			while(rs.next()) {
				roomClours.add(rs.getString("room_colour"));
			}
			return roomClours;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
