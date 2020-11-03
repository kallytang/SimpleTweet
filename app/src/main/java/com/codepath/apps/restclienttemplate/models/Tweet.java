package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Parcel
@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId"))
public class Tweet {
    @PrimaryKey
    @ColumnInfo
    public long id;

    @ColumnInfo
    public String body;

    @ColumnInfo
    public Long userId;

    @Ignore
    public User user;

    @ColumnInfo
    public int favoriteCount;

    @ColumnInfo
    public int retweetCount;

    @ColumnInfo
    public String createdAt;

    @ColumnInfo
    public Boolean retweeted;

    @ColumnInfo
    public Boolean favorited;

    @ColumnInfo
    public String timeDifference;

    @ColumnInfo
    public String timeStamp;
//    public JSONObject entitiesObject;

//    @ColumnInfo
//    public User userOriginal;
//
//    public boolean retweetedbyAnother;
    //empty constructor needed for the Parceler Library
    public Tweet() {}
    //create tweet and userObject
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();


        tweet.body = jsonObject.getString("text");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.id = jsonObject.getLong("id");
        tweet.favoriteCount = jsonObject.getInt("favorite_count");
        tweet.retweetCount = jsonObject.getInt("retweet_count");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.timeDifference = "· " + TimeFormatter.getTimeDifference(tweet.createdAt);
        tweet.timeStamp = TimeFormatter.getTimeStamp(tweet.createdAt);
        User user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.userId = user.id;
        tweet.favorited = jsonObject.getBoolean("favorited");
        tweet.retweeted = jsonObject.getBoolean("retweeted");

        //To handle retweets by users, in twitter tweets are tweets objects in a tweet object
        try {
            jsonObject.getJSONObject("retweeted_status");
            Log.i("retweet","i have retweet data");
        } catch (JSONException e) {
            e.printStackTrace();
        }


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
