package com.bill.BillGenerator.fuel;

import java.text.SimpleDateFormat;
import java.util.Random;

public interface FuelConstants {
    String TYPE = "Petrol";
    String CAR_NUMBER = "DL9CAW8294";
    String PHONE_NUMBER = "9899355802";
    String BASE_PATH = "src/main/resources/fuel";
    String TOTAL_PRICE = "4000";
    String PRICE = "Rs. 94.72";
    String TOTAL_FUEL = "42.22";
    String HEADER1 = "Community Center Rohini East";
    String HEADER2 = "Sector-8 New Delhi-110085";
    String HEADER3 = "Delhi";

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    String TEMPLATE_NAME = BASE_PATH + "/data/Sample.pdf";
    String SAMPLE_JSON = BASE_PATH + "/data/Sample.json";
    Random RANDOM = new Random();
    String[] TIMES = {"am", "pm"};
}
