package org.example.behavioural;

import org.example.behavioural.observer.Channel;
import org.example.behavioural.observer.Subscriber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BehaviouralDesignsTest {

    @Test
    public void observer() {

        Channel fireship = new Channel();

        Subscriber s1 = new Subscriber("Akhilesh");
        Subscriber s2 = new Subscriber("Muskan");
        Subscriber s3 = new Subscriber("Pooja");
        Subscriber s4 = new Subscriber("Madhuri");
        Subscriber s5 = new Subscriber("Aaradhya");

        fireship.subscribe(s1);
        fireship.subscribe(s2);
        fireship.subscribe(s3);
        fireship.subscribe(s4);
        fireship.subscribe(s5);

        s1.subscribeChannel(fireship);
        s2.subscribeChannel(fireship);
        s3.subscribeChannel(fireship);
        s4.subscribeChannel(fireship);
        s5.subscribeChannel(fireship);

        fireship.unsubscribe(s3);

        fireship.upload("Brainf**k in 100 Seconds");
    }
}