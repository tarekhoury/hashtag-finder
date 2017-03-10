# Hashtag Finder
Is a library that helps you to easily search for tweets by their Twitter hashtag (#)
# Download
Maven:
```java
<dependency>
  <groupId>com.tarekhoury.android</groupId>
  <artifactId>hashtag-finder</artifactId>
  <version>1.1</version>
  <type>pom</type>
</dependency>
```

Or Gradle:

```java
compile 'com.tarekhoury.android:hashtag-finder:1.1'
```
# Usage

```java
HashFinder finder = new HashFinder(
                TWITTER_CONSUMER_KEY,
                TWITTER_CONSUMER_SECRET,
                TWITTER_ACCESS_TOKEN,
                TWITTER_ACCESS_TOKEN_SECRET);
                
// Count must be in the 1-100 range
finder.setTweetsCount(count);

// Valid hashtag like #facebook (no spaces)
List<SimpleTweet> tweets = finder.search(hashtag);
```
