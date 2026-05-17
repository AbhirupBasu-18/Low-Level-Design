package com.abhirup.patterns.behavioral.observer;

public class MobileAppSubsriber implements Subscriber{
    private final String phoneNumber;

    public MobileAppSubsriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("SMS has been sent to "+ phoneNumber + "for this video: " +videoTitle);
    }
}
