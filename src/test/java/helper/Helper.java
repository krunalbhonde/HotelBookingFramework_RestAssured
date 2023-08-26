package helper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Helper {
	public static RequestSpecification req;
	
	public  RequestSpecification requestdata() throws FileNotFoundException {
		
		if(req==null) {
			PrintStream log = new PrintStream(new FileOutputStream("test-output/loggong.txt"));
			req =(RequestSpecification) new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
					.setContentType("application/json").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return req;}
		return req;
			
		}
	}


