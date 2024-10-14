package com.bill.BillGenerator.fuel;

import com.bill.BillGenerator.pojo.PDFFIllData;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.bill.BillGenerator.fuel.FuelConstants.*;

public class FuelBillApp {

    public static void main(String[] args) {
        // Change Start Date in this method
        Calendar cal = getStartOfCalender();

        JsonReader reader = new JsonReader();
        List<PDFFIllData> data = reader.read(SAMPLE_JSON);
        populateBaseInformation(data);
        PDFGenerator generator = new PDFGenerator();
        // It will generate 10 bills of same amount mentioned in the constant file change logic as per use
        for (int i = 0; i < 12; i++) {
            data.get(4).setText(DATE_FORMAT.format(cal.getTime()));
            String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
            String outputPdfFile = outputFileName(cal, monthName, data);
            generator.generate(data, TEMPLATE_NAME, outputPdfFile);
            System.out.println("Bill Generated for " + monthName);
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 7);
        }
    }

    private static Calendar getStartOfCalender() {
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JULY, 7);
        return cal;
    }

    private static String outputFileName(Calendar cal, String monthName, List<PDFFIllData> data) {
        String outputPdfFile = BASE_PATH + "/output/" + cal.get(Calendar.DAY_OF_MONTH) + "-" + monthName + ".pdf";
        data.get(5).setText(RANDOM.nextInt(12) + ":" + RANDOM.nextInt(60)
                + " " + TIMES[RANDOM.nextInt(2)]);
        return outputPdfFile;
    }

    private static void populateBaseInformation(List<PDFFIllData> data) {
        data.stream().filter(it -> Objects.nonNull(it.getField())).forEach(it -> {
            switch (it.getField()) {
                case "TYPE":
                    it.setText(TYPE);
                    break;
                case "CAR_NUMBER":
                    it.setText(CAR_NUMBER);
                    break;
                case "PHONE_NUMBER":
                    it.setText(PHONE_NUMBER);
                    break;
                case "TOTAL_PRICE":
                    it.setText(TOTAL_PRICE);
                    break;
                case "PRICE":
                    it.setText(PRICE);
                    break;
                case "TOTAL_FUEL":
                    it.setText(TOTAL_FUEL);
                    break;
                case "HEADER1":
                    it.setText(HEADER1);
                    break;
                case "HEADER2":
                    it.setText(HEADER2);
                    break;
                case "HEADER3":
                    it.setText(HEADER3);
                    break;
                default:
            }
        });
    }
}