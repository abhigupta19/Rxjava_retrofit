package com.sar.user.rxjava_retrofit;

public class Post {
    public int userId;
    public int id;







    public String title;
    public String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }
}
