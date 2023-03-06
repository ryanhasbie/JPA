package com.enigma.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateDate {
    public static Date generate(String dateParams) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateParams);
        } catch (ParseException e) {
            System.err.println((e.getMessage()));
        }
        return date;
    }
}
