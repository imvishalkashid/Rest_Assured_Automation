package com.poc.twitter.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.poc.qa.base.TestBase;
import com.poc.qa.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class POST_statuses_update_Test{
	
	TestBase ts=new TestBase(); 
	JsonPath js;
	String response;
	
	static String Statustext;
	
	static Logger log = Logger.getLogger(POST_statuses_update_Test.class.getName());
	
	public static ArrayList<String> testdata;
	
	@BeforeTest
	public void createTweet()
	{
	log.info("****************************** Starting test cases execution  *****************************************");	
	log.info("****************************** Loading the Base Url  *****************************************");	
	Date date= new Date();
	RestAssured.baseURI=ts.baseURI;
	Response resp= given().
	auth().oauth(ts.ConsumerKey, ts.ConsumerSecret, ts.Token, ts.TokenSecret).
	queryParam("status", "I am creating this tweet with "+date+" Automation" ).
	when().post(ts.basePath).
	then().assertThat().statusCode(ts.RESPONSE_STATUS_CODE_200).and().contentType(ContentType.JSON).and().
	extract().response();
	
	response =resp.asString();
	
	js= new JsonPath(response);
	
    Statustext=js.get("text[0]");
	
	testdata= TestUtil.getDataFromExcel();
	
	}	
	
	@Test
    public void T01_Search_Source() {
		//Verify the Source is correct
		log.info("****************************** starting 1St test case *****************************************");
		
		//String scr = "<a href=[[\"http://www.infixtechnology.com/\" rel=\"nofollow]]\">Vishalkashid</a>";
		//scr = scr.replace("[","" ).replaceAll("]","");
        Assert.assertEquals("Source name is wrong!", (testdata.get(0)), js.get("source"));
    }
	
	@Test
    public void T02_Search_Screen_name() {
		//Verify the Screen name is correct
		log.info("****************************** starting 2nd test case *****************************************");
        Assert.assertEquals("Screen name is wrong!", (testdata.get(1)), js.get("user.screen_name"));
    }
	
	@Test
    public void T03_Search_Name() {
		//Verify the name is correct
		log.info("****************************** starting 3rd test case *****************************************");
        Assert.assertEquals("Name is wrong!", (testdata.get(2)), js.get("user.name"));
    }
	
	@Test
    public void T04_Search_followers_count() { 
		//Verify the followers count is correct
		log.info("****************************** starting 4St test case *****************************************");
        Assert.assertEquals("followers count is wrong!", (Integer.parseInt(testdata.get(3))), js.get("user.followers_count"));
    }
	
	@Test
    public void T05_Search_friends_count() {
		//Verify the friends count is correct
		log.info("****************************** starting 5St test case *****************************************");
        Assert.assertEquals("friends count is wrong!", (Integer.parseInt(testdata.get(4))), js.get("user.friends_count"));
    }
	
	@Test
    public void T06_Search_Statuses_count() {
		//Verify the Statuses count is correct
		log.info("****************************** starting 6St test case *****************************************");
        Assert.assertEquals("Status count is wrong!", (Integer.parseInt(testdata.get(5))), js.get("user.statuses_count"));
    }
	
	

}
