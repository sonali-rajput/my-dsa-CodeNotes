package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

     public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // Input: ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
        // Args:  [[],        [1,5],        [1],         [1,2],      [2,6],         [1],         [1,2],         [1]]

        List<Object> output = new ArrayList<>();
        output.add(null); // Twitter constructor

        twitter.postTweet(1, 5);  // User 1 posts tweet 5
        output.add(null);

        output.add(twitter.getNewsFeed(1)); // Should return [5]

        twitter.follow(1, 2); // User 1 follows User 2
        output.add(null);

        twitter.postTweet(2, 6); // User 2 posts tweet 6
        output.add(null);

        output.add(twitter.getNewsFeed(1)); // Should return [6, 5]

        twitter.unfollow(1, 2); // User 1 unfollows User 2
        output.add(null);

        output.add(twitter.getNewsFeed(1)); // Should return [5]

        // Print output
        for (Object o : output) {
            if (o instanceof List) {
                System.out.println(((List<?>) o));
            } else {
                System.out.println(o);
            }
        }
    }



    private static int timeStamp = 0;


    // User class for displaying each user in Twitter
    private class User {
        int id; // ids of user
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>(); 
            follow(id); // user should follow themself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if(id != this.id) { // if id exists
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    private class Tweet { // As linked List Data structure
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }
        userMap.get(userId).post(tweetId);
        
    }
    

    // retrieve 10 most recent tweet ids 
    // Each item in the news feed must be posted by the user followed or the user themselves.
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> newsFeed = new LinkedList<>();
        if(!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a,b) -> b.time-a.time);
        
        for (int user: followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead; // getting all the tweet of a user
            if(tweet!=null) {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while (!tweetHeap.isEmpty() && count < 10) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if(tweet.next != null) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }
        if(!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }

        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

}
