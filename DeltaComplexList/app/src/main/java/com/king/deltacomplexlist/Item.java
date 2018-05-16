package com.king.deltacomplexlist;

/**
 * Created by kingwanyama on 4/9/18.
 */

public class Item {
    private String name,email;
    private  int amount,poster;

    public Item(String name, String email, int amount, int poster) {
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAmount() {
        return amount;
    }

    public int getPoster() {
        return poster;
    }
}
