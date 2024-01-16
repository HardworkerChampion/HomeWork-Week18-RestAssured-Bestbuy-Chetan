package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //    1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  name of 5th store  is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> listName = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All store names is : " + listName);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> listOfStoreId = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeID  is : " + listOfStoreId);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<?> listOfData = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of the data list is  : " + listOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        String storeName = response.extract().path("data[6].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store name is   : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<HashMap<String, ?>> storeName = response.extract().path("data.findAll{it.name == 'Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is : " + storeName.get(0));
        System.out.println("------------------End of Test---------------------------");

    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<?> listOfServices = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of 8th store is : " + listOfServices);
        System.out.println("------------------End of Test---------------------------");


    }

    //10. Get storeServices of the store where service name = Windows Store
    @Test
    public void test10() {
        List<?> storeServiceName = response.extract().path("data.findAll{it.name == 'Windows Store'}.services[6].storeServices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("storeServices of the store where service name = Windows Store is : " + storeServiceName);
        System.out.println("------------------End of Test---------------------------");

    }

    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer> listOfStoreID = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is : " + listOfStoreID);
        System.out.println("------------------End of Test---------------------------");
    }
    //12. Get id of all the store
    @Test
    public void test12(){
        List<Integer> listOfAllID = response.extract().path("data.services.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all the store is : " + listOfAllID);
        System.out.println("------------------End of Test---------------------------");
    }
    //13. Find the store names Where state = ND

    @Test
    public void test013(){
        List<?> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The store names Where state = ND is : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //14. Find the Total number of services for the store where store name = Rochester

    @Test
    public void test014(){
        List<?> total = response.extract().path("data.findAll{it.name = 'Rochester'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services for the store where store name = Rochester is : " + total.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //15. Find the createdAt for all services whose name = “Windows Store”

    @Test
    public void test015(){
        List<?> createdAt = response.extract().path("data.findAll{it.name == 'Windows Store'}.services.storeservices.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all services whose name = “Windows Store” is : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<?> listOfAllNames = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services Where store name = “Fargo” is : " + listOfAllNames);
        System.out.println("------------------End of Test---------------------------");
        System.out.println(listOfAllNames);
    }
    //17. Find the zip of all the store
    @Test
    public void test017(){
        List<Integer> listOfAllZip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of all the store is : " + listOfAllZip);
        System.out.println("------------------End of Test---------------------------");
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<?> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of all the store is : " + zip);
        System.out.println("------------------End of Test---------------------------");
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<?> storeServiceList = response.extract().path("data.findAll{it.name == 'Magnolia Home Theater'}.services.storeservices");

        System.out.println(storeServiceList);
    }
    //20. Find the lat of all the stores
    @Test
    public void test020(){
        List<Double> latList = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The lat of all the store is : " + latList);
        System.out.println("------------------End of Test---------------------------");

    }
}
