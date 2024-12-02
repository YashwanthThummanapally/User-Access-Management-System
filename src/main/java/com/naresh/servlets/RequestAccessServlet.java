package com.naresh.servlets;

import java.io.IOException;

import com.naresh.bean.RequestBean;
import com.naresh.bean.UserBean;
import com.naresh.dao.FetchSoftwareDAO;
import com.naresh.dao.RequestAccessDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/requestAccess")
public class RequestAccessServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session expired! Login again.");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		} else {
			UserBean user = (UserBean) hs.getAttribute("user");

			RequestBean request = new RequestBean();
			request.setUserId(user.getUserId());
			request.setSoftwareId(new FetchSoftwareDAO().getSoftwareId(req.getParameter("swname")));
			request.setAccessType(req.getParameter("accessType"));
			request.setReason(req.getParameter("reason"));
			request.setStatus("PENDING");
			 
//			System.out.println(request);
			
			int k = new RequestAccessDAO().insertRequestAccess(request);
			if(k>0) {
				req.setAttribute("msg", "Requested access successfully!");
			}else {
				req.setAttribute("msg", "Request for access failed!");
			}
			req.getRequestDispatcher("RequestAccessResponse.jsp").forward(req, res);
		}
	}
}
