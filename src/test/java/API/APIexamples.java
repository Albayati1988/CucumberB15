package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APIexamples {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNTg0NzYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTEwMTY3NiwidXNlcklkIjoiNTQxOSJ9.6RyL4TzUdiJTuuTAdtR_Eyec2LZ7dDK44XPPJ-WXtXA";
    @Test
    public void CreateANEmployee(){

       RequestSpecification prepareRequest =given().header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Alaa\",\n" +
                        "  \"emp_lastname\": \"Saeed\",\n" +
                        "  \"emp_middle_name\": \"Hu\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2010-01-01\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Qa Engineer\"\n" +
                        "}");

        //act as a send key
//        pepared request --> attached all the data for the request
        Response response = prepareRequest.when().post("/createEmployee.php");
        response.prettyPrint();


//        verification of status
        response.then().assertThat().statusCode(201);

//        verify the body or the data
//    in order to verify that the value of the key "Message" is "Employee_created"
//        actualvalue=coming from the response
        String expectedvalue = "Employee Created";

//        get the actual value out of the response  ---> This is the only task that is tough

        String actualValue = response.jsonPath().getString("Message");
        System.out.println(actualValue);

//        verify
        Assert.assertEquals(actualValue,expectedvalue);

//        verify that  emp_job_title" is Cloud Architect
//        actual=coming from response
        String expected = "Cloud Architect";
        String actual = response.jsonPath().getString("Employee.emp_job_title");
        Assert.assertEquals(expected,actual);

    }

}
