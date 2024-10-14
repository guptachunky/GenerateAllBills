package com.bill.BillGenerator.fuel;

import java.text.SimpleDateFormat;
import java.util.Random;

public interface FuelConstants {
    String TYPE = "Petrol";
    String CAR_NUMBER = "3731";
    String PHONE_NUMBER = "";
    String BASE_PATH = "src/main/resources/fuel";
    String TOTAL_PRICE = "3000";
    String PRICE = "Rs. 94.72";
    String TOTAL_FUEL = "31.67";

//    String HEADER1 = "CHANAKYAPURI SERVICE STATION";
//    String HEADER2 = "ROAD NO 26, Outer Ring R";
//    String HEADER3 = "Delhi";
    String HEADER1 = "Bharat HP Center Sector-12";
    String HEADER2 = "Near Metro Station, Phase-1";
    String HEADER3 = "Dwarka, New Delhi";

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    String TEMPLATE_NAME = BASE_PATH + "/data/Sample.pdf";
    String SAMPLE_JSON = BASE_PATH + "/data/Sample.json";
    Random RANDOM = new Random();
    String[] TIMES = {"am", "pm"};
}
