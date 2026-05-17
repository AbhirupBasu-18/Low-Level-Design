package com.abhirup.patterns.behavioral.observer;
//Subject Interface
public interface Channel {
    void subcribe(Subscriber subscriber);
    void unsubcribe(Subscriber subscriber);
    void notifySubcribers(String videoTitle);
    void uploadVideo(String videoTitle);
}

