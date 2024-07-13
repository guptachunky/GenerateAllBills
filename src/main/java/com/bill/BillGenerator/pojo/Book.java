package com.bill.BillGenerator.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Book {
    String name;
    String id;
    Integer total;
}
