package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.Gson;

@SpringBootApplication
public class JsonStringToObjectApplication {

	public static  void json() {		
		Gson gson=new Gson();
		  try (Reader reader = new FileReader("/home/team/Documents/JS.json")) {
			  String line=null;
			  Person pr;
			  Gson gs=new Gson();
			  BufferedReader buffer=new BufferedReader(reader);
			  while((line =buffer.readLine() )!=null) {
				  pr=gs.fromJson(line, Person.class);
				  System.out.println(pr.getName()+" "+pr.getAge()+" "+pr.getFavoriteSport());
			  }
//	            System.out.println(pr.toString());
	            buffer.close();

		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
		
		
	}
	public static void main(String[] args) {
	 // SpringApplication.run(JsonStringToObjectApplication.class, args);
	/*	try {
		Gson gs=new Gson();
		String st="{\n" +
                "   \"name\":\"Ram Kumar\",\n" +
                "   \"age\":70,\n" +
                "   \"favoriteSport\":\"BollyBal\"\n" +
                "}";
		Person person=gs.fromJson(st, Person.class);
		System.out.println(person);
		
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		json();
		
	}

}

