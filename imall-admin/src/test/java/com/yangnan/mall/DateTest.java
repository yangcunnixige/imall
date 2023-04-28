package com.yangnan.mall;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);//Fri Apr 28 09:23:04 CST 2023
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        String nowDate = simpleDateFormat.format(date);
        System.out.println(nowDate);//2023/04/28 09:26:17:211
    }

    @Test
    public void test1() throws ParseException {
        String date = "2023/04/28 09:26:17:211";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date d = simpleDateFormat.parse(date);
        System.out.println(d);//Fri Apr 28 09:26:17 CST 2023
    }
}