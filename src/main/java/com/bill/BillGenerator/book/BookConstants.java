package com.bill.BillGenerator.book;

import com.bill.BillGenerator.pojo.Book;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public interface BookConstants {

    String SELLER_NAME = "Delhi Book Sellers\n";
    String SELLER_ADDRESS = "\n Delhi, India - 110041";
    String SELLER_EMAIL = " dkbooksellers@gmail.com";

    String BUYER_NAME = "Chunky Gupta\n";
    String BUYER_ADDRESS = "\n Delhi, India - 110041";
    String BUYER_EMAIL = " chunkygupta95@gmail.com";
    String BILL_DATE = " January 02, 2024";
    List<Book> books = List.of(
            Book.builder().id("book1").name("An Introduction to Data Structures\n" +
                    "and Algorithms").total(6191).build(),
            Book.builder().id("book2").name("Java 17 Programming:\n" +
                    "fundamentals of Java").total(2535).build()
    );

    String TYPE = "Diesel";
    String CAR_NUMBER = "YOURCARNUMBER";
    String PHONE_NUMBER = "YOURPHONENUMBER";
    String BASE_PATH = "src/main/resources/fuel";
    String TOTAL_PRICE = "4500";
    String PRICE = "Rs. 87.62";
    String TOTAL_FUEL = "51.36";
    String HEADER1 = "CHANAKYAPURI SERVICE STATION";
    String HEADER2 = "ROAD NO 26, Outer Ring R";
    String HEADER3 = "Delhi";

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    String TEMPLATE_NAME = BASE_PATH + "/data/Sample.pdf";
    String SAMPLE_JSON = BASE_PATH + "/data/Sample.json";
    Random RANDOM = new Random();
    String[] TIMES = {"am", "pm"};
}
