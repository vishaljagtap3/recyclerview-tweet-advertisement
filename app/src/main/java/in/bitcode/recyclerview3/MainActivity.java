package in.bitcode.recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tweet> tweets;
    private ArrayList<Advertisement> advertisements;
    private RecyclerView recyclerTweets;
    private AdapterTweets adapterTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        setContentView(R.layout.activity_main);
        recyclerTweets = findViewById(R.id.recyclerTweets);
        recyclerTweets.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet("BitCode", "Android is amazing!"));
        tweets.add(new Tweet("BitCode", "Android is the future!"));
        tweets.add(new Tweet("BitCode", "Lets learn Kotlin!"));
        tweets.add(new Tweet("BitCode", "iOS is BAD!"));
        tweets.add(new Tweet("BitCode", "Kotlin provide co-routines!"));
        tweets.add(new Tweet("BitCode", "Microservices are oxygen to the server!"));
        tweets.add(new Tweet("BitCode", "Build resource optimized app for Android with Studio!"));
        tweets.add(new Tweet("BitCode", "Lets learn Kotlin!"));

        advertisements = new ArrayList<>();
        advertisements.add(new Advertisement(R.drawable.img1, "Buy homes in Pune at 55lacs Only!"));
        advertisements.add(new Advertisement(R.drawable.img2, "50% off no elctronics! Hurry up!"));
        advertisements.add(new Advertisement(R.drawable.img3, "Order your food with coupon code FD5656"));
        advertisements.add(new Advertisement(R.drawable.img4, "Buy homes in Pune at 85lacs Only!"));

        adapterTweets = new AdapterTweets(tweets, advertisements);
        recyclerTweets.setAdapter(adapterTweets);
    }
}