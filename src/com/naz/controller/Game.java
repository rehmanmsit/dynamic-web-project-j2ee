package com.naz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naz.dao.GameBoardDao;
import com.naz.model.GameBoard;

/**
 * Servlet implementation class game
 */
@WebServlet("/game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private GameBoardDao gameBoardDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
    	gameBoardDao = new GameBoardDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("layout.jsp");
		request.setAttribute("page", "game");
		HttpSession session = request.getSession();
		List<GameBoard> gameBoard = gameBoardDao.fetchByRoom((String)session.getAttribute("room"));
		GameBoard myGameBoard = gameBoardDao.fetchByEmail((String)session.getAttribute("usrName"));
		System.out.println((String)session.getAttribute("room"));
		request.setAttribute("gameBoard", gameBoard);
		request.setAttribute("myGameBoard", myGameBoard);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String existingPlace = request.getParameter("existingPlace");
		String diceNumber = request.getParameter("diceNumber");
		HttpSession session = request.getSession();
		GameBoard gameBoard = gameBoardDao.fetchByEmail((String)session.getAttribute("usrName"));
		int newValue = Integer.valueOf(existingPlace) + Integer.valueOf(diceNumber);
		gameBoard.setPlace(newValue);
		gameBoardDao.updateBoard(gameBoard);
		response.sendRedirect("game");
	}

}
