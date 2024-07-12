package com.bill.BillGenerator;

import java.text.SimpleDateFormat;
import java.util.Random;

public interface FuelConstants {
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
