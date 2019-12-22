package asr.proyectoFinal.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;


public class WatAssis {
	public static String hablar(String plato) {
		IamAuthenticator authenticator = new IamAuthenticator("bEOGQBSm6D9hYrg9LIzM_l7FR7NYXGMLfqpycKFsKYSA");
		Assistant service = new Assistant("2019-02-28", authenticator);
		service.setServiceUrl("https://gateway-lon.watsonplatform.net/assistant/api");

		MessageInput input = new MessageInput.Builder()
		  .messageType("text")
		  .text(plato)
		  .build();
		
		CreateSessionOptions options = new CreateSessionOptions.Builder("6fd55aba-2c14-49cd-9bf0-c4cd8aecaa5c").build();
		SessionResponse id_response = service.createSession(options).execute().getResult();
		
		String idJSON = id_response.toString();
		JsonParser parser = new JsonParser();
		JsonObject rootObj = (JsonObject) parser.parse(idJSON).getAsJsonObject();
		String id = rootObj.get("session_id").getAsString();

		MessageOptions options_msg = new MessageOptions.Builder("6fd55aba-2c14-49cd-9bf0-c4cd8aecaa5c", id)
		  .input(input)
		  .build();

		MessageResponse response = service.message(options_msg).execute().getResult();
		
		
		String resp = response.toString();
		JsonParser parser2 = new JsonParser();
		JsonObject rootObj2 = parser2.parse(resp).getAsJsonObject();
		JsonObject arr2= (JsonObject) rootObj2.get("output");
		JsonObject arr3 = (JsonObject) arr2.getAsJsonArray("generic").get(0);
		String dish = arr3.get("text").getAsString();
		
		return dish;
	}
}
