package com.naresh.servlets;

import java.io.IOException;

import com.naresh.bean.UserBean;
import com.naresh.dao.SignupDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean employee = new UserBean();
		
		employee.setUsername(req.getParameter("uname"));
		employee.setPassword(req.getParameter("pwd"));
		employee.setRole(req.getParameter("role"));

		int k = new SignupDAO().register(employee);
		if(k>0) {
			req.setAttribute("msg", "Registration successful!");
		}else {
			req.setAttribute("msg", "Registration failed!");
		}
		req.getRequestDispatcher("Signup.jsp").forward(req, res);
	}
}
