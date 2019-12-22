package asr.proyectoFinal.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonObject;

import asr.proyectoFinal.dominio.Palabra;

public class CloudantGetRest {
	private Database db = null;
	//private static final String databaseName = "mydb";
	
	public CloudantGetRest(String databaseName){
		//databaseName = "res_madrid"
		CloudantClient cloudant = createClient();
		if(cloudant!=null){
		 db = cloudant.database(databaseName, true);
		}
	}
	
	public Database getDB(){
		return db;
	}
private static CloudantClient createClient() {
		
		String url;

		if (System.getenv("VCAP_SERVICES") != null) {
			// When running in Bluemix, the VCAP_SERVICES env var will have the credentials for all bound/connected services
			// Parse the VCAP JSON structure looking for cloudant.
			JsonObject cloudantCredentials = VCAPHelper.getCloudCredentials("cloudant");
			if(cloudantCredentials == null){
				System.out.println("No cloudant database service bound to this application");
				return null;
			}
			url = cloudantCredentials.get("url").getAsString();
		} else {
			System.out.println("Running locally. Looking for credentials in cloudant.properties");
			url = VCAPHelper.getLocalProperties("cloudant.properties").getProperty("cloudant_url");
			if(url == null || url.length()==0){
				System.out.println("To use a database, set the Cloudant url in src/main/resources/cloudant.properties");
				return null;
			}
		}

		try {
			System.out.println("Connecting to Cloudant");
			CloudantClient client = ClientBuilder.url(new URL(url)).build();
			return client;
		} catch (Exception e) {
			System.out.println("Unable to connect to database");
			//e.printStackTrace();
			return null;
		}
	}



	public ArrayList<String> getAll(String id, String name) throws IOException{
	   InputStream jo= db.getAttachment(id,name);
	   String result = IOUtils.toString(jo, StandardCharsets.UTF_8);
	   String str = result.replace("[", "").replace("]", "");
	   String[] arr= str.split(",");
	   ArrayList<String> res = new ArrayList();
	   for (String a : arr) 
          res.add(a);//System.out.println(a);
	   return res;
	   
	}
	
	public List<String> getID() {
		List<String> docs=null;
		try {
			docs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocIds();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docs;
	}
	
	public Palabra get(String id) {
		return db.find(Palabra.class, id);
}
	
}
