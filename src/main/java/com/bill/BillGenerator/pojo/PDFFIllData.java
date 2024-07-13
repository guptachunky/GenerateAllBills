package com.bill.BillGenerator.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PDFFIllData {
    private String text;
    private int locationX;
    private int locationY;
    private int fontSize;
    private String color;
    private String font;
    private String enricher;
    private String field;

    public PDFFIllData() {
    }

}
