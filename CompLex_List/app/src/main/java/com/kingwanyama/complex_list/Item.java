package com.kingwanyama.complex_list;

/**
 * Created by kingwanyama on 12/18/17.
 */

public class Item {
    private String names;
    private String email;
    private int amount;
    private int poster;

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
