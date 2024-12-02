package com.naresh.servlets;

import java.io.IOException;
import java.util.List;

import com.naresh.bean.RequestBean;
import com.naresh.dao.ViewPendingRequestsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pendingRequestsI")
public class PendingRequestsInterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session expired! Login again");
			req.getRequestDispatcher("ViewHomePageWithMsg").forward(req, res);
		}else {
			List<RequestBean> requests = new ViewPendingRequestsDAO().viewPendingRequets();
			req.setAttribute("requests", requests);
			req.getRequestDispatcher("PendingRequests.jsp").forward(req, res);
		}
	}
}
