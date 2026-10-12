package com.shanu.challange_app;

public class Challenge {
    private long id;
    private String month;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Challenge(String month, long id, String description) {
        this.month = month;
        this.id = id;
        this.description = description;
    }
}
