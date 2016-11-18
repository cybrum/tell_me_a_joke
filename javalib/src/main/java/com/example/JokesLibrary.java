package com.example;

import java.util.Random;

public class JokesLibrary {
    private static final String[] freeJoke = {
            "Why did the bee get married? Because he found his honey.",
            "I just let my mind wander, and it didn't come back.",
            "IRS: We've got what it takes to take what you've got.",
            "I asked God for a bike, but I know God works in mysterious ways. So I stole a bike and asked for forgiveness.",
            "If I agreed with you we'd both be wrong.",
            "If God is watching us, the least we can do is be entertaining.",
            "I like work: it fascinates me. I can sit and look at it for hours.",
    };
    private static final Random rndmGenerator = new Random();

    public static String getJoke() {
        return freeJoke[rndmGenerator.nextInt(freeJoke.length)];
    }

}
