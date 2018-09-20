import java.util.*;

public class S0355DesignTwitter {
    class Twitter {
        private class User {
            List<Integer> following;
            List<Tweet> tweets;

            public User() {
                following = new ArrayList<>();
                tweets = new ArrayList<>();
            }
        }

        private class Tweet {
            int timestamp;
            int tweetId;

            public Tweet(int tweetId, int timestamp) {
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }
        }

        HashMap<Integer, User> users;
        private int timestamp = 0;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            users = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!users.containsKey(userId)) {
                users.put(userId, new User());
            }
            User user = users.get(userId);
            user.tweets.add(new Tweet(tweetId, timestamp++));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            if (!users.containsKey(userId)) {
                return new ArrayList<>();
            }

            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    return o2.timestamp - o1.timestamp;
                }
            });

            User user = users.get(userId);
            List<User> timelineUsers = new ArrayList<>();
            timelineUsers.add(user);
            for (int uid : user.following) {
                User u = users.get(uid);
                if (u != null) {
                    timelineUsers.add(u);
                } else {
                    throw new IllegalArgumentException("null user following");
                }
            }
            for (User u : timelineUsers) {
                for (int i = Math.max(u.tweets.size() - 10, 0); i < u.tweets.size(); i++) {
                    maxHeap.add(u.tweets.get(i));
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 10 && !maxHeap.isEmpty(); i++) {
                res.add(maxHeap.poll().tweetId);
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }
            if (!users.containsKey(followerId)) {
                users.put(followerId, new User());
            }
            User follower = users.get(followerId);
            if (!users.containsKey(followeeId)) {
                users.put(followeeId, new User());
            }

            if (follower.following.contains(followeeId)) {
                return;
            }

            follower.following.add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            User follower = users.get(followerId);
            if (follower == null) {
                return;
            }

            if (!follower.following.contains(followeeId)) {
                return;
            }

            follower.following.remove((Integer) followeeId);
        }
    }
}
