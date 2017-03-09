package com.tarekhoury.hashtagfinder;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TwitterHelperTest {

    @Test
    public void correctlyFailOnInvalidHashtag() throws Exception {

        assertFalse("Should not allow hashtag that doesn't begin with #", TwitterHelper.isValidHashtag("test"));
        assertFalse("Should not allow spaces in hashtag", TwitterHelper.isValidHashtag("#test tag"));
    }

    @Test
    public void correctlyValidHashtag() {

        assertTrue("Valid hashtag, should be allowed", TwitterHelper.isValidHashtag("#google"));
    }
}