/*
 * All rights reserved.
 */
package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sven
 */
public class MyDateUtils {

    public static Date stringToDate(String datum) {
        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(datum);
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }
}
