package com.example.langfire;

import java.util.Random;

public class GetRandomNum {

    public int getRanNum() {

        Random rand = new Random();
        int upperbound = 10000;
        int num = rand.nextInt(upperbound);

        return num;
    }
}
