package com.abhirup.patterns.behavioral.observer;
//Concrete observer directly communicate with the user
public class EmailSubcriber implements Subscriber{
    private final String emailId;

    public EmailSubcriber(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email has been sent to "+ emailId + " : New video uploaded - "+videoTitle);
    }
}
