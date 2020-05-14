package miu.edu.cs.cs472.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import miu.edu.cs.cs472.model.ContactMessage;

public class JSONUtils {
	
	//public static final String JSON_FILE_LOCATION = "../database/contactmessage_data.json";
	//public static final String JSON_FILE_LOCATION = "./contactmessage_data.json";
	public static final String JSON_FILE_LOCATION = "C:\\Users\\Huy\\eclipse-workspace-2020\\Wap_CustomContactMessage_SOA_AJAX\\src\\miu\\edu\\cs\\cs472\\util\\contactmessage_data.json";
	
    public static JsonSerializer<LocalDate> getJsonLocalDateSerializer() {
        return new JsonSerializer<LocalDate>() {
            @Override
            public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                return null;
            }
        };
    }

    public static JsonDeserializer<LocalDate> getJsonLocalDateDeserializer() {
        return new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException, DateTimeParseException {
                return json == null ? null : LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_DATE);
            }
        };
    }
    
    public static List<ContactMessage> getDataFromJSONFile() {
    	List<ContactMessage> contactMessages = null;
    	try {
    	    Gson gson = new Gson();
    	    //InputStream is = JSONUtils.class.getResourceAsStream(JSON_FILE_LOCATION);
    	    //BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    	    BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE_LOCATION));
    	    contactMessages = Arrays.asList(gson.fromJson(reader, ContactMessage[].class));
    	    
    	    System.out.println(contactMessages);

    	    reader.close();

    	} catch (Exception ex) {
    	    ex.printStackTrace();
    	}
    	
		return contactMessages;
		
    }

	public static void createNewJSONRecord(List<ContactMessage> contactMessages, ContactMessage contactMessage) {
			//System.out.println("In createNewJSONRecord");	
			//contactMessage.setId(newId);
			//System.out.println(contactMessage);
			//System.out.println(contactMessages);
			//contactMessages.add(contactMessage);
			List<ContactMessage> newList = new ArrayList<ContactMessage>();
			//System.out.println("newlist1: " + newList);
			for (ContactMessage cm: contactMessages) {
				newList.add(cm);
			}
			//System.out.println("newlist2: " + newList);
			newList.add(contactMessage);
			System.out.println("newlist: " + newList);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			BufferedWriter writer;
			try {
				writer = Files.newBufferedWriter(Paths.get(JSON_FILE_LOCATION));
				gson.toJson(newList, writer); 
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
	}
	
}
