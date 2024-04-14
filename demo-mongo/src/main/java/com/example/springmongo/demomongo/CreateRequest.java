package com.example.springmongo.demomongo;

public class CreateRequest {

    private String name;
    private String authorName;
    private int cost;



    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getCost() {
        return cost;
    }



}
