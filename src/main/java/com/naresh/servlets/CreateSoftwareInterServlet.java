package com.naresh.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/createSoftwareI")
public class CreateSoftwareInterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired! Login again");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("CreateSoftware.jsp").forward(req, res);
		}
	}
}
