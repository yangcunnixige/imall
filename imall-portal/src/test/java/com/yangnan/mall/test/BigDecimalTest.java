package com.yangnan.mall.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test1() {
        double d1 = 0.1;
        double d2 = 0.2;
        System.out.println(d1 + d2);//0.30000000000000004
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        BigDecimal b = b1.add(b2);
        System.out.println(b);//0.3000000000000000166533453693773481063544750213623046875
    }

    @Test
    public void test2() {
        double d1 = 0.1;
        double d2 = 0.2;
        BigDecimal b1 = new BigDecimal(d1 + "");
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        BigDecimal b = b1.add(b2);
        System.out.println(b);//0.3
    }

    @Test
    public void test3() {
        double d1 = 0.1;
        double d2 = 0.2;
        BigDecimal b1 = BigDecimal.valueOf(d1);
        BigDecimal b2 = BigDecimal.valueOf(d2);
        BigDecimal b = b1.add(b2);
        System.out.println(b);//0.3
    }
}