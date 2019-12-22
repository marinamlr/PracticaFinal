package asr.proyectoFinal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asr.proyectoFinal.dao.CloudantGetRest;
import asr.proyectoFinal.dominio.Location;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*var xhr;

        xhr = new XMLHttpRequest();
        xhr.open('GET', "//ipinfo.io/json", true);
        xhr.send();

        xhr.addEventListener("readystatechange", processRequest, false);

        function processRequest(e) {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var response = JSON.parse(xhr.responseText);
                document.querySelector("#ipText").innerHTML = response.ip;
            }
        }*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Localización
		ArrayList loc = Location.locate();
		String city="madrid";//loc.get(2).toString().toLowerCase();
		
		CloudantGetRest restaurant= new CloudantGetRest("res_"+city);
		
		String choice= request.getParameter("respuesta");
		ArrayList<String> tipo= restaurant.getAll(choice, city+"_"+choice+".json");
		
		request.setAttribute("ciudad", city);
		request.setAttribute("tipo", tipo);
		request.getRequestDispatcher("pag3.jsp").forward(request, response);
		
	}

}
