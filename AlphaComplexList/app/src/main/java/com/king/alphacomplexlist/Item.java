package com.king.alphacomplexlist;

/**
 * Created by kingwanyama on 4/9/18.
 */

public class Item {
    private String names,email;
    private int amount,poster;

    public Item(String names, String email, int amount, int poster) {
        this.names = names;
        this.email = email;
        this.amount = amount;
        this.poster = poster;
    }

    public String getNames() {
        return names;
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
