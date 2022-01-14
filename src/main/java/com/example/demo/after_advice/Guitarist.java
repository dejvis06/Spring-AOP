package com.example.demo.after_advice;

import com.example.demo.before_advice.Singer;

public class Guitarist implements Singer {

    private String lyric = "You're gonna live forever in me";

    @Override
    public void sing(String string) {
        System.err.println(lyric);
    }

    public String getLyric() {
        return lyric;
    }
}