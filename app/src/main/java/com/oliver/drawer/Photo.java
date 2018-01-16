package com.oliver.drawer;

import java.io.Serializable;

/**
 * Created by Oliver on 1/16/2018.
 */

public class Photo implements Serializable {

   public int id;
   public String image_url;
   public String name;

    public Photo(int id, String image_url, String name) {
        this.id = id;
        this.image_url = image_url;
        this.name = name;
    }
}
