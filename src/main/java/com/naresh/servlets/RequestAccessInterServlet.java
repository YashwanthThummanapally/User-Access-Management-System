package com.naresh.servlets;

import java.io.IOException;
import java.util.List;

import com.naresh.bean.SoftwareBean;
import com.naresh.dao.FetchSoftwaresDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/requestAccessI")
public class RequestAccessInterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired! Login again");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		} else {
			List<SoftwareBean> softwares = new FetchSoftwaresDAO().selectAllSoftware();
			req.setAttribute("softwares", softwares);

			req.getRequestDispatcher("RequestAccess.jsp").forward(req, res);
		}
	}
}
