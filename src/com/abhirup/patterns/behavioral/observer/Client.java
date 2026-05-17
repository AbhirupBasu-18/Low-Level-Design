package com.abhirup.patterns.behavioral.observer;

public class Client {
    public static void main(String[] args){
        Channel channel = new YoutubeChannel("Striver");
        Subscriber subscriber1 = new EmailSubcriber("abc@gmail.com");
        Subscriber subscriber2 = new MobileAppSubsriber("8420816229");
        channel.subcribe(subscriber1);
        channel.subcribe(subscriber2);
        channel.uploadVideo("India");
    }
}
