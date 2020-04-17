package utilities;

import ApiModels.ResponseBody;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
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
            responseBody = objectMapper.readValue(response.asString(), responseBody.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
