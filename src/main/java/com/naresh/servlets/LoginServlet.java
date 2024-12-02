package com.naresh.servlets;

import java.io.IOException;

import com.naresh.bean.UserBean;
import com.naresh.dao.LoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new LoginDAO().login(req.getParameter("uname"), req.getParameter("pwd"));

		if (user == null) {
			req.setAttribute("msg", "Invalid login process");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("user", user);

			if (user.getRole().equalsIgnoreCase("admin")) {
				req.getRequestDispatcher("Admin.jsp").forward(req, res);
			} else if (user.getRole().equalsIgnoreCase("employee")) {
				req.getRequestDispatcher("Employee.jsp").forward(req, res);
			} else {
				req.getRequestDispatcher("Manager.jsp").forward(req, res);
			}
		}
	}
}
