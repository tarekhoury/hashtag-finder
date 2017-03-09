package com.tarekhoury.hashtagfinder;

class TwitterHelper {

    static boolean isValidHashtag(String hash) {

        return !(hash.charAt(0) != '#' || hash.contains(" "));
    }
}
