package asr.proyectoFinal.dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

//import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Location{
	public static ArrayList locate() {
		ArrayList<Object> toReturn=new ArrayList();
		try {
			URL url= new URL ("https://ipapi.co/json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int status = con.getResponseCode();
			//System.out.println(status);
			if (status==200){
				BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				//System.out.println(content.getClass().getName());
				
				String str_content = content.toString();
				JsonParser parser = new JsonParser();
				JsonObject jsonContent = parser.parse(str_content).getAsJsonObject();
				
				//System.out.println(jsonContent);
				in.close();
				
				toReturn.add(jsonContent.get("latitude").getAsBigDecimal());
				toReturn.add(jsonContent.get("longitude").getAsBigDecimal());
				toReturn.add(jsonContent.get("city").getAsString());
				//System.out.println(toReturn);
			}else {
				//System.out.println("Error en la respuesta");
			}
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return toReturn;
	}
	
}