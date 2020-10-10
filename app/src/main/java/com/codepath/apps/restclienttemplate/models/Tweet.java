package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public String body;
    public String createdAt;
    public User user;
    public long id;
    public int favoriteCount;
    public int retweetCount;
    public String createdAtString;
    public String name;
    public Boolean retweeted;
    public Boolean favorited;
    public String timeDifference;
    public String timeStamp;
    public JSONObject entitiesObject;
//    File savedFiles
    //create tweet and userObject
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.id = jsonObject.getLong("id");
        tweet.favoriteCount = jsonObject.getInt("favorite_count");
        tweet.retweetCount = jsonObject.getInt("retweet_count");
        tweet.createdAtString = jsonObject.getString("created_at");
        tweet.timeDifference = "· " + TimeFormatter.getTimeDifference(tweet.createdAtString);
        tweet.timeStamp = TimeFormatter.getTimeStamp(tweet.createdAtString);
//        tweet.entitiesObject = jsonObject.getJSONObject("entities");
//        tweet.favorited = jsonObject.getBoolean("favorited");
//        tweet.retweeted = jsonObject.getBoolean("retweeted");
//        if(tweet.entitiesObject.has("media")){
////            Log.i("tweet", tweet.entitiesObject.toString());


        return tweet;

    }
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i <jsonArray.length(); i++ ){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }
}
