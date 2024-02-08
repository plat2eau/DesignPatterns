package org.example.behavioural.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private List<Subscriber> subs = new ArrayList<>();

    @Getter
    private String title;

    public void subscribe(Subscriber subscriber) {
        subs.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subs.remove(subscriber);
    }

    public void notifySubs() {
        for (Subscriber subscriber: subs) {
            subscriber.update();
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubs();
    }
}
