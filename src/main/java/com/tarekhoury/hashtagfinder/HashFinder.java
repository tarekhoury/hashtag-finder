package com.tarekhoury.hashtagfinder;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class HashFinder {

    private static String TAG = HashFinder.class.getName();

    private final Twitter twitter;

    // Set default value
    private int tweetsCount = 20;

    public HashFinder(@NonNull String key, @NonNull String keySecret, @NonNull String token, @NonNull String tokenSecret) {

        // Build OAuth configuration
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setDebugEnabled(true)
                .setOAuthConsumerKey(key)
                .setOAuthConsumerSecret(keySecret)
                .setOAuthAccessToken(token)
                .setOAuthAccessTokenSecret(tokenSecret);

        // Init Twitter instance with OAuth
        twitter = new TwitterFactory(builder.build()).getInstance();
    }

    public void setTweetsCount(@IntRange(from = 1, to = 100) int count) {

        /*
         * Use default value of 20 if count is not in the allowed range
         */

        if (count <= 0 || count > 100) {

            Log.w(TAG, "Tweet count can only be within the range of 1 to 100. Using default value " + tweetsCount);
            return;
        }

        tweetsCount = count;
    }

    @Nullable
    public List<SimpleTweet> search(@NonNull String hashtag) {

        /*
         * Prepare Twitter sdk and search synchronously
         */

        if (TwitterHelper.isValidHashtag(hashtag)) {

            try {

                // Setup query with hashtag and tweet count
                Query query = new Query(hashtag);
                query.count(tweetsCount);

                // Run search query
                QueryResult result = twitter.search(query);
                List<Status> statuses = result.getTweets();

                // Prepare an empty array with the exact size to hold tweet text
                List<SimpleTweet> tweetsList = new ArrayList<>(statuses.size());

                for (Status status : statuses) {

                    tweetsList.add(new SimpleTweet(status.getUser().getName(), status.getText(), status.getCreatedAt(), status.getFavoriteCount(), status.getRetweetCount()));
                }

                return tweetsList;

            } catch (TwitterException e) {

                e.printStackTrace();
            }
        } else {

            Log.w(TAG, "Invalid hashtag, skipping search");
        }

        return null;
    }
}
