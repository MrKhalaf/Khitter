package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;

    public TweetsAdapter (Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // Pass in context and list of tweets throguhout adapter
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // bind values based on position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get the data at position
        Tweet tweet = tweets.get(position);
        //bind the tweet with the Viewholder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }

    // Clean all elements of the recycler
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }


    // rv will tell us what position needs binding and we'll bind

    // Define viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImg;
        TextView tvUser;
        TextView tvBody;
        TextView tvTweetAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImg = itemView.findViewById(R.id.ivProfileImg);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvTweetAge = itemView.findViewById(R.id.tvTweetAge);
        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvUser.setText(tweet.user.screenName);
            tvTweetAge.setText(TimeFormatter.getTimeDifference(tweet.createdAt));
            Glide.with(context).load(tweet.user.profilePicUrl).into(ivProfileImg);
        }

    }

}
