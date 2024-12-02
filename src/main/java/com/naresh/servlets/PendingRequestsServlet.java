package com.naresh.servlets;

import java.io.IOException;

import com.naresh.dao.PendingRequestsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pendingRequests")
public class PendingRequestsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired! Login again");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		} else {
			int k = new PendingRequestsDAO().updateStatus(Integer.parseInt(req.getParameter("id")),
					req.getParameter("status"));
			if (k > 0) {
				req.setAttribute("msg", "Updated status successfully!");
			} else {
				req.setAttribute("msg", "Failed to update status!");
			}
			req.getRequestDispatcher("PendingRequestsResponse.jsp").forward(req, res);
		}
	}
}
