/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DAO;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DecreaseProduct", urlPatterns = {"/DecreaseProduct"})
public class DecreaseProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    String id = request.getParameter("id");
    HttpSession session = request.getSession();

    String txt = (String) session.getAttribute("id");
    if (txt != null) {
    String[] ids = txt.split(",");
    List<String> updatedIds = new ArrayList<>();

    // Check if the product id exists in the cart
    boolean found = false;
    for (String cartId : ids) {
        if (cartId.equals(id)) {
            found = true;
            // Decrease the quantity by removing one occurrence
            // If quantity is 1, remove the product from the cart
            if (ids.length > 1) {
                List<String> tempList = new ArrayList<>(List.of(ids));
                tempList.remove(id);
                updatedIds = tempList;
            } else {
                updatedIds.clear(); // If quantity is 1, clear the list
            }
            break; // Exit the loop after processing the current ID
        }
    }

    // If the product id was not found, no need to update the list
    if (!found) {
        updatedIds = List.of(ids);
    }

    // Update the session with the modified cart
    String updatedCart = String.join(",", updatedIds);
    session.setAttribute("id", updatedCart);
}response.sendRedirect("ViewCart");    }
//    String txt = (String) session.getAttribute("id");
//    if (txt != null) {
//            String[] ids = txt.split(",");
//            List<String> updatedIds = new ArrayList<>();
//
//            // Check if the product id exists in the cart
//            for (String cartId : ids) {
//                if (cartId.equals(id)) {
//                    // Decrease the quantity by removing one occurrence
//                    // If quantity is 1, remove the product from the cart
//                    // Decrease the quantity by removing one occurrence
//                    // If quantity is 1, remove the product from the cart
//                    if (ids.length > 1) {
//                        List<String> tempList = new ArrayList<>(List.of(ids));
//                        tempList.remove(id);
//                        updatedIds = tempList;
//                    } else {
//                        updatedIds.clear(); // If quantity is 1, clear the list
//                    }
//                }
//            }
//
//            // Update the session with the modified cart
//            String updatedCart = String.join(",", updatedIds);
//            session.setAttribute("id", updatedCart);
//        }
//
//        response.sendRedirect("ViewCart");
//    }


        
    



//        if (txt != null) {
//            String[] ids = txt.split(",");
//            List<String> updatedIds = new ArrayList<>();
//
//            // Check if the product id exists in the cart
//            boolean found = false;
//            for (String cartId : ids) {
//                if (cartId.equals(id) && !found) {
//                    found = true;
//                    continue;
//                }
//                updatedIds.add(cartId);
//            }
//
//            // Add the product id at the end if not found
//            if (!found) {
//                updatedIds.add(id);
//            }
//
//            // Update the session with the modified cart
//            String updatedCart = String.join(",", updatedIds);
//            session.setAttribute("id", updatedCart);
//        }
//
//        response.sendRedirect("ViewCart");
//    }







        
        

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
