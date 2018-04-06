package com.proxy.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.springframework.http.HttpMethod;


public class ProxyServlet extends HttpServlet {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println(request.getParameter("url"));
		String url = request.getParameter("url");
		// Set response content type
		//response.setContentType("text/html");
		
			String nextJSP = "/index.jsp"; 
			response.setHeader("includeJSP", "true");
			response.setHeader("url", url);
			request.setAttribute("url", url);
		
URL connectTo = new URL(url);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP); 
			// dispatcher.include(request, response);
			dispatcher.forward(request,response);


	}


}
