package org.example.behavioural.observer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Subscriber {

    private final String name;
    private Channel channel = new Channel();

    public void update() {
        System.out.println("Hey " + name +", Video Uploaded: " + channel.getTitle());
    }

    public void subscribeChannel(Channel ch) {
        this.channel = ch;
    }
}
