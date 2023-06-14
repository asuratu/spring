package com.feng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author AsuraTu
 */
public class TransformDate {
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
