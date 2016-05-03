package com.cloudant;

import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.cloudant.client.api.*;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class CloudantAPI extends HttpServlet {

  private static final long serialVersionUID = 1L;

  // Cloudant access data
  String databaseURL;
  String databaseUsername;
  String databasePassword;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudantAPI() {
        super();

        databaseURL = "http://192.168.99.100:5984"; // TODO Change URL to the correct Docker container
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    CloudantClient client = ClientBuilder.url(new URL(databaseURL)).build();

    List<String> databases = client.getAllDbs();

    response.getWriter().print( "{\n" +
      "server-version: " + client.serverVersion() + ",\n" +
      "databases: " + databases + "\n" +
    "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
