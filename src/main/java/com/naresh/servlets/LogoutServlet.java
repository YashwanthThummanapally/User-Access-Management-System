package com.naresh.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session expired! Login again");
		}else {
			hs.removeAttribute("user");
			hs.invalidate();
			req.setAttribute("msg", "Logged out successfully!");
		}
		req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
	}
}
