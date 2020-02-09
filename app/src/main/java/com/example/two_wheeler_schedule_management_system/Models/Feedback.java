package com.example.two_wheeler_schedule_management_system.Models;

public class Feedback {
    private String client;
    private String topic;
    private String desc;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }




    public Feedback(String client, String topic, String desc) {
        this.client = client;
        this.topic = topic;
        this.desc = desc;
    }
}
