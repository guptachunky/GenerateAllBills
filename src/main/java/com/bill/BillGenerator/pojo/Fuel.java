package com.bill.BillGenerator.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "fuel")
@Configuration("fuelProperties")
@Data
public class Fuel {
    String type;
    String carNumber;
}
