package com.mrone.heapdump.entity;

public class Like {
    private User user;

    public Like(User user) {
        this.user = user;
    }
    public Like() {
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
