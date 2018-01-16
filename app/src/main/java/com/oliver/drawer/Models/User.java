package com.oliver.drawer.Models;

import java.io.Serializable;

/**
 * Created by Oliver on 1/16/2018.
 */

public class User implements Serializable {
   public String username;
   public String firstname;
   public String lastname;

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
