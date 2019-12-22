package asr.proyectoFinal.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import asr.proyectoFinal.dao.CloudantPalabraStore;
import asr.proyectoFinal.dominio.Location;
import asr.proyectoFinal.dominio.Palabra;
import asr.proyectoFinal.services.ClassifyImg;
import asr.proyectoFinal.services.Traductor;
import asr.proyectoFinal.services.WatAssis;

/**
 * Servlet implementation class Controller
 */
//@WebServlet(urlPatterns = {"/listar", "/insertar", "/hablar"})
@MultipartConfig
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(request.getServletPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//out.println("<html lang=\"es\"><head><meta charset=\"UTF-8\"></head><body>");
		CloudantPalabraStore store = new CloudantPalabraStore();
		Palabra palabra = new Palabra();
		
		Part file = request.getPart("fileToUpload");
        InputStream filecontent = file.getInputStream();

       
        if(store.getDB() == null) 
		{
			out.println(String.format("Palabra: %s", palabra));
		}
		else
		{
			
			String imagen=ClassifyImg.clasificar(filecontent);
			String imagen_esp=Traductor.translate(imagen, "en", "es", false);
			
			//System.out.println(imagen_esp);
			
			palabra.setName(imagen_esp);
			store.persist(palabra);

			String frase=WatAssis.hablar(imagen);
			String frase_esp=Traductor.translate(frase, "en", "es", false);
			
			request.setAttribute("esp",imagen_esp);
			request.setAttribute("eng", imagen);
			request.setAttribute("wat", frase);
			request.setAttribute("wat_esp", frase_esp);

			request.getRequestDispatcher("pag2.jsp").forward(request, response);
			
			
			
			
		}
        
		//out.println("</html>");
        
        
	}

}
