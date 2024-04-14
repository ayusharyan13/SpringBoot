package com.example.firstSpring;

import java.util.HashMap;

public class DataStore {
    private final HashMap<String,String> store = new HashMap<String,String>();

    public DataStore() {
        store.put("Sachin", " A great Batsmen");
        store.put("Fruits", "Mango to sbse best hai bhai");
        store.put("Litchi", "Muzaffarpur ka hi best hai bhai");
        store.put("lalu", "sbse bada ghotaleBaaz");

    }

    public String getFromDB(String word) {

        return store.get(word);
    }

}
