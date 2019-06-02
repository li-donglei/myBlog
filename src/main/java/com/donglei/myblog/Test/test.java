package com.donglei.myblog.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class test {


    public static void images(){

        File file = new File("c:/users/18451/desktop/liuyifei");
        System.out.println(file.isDirectory());

        File[] f1=file.listFiles();
//        for (File file1 : f1){
//            System.out.println(file1.getName());
//        }
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        List<String> l = list.subList(0,3);
        for(String a : l){
            System.out.println(a);
        }
        System.out.println("-------------");
        List<String> l1 = list.subList(3,5);
        l1.remove(0);

        for(String a : list){
            System.out.println(a);
        }

    }

    public static void update(){
        Properties p = new Properties();
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/test.properties");
            p.load(fis);
            Integer age = Integer.parseInt((String)p.get("age"));
            age++;
            fis.close();
            p.setProperty("age", String.valueOf(age));
            FileOutputStream fos = new FileOutputStream("src/main/resources/test.properties");
            p.store(fos, "Copyright Thcic");
            fos.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("failure");
        }




    }

    public static void main(String[] args) {
        update();
    }
}
