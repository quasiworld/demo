package org.ck.life;


import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @className: Test
 * @description:
 * @createDate: 2021年07月14日 15:11:43
 * @author: ck
 */
public class Test {

    static String[] s2 = new String[]{"1. 402+速食1人",
            "2. 309+速食2人",
            "3. 602+生鲜1人+速食1人",
            "4. 606+速食1人",
            "5. 406 +生鲜1人+素食1人",
            "6. 205+生鲜1人",
            "7. 305+速食1人",
            "8. 501+生鲜2人素食1",
            "9. 605+ 生鲜2人+速食1人",
            "10. 607+速食1人",
            "11. 401+生鲜2人",
            "12. 509+生鲜1人速食1人",
            "13. 505+生鲜1人+速食1人",
            "14. 405+生鲜1人",
            "15. 209+生鲜1人",
            "16. 306+速食1人",
            "17. 409+速食1人",
            "18. 203+生鲜1人",
            "19. 603＋生鲜1人",
            "20. 302+速食1人",
            "21. 506+生鲜1人",
            "22. 403+生鲜1人",
            "23. 103+速食1人",
            "24. 201十生鲜1人",
            "25. 303+生鲜1人+速食1人",
            "26. 206+速食1人",
            "27. 301生鲜1人",
            "28. 502+速食1人",
            "29. 503+速食1人",
            "30. 202+速食1人",
            "31. 601+生鲜1人"};

    static String[] s1 = new String[]{
            "2. 606房1人，在上沙",
            "3. 205房曾某1人上沙",
            "4. 601房1人，在上沙",
            "5. 306房1人，在上沙",
            "6. 103房1人，在上沙",
            "7. 607房1人,   在上沙",
            "8. 506房1人，在上沙",
            "9. 505房2人，在上沙",
            "10. 303房2人，在上沙要1小瓶油、1小瓶酱油",
            "11. 605房3人，在上沙",
            "12. 401房2人，在上沙",
            "13. 409房1人 上沙",
            "14. 309房2人在上沙",
            "15. 509房2人上沙",
            "16. 206室1人，在上沙。要几盒鱼罐头，1袋洗衣粉。谢谢！",
            "17. 209房1人，在上沙",
            "18. 503房1人，在上沙，需要几包纸，速食主食",
            "19. 201房1人，在上沙",
            "20. 403房1人，在上沙",
            "21. 405房1人，在上沙",
            "22. 406 房2人，在上沙",
            "23. 301房1人在上沙",
            "24. 203房1人，在上沙",
            "25. 402房1人，在上沙，速食，纸巾",
            "26. 603房1人，在上沙",
            "27. 501房3人，在上沙",
            "28. 502房1人，在上沙",
            "29. 602房，2人，在上沙，需要米",
            "30. 402房1人，在上沙",
            "31. 202房1人，在上沙"};

    public static void main(String[] args) {
        int i = 0;
        for (String s : s2) {
            if (s.indexOf("1人")!=-1) {
                i+=1;

            }
            if(s.indexOf("2人")!=-1){
                i+=2;
            }
            if(s.indexOf("3人")!=-1){
                i+=3;
            }
            System.out.println(i);
        }
        System.out.println(i);
    }
    
    public void print(){
        System.out.println(s1.length);
        System.out.println(s2.length);
        for (String s : sort(s1)) {
            System.out.println(s);
        }
        System.out.println("======================================================");
        for (String s : sort(s2)) {
            System.out.println(s);
        }
    }


    public static List<String> sort(String[] str) {
        List<String> strings = Arrays.asList(str);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1 = o1.replaceAll("\\s*", "");
                o2 = o2.replaceAll("\\s*", "");
                int i = o1.indexOf(".") + 1;
                int i1 = o2.indexOf(".") + 1;
                String substring = o1.substring(i, i + 3);
                String substring1 = o2.substring(i1, i1 + 3);
                int house = Integer.parseInt(substring);
                int house2 = Integer.parseInt(substring1);
                if (house > house2) {
                    return 1;
                } else if (house == house2) {
                    return 0;
                }
                return -1;
            }
        });
        return strings;
    }
}
