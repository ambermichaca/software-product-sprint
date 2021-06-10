package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //make arraylist with three unique strings 
    ArrayList<String> phrases = new ArrayList<>();
    phrases.add("Hello!"); 
    phrases.add("Hola!");
    phrases.add("Namaste!");

    //convert list to Json using function bellow 
    String json = convertToJsonUsingGson(phrases);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
  /**
   * Converts an ArrayList into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(ArrayList<String> phrases) {
    Gson gson = new Gson();
    String json = gson.toJson(phrases);
    return json;
  }

}
