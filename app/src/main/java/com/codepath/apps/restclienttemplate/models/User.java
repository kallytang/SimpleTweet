package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public String name;
    public String screenName;
    public String profileImageUrl;


    public static User fromJSON(JSONObject jsonObject) throws JSONException {
        String full_screen_name;
        User user = new User();
        full_screen_name = "@" + jsonObject.getString("screen_name");
        user.name = jsonObject.getString("name");
        user.screenName = full_screen_name;
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");

        Log.i("user", jsonObject.toString());
        return user;

    }

}
