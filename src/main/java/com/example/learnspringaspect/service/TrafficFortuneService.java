package com.example.learnspringaspect.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService {

    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "Looking great!";
    }

    public String getFortune(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Doomed");
        }
        return getFortune();
    }
}
