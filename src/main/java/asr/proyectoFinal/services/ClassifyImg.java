package asr.proyectoFinal.services;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

public class ClassifyImg {

  public static String clasificar(InputStream imagesStream) throws FileNotFoundException {

	  IamAuthenticator authenticator = new IamAuthenticator("c5ERCRSLR2IbM9ukoLEJM8IFO6D9rVdufwJeQrJHOoNt");
	  VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", authenticator);
	  visualRecognition.setServiceUrl("https://gateway.watsonplatform.net/visual-recognition/api");

	  ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
	    .imagesFile(imagesStream)
	    .imagesFilename("X")
	    .classifierIds(Arrays.asList("food"))
	    .build();
	  ClassifiedImages image_result = visualRecognition.classify(classifyOptions).execute().getResult();
	  
	  String imageJSON = image_result.toString();
	  JsonParser parser = new JsonParser();
	  JsonObject rootObj = parser.parse(imageJSON).getAsJsonObject();
	  JsonObject third = (JsonObject) rootObj.getAsJsonArray("images").get(0);
	  JsonObject food= (JsonObject) third.getAsJsonArray("classifiers").get(0);
	  
	  JsonArray solArray=food.getAsJsonArray("classes");
	  
	  float prob;
	  float max= Float.parseFloat(solArray.get(0).getAsJsonObject().get("score").getAsString());
	  String final_dish=solArray.get(0).getAsJsonObject().get("class").getAsString();
	  for(int i=0; i<solArray.size();i++) {
		  JsonObject jo=(JsonObject) solArray.get(i);
		  String food_type=solArray.get(i).getAsJsonObject().get("class").getAsString();
		  String food_prob=solArray.get(i).getAsJsonObject().get("score").getAsString();
		  prob= Float.parseFloat(food_prob);
		  if (prob > max) {
			  max=prob;
			  final_dish=food_type;
		  }
	  }
	  System.out.println(final_dish);
	  System.out.println(Float.toString(max));
	  
	  return final_dish;
		  
  }

}

