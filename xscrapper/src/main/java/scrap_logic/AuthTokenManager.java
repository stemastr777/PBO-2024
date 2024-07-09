package scrap_logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AuthTokenManager {

	
	private static final String FILE_NAME = "auth_tokens.txt";

   public static void main(String[] args) {
//       findAuthTokens("user123", "pass123");
   }
	 
   public static void saveAuthToken(String username, String password, String authToken) {
   File file = new File(FILE_NAME);

   try {
       // Check if file exists, create it if it doesn't
       if (!file.exists()) {
           file.createNewFile();
       }

       // Append data to the file
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
           writer.write(username + "," + password + "," + authToken);
           writer.newLine();
       }

       System.out.println("Auth token saved successfully.");
   } catch (IOException e) {
       System.err.println("An error occurred while saving the auth token.");
           e.printStackTrace();
       }
   }
     
   public static String findAuthTokens(String username_to_find, String password_to_find) {
    	 File file = new File(FILE_NAME);

	        // Check if the file exists
	        if (!file.exists()) {
	            System.out.println("File does not exist.");
	            return null;
	        }

	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String username = parts[0];
	                    String password = parts[1];
	                    String auth_token = parts[2];
	                    
	                    if ((username_to_find.equals(username) ) && (password_to_find.equals(password))) {
	                    	
	                    	System.out.println("Autentikasi berhasil.");
	                    	return auth_token;
	                    }
	                } else {
	                    System.out.println("Invalid line format: " + line);
	                }
	            }
	            
	            System.out.println("User tidak ditemukan.");
	        
	        } catch (IOException e) {
	            System.err.println("An error occurred while reading the auth tokens.");
	            e.printStackTrace();
	        }
			return null;
     }

   public static Boolean findUsername(String username_to_find) {
	   File file = new File(FILE_NAME);

       // Check if the file exists
       if (!file.exists()) {
           System.out.println("File does not exist.");
           return null;
       }

       try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(",");
               if (parts.length == 3) {
                   String username = parts[0];
                   
                   if (username_to_find.equals(username)) {
                   	
                   		return true;
                   }
               } else {
                   System.out.println("Invalid line format: " + line);
               }
           }
           
       } catch (IOException e) {
           System.err.println("An error occurred while reading the auth tokens.");
           e.printStackTrace();
       }
       return false;
   }
}
