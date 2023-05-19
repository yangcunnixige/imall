package com.yangnan.mall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String[] array = {"2019 5013 08", "2021-5013-08", "2023501308"};
        String regex = "(\\d{4})[\\-\\s]?(\\d{4})[\\-\\s]?(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        for (String string : array) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                System.out.println(matcher.group(0));
                //System.out.println(matcher.group(1) + "    " + matcher.group(2) + "    " + matcher.group(3));
            }
        }
    }

    public static void main1(String[] args) {
        String str = "We live at 3234058911296670,not at 0589323411296670 wo 3234058911296670 are 2372537527357253";
        List<Integer> positions = findFourConor(str);
        System.out.println(positions);
    }

    private static List<Integer> findFourConor(String message) {
        String[] fourCorner = {"3234", "0589", "1129", "6670"};
        List<String> list = Arrays.asList(fourCorner);
        //放下标
        List<Integer> positionList = new ArrayList<>();
        String regex = "\\d{16}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        int fromIndex = 0;
        while (matcher.find()) {//find()找到匹配的之后，在调用会继续往后找
            String str = matcher.group(0);
            System.out.println(str);
            //3234058911296670
            //0589323411296670
            //2372537527357253
            boolean isAllMatch = true;
            for (int i = 0; i < str.length(); i+=4) {
                String temp = str.substring(i, i + 4);//3234  0589
                if (!list.contains(temp)) {
                    isAllMatch = false;
                    break;
                }
                /*boolean isMatch = list.contains(temp);
                if (!isMatch) {  // isMatch == false
                    isAllMatch = false;
                    break;
                }*/
            }

            if (isAllMatch) {
                int position = message.indexOf(str, fromIndex);
                fromIndex = position + str.length();
                positionList.add(position);
            }
        }

        return positionList;
    }
}