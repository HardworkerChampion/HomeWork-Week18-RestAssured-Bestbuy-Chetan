package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
    //21. Extract the limit

    @Test
    public void test021() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void test023() {
        String product = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the 5th product is : " + product);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        List<String> listOfNames = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the products is : " + listOfNames);
        System.out.println("------------------End of Test---------------------------");

    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> listOfAllID = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products is : " + listOfAllID);
        System.out.println("------------------End of Test---------------------------");

    }

    //26. Print the size of the data list
    @Test
    public void test026() {
        List<?> dataList = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of all data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
    //Pack)
    @Test
    public void test027() {
        List<?> valueOfProduct = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the product is : " + valueOfProduct);
        System.out.println("------------------End of Test---------------------------");
    }
    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
    //Pack)

    @Test
    public void test028() {
        List<?> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack) is : " + model);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test029() {
        List<?> categoriesList = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Categories of 8th products is : " + categoriesList);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<?> categoriesList = response.extract().path("data.findAll{it.id == '150115'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Categories of the store where product id = 150115 is : " + categoriesList);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<String> listOfDescriptions = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All descriptions of all the products is : " + listOfDescriptions);
        System.out.println("------------------End of Test---------------------------");

    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<?> listOFIdOfAllCategories = response.extract().path("data.categories.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The id of all the all categories of all the products is : " + listOFIdOfAllCategories);
        System.out.println("------------------End of Test---------------------------");

    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<?> productNames = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The product names Where type = HardGood is : " + productNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA
    //1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<?> listOfNumbers = response.extract().path("data.findAll{it.name.startsWith('Duracell - AA 1.5V CopperTop Batteries (4-Pack)')}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The Total number of categories for the product where product name = Duracell - AA is : " + listOfNumbers.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<?> listOfCreatedAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The createdAt for all products whose price < 5.49 is : " + listOfCreatedAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
    //Pack)”
    @Test
    public void test036(){
        List<?> listOfNames = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) is : " + listOfNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //37. Find the manufacturer of all the products
    @Test
    public void test037(){
        List<String> listOfManufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The manufacturer of all the products is : " + listOfManufacturer);
        System.out.println("------------------End of Test---------------------------");
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038(){
        List<String> listOfImage = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The image of products whose manufacturer = Energizer is : " + listOfImage);
        System.out.println("------------------End of Test---------------------------");

    }
    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039(){
        List<?> listOfCreatedAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The createdAt for all categories products whose price > 5.99 is : " + listOfCreatedAt);
        System.out.println("------------------End of Test---------------------------");
    }
    //40. Find the uri of all the products
    @Test
    public void test040(){
        List<?> listOfUrl = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" the uri of all the products is : " + listOfUrl);
        System.out.println("------------------End of Test---------------------------");

    }
}