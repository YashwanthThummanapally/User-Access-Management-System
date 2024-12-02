package com.naresh.servlets;

import java.io.IOException;

import com.naresh.bean.SoftwareBean;
import com.naresh.dao.CreateSoftwareDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/createSoftware")
public class CreateSoftwareServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session expired! Login again");
			req.getRequestDispatcher("ViewHomePageWithMsg.jsp").forward(req, res);
		}else {
			SoftwareBean software = new SoftwareBean();
			
			String[] accessTypes = req.getParameterValues("access");
			String accessType = "";
			
			for(String type : accessTypes) {
				accessType += type+" ";
			}
			
			software.setSoftwareName(req.getParameter("swname"));
			software.setDescription(req.getParameter("des"));
			software.setAccessLevels(accessType);
			
			int k = new CreateSoftwareDAO().createSoftware(software);
			if(k<0) {
				req.setAttribute("msg", "Failed to create a software!");
			}else {
				req.setAttribute("msg", "Software added successfully!");
			}
			req.getRequestDispatcher("CreateSoftwareResponse.jsp").forward(req, res);
		}
	}
}
