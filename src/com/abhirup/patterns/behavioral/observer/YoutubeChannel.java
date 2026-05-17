package com.abhirup.patterns.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel {
    private final List<Subscriber> subscriberList = new ArrayList<>();
    private final String channelName;

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subcribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unsubcribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubcribers(String videoTitle) {
        for (Subscriber subscriber: subscriberList){
            subscriber.update(videoTitle);
        }
    }
    @Override
    public void uploadVideo(String videoTitle){
        System.out.println(channelName+" video uploaded, title: "+videoTitle);
        notifySubcribers(videoTitle);
    }
}
