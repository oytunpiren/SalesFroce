package utilities;

import ApiModels.RequestBody;
import ApiModels.ResponseBody;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ApiUtility {

    private static ResponseBody responseBody;

    public static void hitGet(String resource) {
        String uri = ConfigurationReader.getProperty("baseURL") + resource;


        Response response = RestAssured.get(uri);
        System.out.println(response.statusCode());
        System.out.println(response.asString());


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResponseBody getResponseBody() {
        return responseBody;
    }


    public static void hitPost(String resource, RequestBody body) {
        String uri = ConfigurationReader.getProperty("baseURL") + resource;
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJson = "";
        try {

            bodyJson = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJson).
                when().post(uri);

        System.out.println(response.statusCode());
        System.out.println(response.asString());


        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void hitDelete(String resource) {
        String uri = ConfigurationReader.getProperty("baseURL") + resource;

        Response response = RestAssured.delete(uri);
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (Exception e) {
            System.out.println("wrong");
        }
    }

    public static void hitPut(String resources, RequestBody body) {

        String uri = ConfigurationReader.getProperty("baseURL") + resources;

        ObjectMapper objectMapper = new ObjectMapper();

        String bodyJson = "";
        try {
            bodyJson = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        Response response = RestAssured.given().contentType(ContentType.JSON).body(bodyJson).
                when().put(uri);


        System.out.println(response.statusCode());
        System.out.println(response.asString());

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}












