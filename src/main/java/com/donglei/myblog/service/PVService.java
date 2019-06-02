package com.donglei.myblog.service;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

@Service
public class PVService {

    public void updatePV(){
        Properties p = new Properties();
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/test.properties");
            p.load(fis);
            Integer PV = Integer.parseInt((String)p.get("PV"));
            PV++;
            fis.close();
            p.setProperty("PV", String.valueOf(PV));
            FileOutputStream fos = new FileOutputStream("src/main/resources/test.properties");
            p.store(fos, "");
            fos.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("failure");
        }

    }
    public Integer getPV(){
        Properties p = new Properties();
        Integer PV = 0;
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/test.properties");
            p.load(fis);
            PV = Integer.parseInt((String)p.get("PV"));
        }catch (Exception e){
            System.out.println(e);
        }
        return PV;
    }
}
