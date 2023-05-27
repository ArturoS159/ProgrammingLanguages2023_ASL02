package com.artur;

import java.util.ArrayList;
import java.util.List;

public class Government {

    private static final List<String> laws = new ArrayList<>();
    private static Government instance;

    private Government() {
        System.out.println("The government shall not break the constitution");
    }

    public static Government getInstance() {
        if (instance == null) {
            instance = new Government();
            laws.add("The government shall not break the constitution");
        }
        return instance;
    }


    public void enact(String law) {
        if (laws.contains(law)) {
            System.out.println("Law already exist!");
        } else {
            laws.add(law);
        }
    }

    public boolean isEnacted(String law) {
        return laws.contains(law);
    }

    public static int lawsEnacted(){
        return laws.size();
    }
}
