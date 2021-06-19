package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;


@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the text entered in the form. Sanitize user input to remove HTML tags and JavaScript.
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    long timestamp = System.currentTimeMillis();

    //create instance of datastore 
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    //create key 
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("ContactInfo");

    FullEntity contactInfoEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("email", email) 
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactInfoEntity); 

    //redirects user to original URL once text is submitted 
    response.sendRedirect("/index.html"); 

  // Print the value so you can see it in the server logs.
   // System.out.println("You submitted: " + timestamp);

    // Write the value to the response so the user can see it.
   // response.getWriter().println("You submitted: " + email);

  }
}