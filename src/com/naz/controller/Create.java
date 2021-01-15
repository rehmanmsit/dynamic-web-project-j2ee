package com.naz.controller;

import java.io.IOException;

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
 * Servlet implementation class create
 */
@WebServlet("/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GameBoardDao gameBoardDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
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
		request.setAttribute("page", "create");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomColour = request.getParameter("room");
		String plrColour = request.getParameter("colour");
		HttpSession session = request.getSession();
		session.setAttribute("room", roomColour);
		GameBoard gameBoard = new GameBoard((String)session.getAttribute("usrName"), plrColour, roomColour, 1);
		System.out.println("Test: " + (String)session.getAttribute("usrName") + " " + plrColour + roomColour);
		gameBoardDao.createBoard(gameBoard);
		response.sendRedirect("game");
	}

}
