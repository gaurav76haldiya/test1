package com.example.demo;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HttpController {
	
	static String url="https://www.javatpoint.com/";
	
	@GetMapping("/get")
	public  ResponseEntity<String> get() {
        
		String resultContent = null;
        HttpGet httpGet = new HttpGet(url);
      
        System.out.println("Controller...");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try  
        {
            CloseableHttpResponse response = httpclient.execute(httpGet); 
            try{
                // Get status code
                System.out.println(response.getVersion());
                System.out.println(response.getCode()); // 200
                System.out.println(response.getReasonPhrase()); // OK
                
                HttpEntity entity = response.getEntity();
                // Get response information
                
                resultContent = EntityUtils.toString(entity);
            }
            catch(IOException e) {
				System.out.println("Exception is occure");
			}
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().body(resultContent);
	}
	
}

