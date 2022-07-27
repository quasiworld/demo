/*
package org.ck.patterns;

import org.ck.patterns.pojo.JsonRootBean;

public class Main {

    public static void main(String[] args) {
        */
/*String in=JsonUtils.objectToJson(new Interface());
        System.out.println(in);*//*


        String string="{\"interfaces\":{\"globalInfo\":{\"interfaceCode\":\"DFXJ1008\",\"responseCode\":\"1\",\"appId\":\"0\",\"requestTime\":\"2020-06-13 13:57:45:293\",\"requestCode\":\"DZFPQZ\",\"interfaceId\":\"\",\"dataExchangeId\":\"DZFPQZDFXJ10082020-06-13928687881\"},\"returnStateInfo\":{\"returnCode\":\"0000\",\"returnMessage\":\"此发票已经开具过\"},\"Data\":{\"dataDescription\":{\"zipCode\":\"0\"},\"content\":\"eyJGUFFRTFNIIjoiTkZZSDIwMjAwNjEwMTQ1NzQ2MDEiLCJGUF9ETSI6IjA0NDAzMTgwMDIxMSIsIkZQX0hNIjoiMjY0MTYxODgiLCJLUFJRIjoiMjAyMDA2MTAxNDU2MTMiLCJKWU0iOiIxNDk3MzQ5NzY2Nzk4MDc5NDM1OCIsIlBERl9VUkwiOiJodHRwOi8vd3d3LmZhcGlhby5jb20vZHpmcC13ZWIvcGRmL2Rvd25sb2FkP3JlcXVlc3Q9SG91THM5c2xyRUtRbUxjaU9mMkoxYmtDc0xEa2JOdkxDTmtHMElpVlFZanNyZk8zakNhMDZERWFPU1Q1NU1vNWtpcVI0RXBDRUd0TkNCb09Na2hXcndfXyU1RWRFZUJKY2pmZEoiLCJTUF9VUkwiOiJodHRwczovL3d3dy5mYXBpYW8uY29tL2ZwdC13ZWNoYXQvd3hhZGRjYXJkLmRvP2NvZGU9cjFMVGlhWDd1MnhOVHhMQyUyRmkyS1JIRUFJQkNGcUl4cXhPb2pIWjJMdTdVSFZ1OENvcGk3ZHpta3hLQzgzcyUyQjFicUVsdXBRYjhIUWElMEF1WU5GclFKMUxBJTNEJTNEIn0=\"}}}";
        JsonRootBean anInterface = JsonUtils.jsonToPojo(string, JsonRootBean.class);

       // System.out.println(anInterface);
        System.out.println(anInterface);
      */
/*  Interface In=new Interface();
        Interface.Data data=new Interface().getData();
        data.setContent("sddddddddddddd");
        In.setData(data);
        System.out.println(In);*//*

    }

    //判断finally与return之间的关系
    public static Integer testFinally() {
        Integer a = 10;
        try {

            System.out.println(a / 0);
            a = 20;
        } catch (Exception e) {
            //a=30;
            return a;
        } finally {
            a = 40;
        }
        return a;
    }

    //测试if的用法
    //没有括号的时候语句的作用只能用于这一句话中
    //所以声明语句不能用在这里面
    public static String testIf() {
        // if(true) String i="";
        if (true) {
            int i = 0;
        }
        return null;
    }

}*/
