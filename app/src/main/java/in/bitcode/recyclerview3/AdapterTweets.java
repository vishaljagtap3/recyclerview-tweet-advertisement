package in.bitcode.recyclerview3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTweets extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Tweet> tweets;
    private ArrayList<Advertisement> advertisements;

    public static final int TYPE_TWEET = 1, TYPE_ADVERTISEMENT = 2;

    public AdapterTweets(ArrayList<Tweet> tweets, ArrayList<Advertisement> advertisements) {
        this.tweets = tweets;
        this.advertisements = advertisements;
    }

    class TweetViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAccount, txtTweet;
        public TweetViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAccount = itemView.findViewById(R.id.txtAccount);
            txtTweet = itemView.findViewById(R.id.txtTweet);
        }
    }

    class AdvtViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAdvt;
        public ImageView imgAdvt;

        public AdvtViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgAdvt = itemView.findViewById(R.id.imgAdvt);
            txtAdvt = itemView.findViewById(R.id.txtAdvtText);
        }
    }

    @Override
    public int getItemCount() {
        return tweets.size() + advertisements.size();
    }

    @Override
    public int getItemViewType(int position) {
        if( (position+1) % 3 == 0 ) {
            return TYPE_ADVERTISEMENT;
        }
        return TYPE_TWEET;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if( viewType == TYPE_TWEET) {
            return new TweetViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_view, null)
            );
        }
        if( viewType == TYPE_ADVERTISEMENT) {
            return new AdvtViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_view, null)
            );
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if( getItemViewType(position) == TYPE_TWEET ) {
            TweetViewHolder tweetViewHolder = (TweetViewHolder) holder;
            Tweet tweet = tweets.get(position - position/3);
            tweetViewHolder.txtAccount.setText(tweet.getAccount());
            tweetViewHolder.txtTweet.setText(tweet.getText());
        }

        if( getItemViewType(position) == TYPE_ADVERTISEMENT ) {
            AdvtViewHolder advtViewHolder = (AdvtViewHolder) holder;
            Advertisement advertisement = advertisements.get(position/3);
            advtViewHolder.imgAdvt.setImageResource( advertisement.getImageId());
            advtViewHolder.txtAdvt.setText(advertisement.getText());
        }
    }
}
