package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import pageObject.BookingPage;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.testng.Assert;

import helper.Helper;
public class Booking extends Helper {

	File f = new File(System.getProperty("user.dir")+"//src//test//resources//javaCollection//booking.json");
 RequestSpecification res;
 BookingPage response;

		@Given("create request using payload")
		public void create_request_using_payload() throws FileNotFoundException {
		 //  RestAssured.baseURI ="https://restful-booker.herokuapp.com";
		   res =given().spec(requestdata()).body(f); 
		}

		@When("Add resourse And hit post method")
		public void add_resourse_and_hit_post_method() {
			response =res.when().post("/booking").as(BookingPage.class);
	
	}

		@Then("verify booking id")
		public void verify_booking_id() {
		   int bookid = response.bookingid;
		  String checkindate = response.booking.bookingdates.checkin;
		  Assert.assertEquals("2018-01-01", checkindate);
		}

		@Then("verify status code")
		public void verify_status_code() {
		res.then().statusCode(200);   
		}




	}


