package asr.proyectoFinal.services;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
//import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class Traductor
{
	public static String translate(String palabra, String sourceModel, String destModel, boolean conversational)
	{
		String model;
		if(sourceModel.equals("en") || destModel.equals("en"))
		{
			model=sourceModel+"-"+destModel;
			if(conversational) 
				model+="-conversational";
		}
		else
			return translate(translate(palabra,sourceModel,"en",conversational),"en",destModel,conversational);
	
		IamAuthenticator authenticator = new IamAuthenticator("qdpYE-ZUnZpYPrAZGq_2_gXT8KQuJYquMy9hQulql1me");
		LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", authenticator);
		languageTranslator.setServiceUrl("https://gateway-lon.watsonplatform.net/language-translator/api");
		
		TranslateOptions translateOptions = new TranslateOptions.Builder()
		 .addText(palabra)
		 .modelId(model)
		 .build();
	
		TranslationResult translationResult = languageTranslator.translate(translateOptions).execute().getResult();
		
		//System.out.println(translationResult);

		String traduccionJSON = translationResult.toString();
		JsonParser parser = new JsonParser();
		JsonObject rootObj =
		parser.parse(traduccionJSON).getAsJsonObject();
		JsonArray traducciones = rootObj.getAsJsonArray("translations");
		String traduccionPrimera = palabra;
		if(traducciones.size()>0)
		traduccionPrimera =
		traducciones.get(0).getAsJsonObject().get("translation").getAsString();
		return traduccionPrimera;

		
	}
}