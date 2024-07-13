package com.bill.BillGenerator.utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static List<Integer> hexToRGB(String hexColor) {
        if (hexColor.startsWith("#")) {
            hexColor = hexColor.substring(1);
        }

        // Parse the hexadecimal string to integer values for each color component
        int red = Integer.parseInt(hexColor.substring(0, 2), 16);
        int green = Integer.parseInt(hexColor.substring(2, 4), 16);
        int blue = Integer.parseInt(hexColor.substring(4, 6), 16);

        List<Integer> rgbColors = new ArrayList<>();
        rgbColors.add(red);
        rgbColors.add(green);
        rgbColors.add(blue);

        return rgbColors;
    }

    public static String numberToWords(Integer n) {
        long limit = 1000000000000L, curr_hun, t = 0;

        if (n == 0)
            return ("Zero");

        String[] multiplier = {"", "Trillion", "Billion",
                "Million", "Thousand"};

        String[] first_twenty = {
                "", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {"", "Twenty", "Thirty",
                "Forty", "Fifty", "Sixty",
                "Seventy", "Eighty", "Ninety"};

        if (n < 20)
            return (first_twenty[n]);
        StringBuilder answer = new StringBuilder();
        for (long i = n; i > 0; i %= limit, limit /= 1000) {

            curr_hun = i / limit;
            while (curr_hun == 0) {
                i %= limit;
                limit /= 1000;
                curr_hun = i / limit;
                ++t;
            }
            if (curr_hun > 99)
                answer.append(first_twenty[(int) curr_hun / 100]).append(" Hundred ");
            curr_hun = curr_hun % 100;
            if (curr_hun > 0 && curr_hun < 20)
                answer.append(first_twenty[(int) curr_hun]).append(" ");
            else if (curr_hun % 10 == 0 && curr_hun != 0)
                answer.append(tens[(int) curr_hun / 10 - 1]).append(" ");
            else if (curr_hun > 20)
                answer.append(tens[(int) curr_hun / 10 - 1]).append(" ").append(first_twenty[(int) curr_hun % 10]).append(" ");
            if (t < 4)
                answer.append(multiplier[(int) ++t]).append(" ");
        }
        return (answer.toString());
    }

}
