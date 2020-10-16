package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }
    // Pass in the context and list of tweets
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // for each row, inflate the layout
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get data at position
        Tweet tweet = tweets.get(position);
        //bind the tweet to the layout
        holder.bind(tweet);
    }

    // bind values based on the position of the element
    @Override
    public int getItemCount() {
        return tweets.size();
    }

    //clear all elements of the recyclerview
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }
    //add a list of items to the data set
    public void addAll(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }
    // Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        TextView tvName;
        TextView tvTimeDifference;
        TextView tvRetweetCount;
        TextView tvFavoriteCount;
        ImageView retweetIcon;
        ImageView favoritedIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvName = itemView.findViewById(R.id.tvName);
            tvTimeDifference = itemView.findViewById(R.id.tvTimeDifference);
            tvRetweetCount = itemView.findViewById(R.id.tvRetweetCount);
            tvFavoriteCount = itemView.findViewById(R.id.tvFavoriteCount);
            retweetIcon = itemView.findViewById(R.id.retweet_icon);
            favoritedIcon = itemView.findViewById(R.id.favorite_icon);

        }

        public void bind(Tweet tweet) {
            tvTimeDifference.setText(tweet.timeDifference);
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            tvName.setText(tweet.user.name);
            Glide.with(context).load(tweet.user.profileImageUrl).transform(new CircleCrop()).into(ivProfileImage);
            if (tweet.favoriteCount > 0){
                tvFavoriteCount.setText(Integer.toString(tweet.favoriteCount));
            }else{
                tvFavoriteCount.setText("");
            }
            if (tweet.retweetCount > 0){
                tvRetweetCount.setText(Integer.toString(tweet.retweetCount));

            }else{
                tvRetweetCount.setText("");
            }
            if(tweet.favorited == true){
                favoritedIcon.setImageResource(R.drawable.ic_vector_heart);
            }
            if(tweet.retweeted == true){
                Log.i("test", "this was retweeted" + tweet.body);
                retweetIcon.setImageResource(R.drawable.ic_vector_retweet);
            }
        }
    }
}
