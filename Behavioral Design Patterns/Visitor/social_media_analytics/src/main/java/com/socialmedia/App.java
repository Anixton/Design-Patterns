package com.socialmedia;

import java.util.Arrays;
import java.util.List;

/**
 * The App class serves as the primary entry point for the application.
 * 
 * The application begins by initializing a list of posts, which can be of varying types: TextPost, ImagePost, or VideoPost.
 * Each of these classes adheres to the Post interface, thereby possessing an accept method that accepts a Visitor.
 * 
 * A PostCounter, a specific type of Visitor, is then instantiated. The PostCounter's responsibility is to tally the number of posts.
 * The application iterates over the list of posts, invoking the accept method of each post with the PostCounter as the argument.
 * Within the accept method of each post, the visit method of the PostCounter is invoked, incrementing the count.
 * Upon completion of the iteration, the total number of posts, stored in the PostCounter, is printed.
 * 
 * Subsequently, an AverageTextLengthCalculator, another type of Visitor, is created. Its function is to compute the average length of text posts.
 * The application iterates over the list of posts once more, invoking the accept method of each post with the AverageTextLengthCalculator as the argument.
 * Within the accept method of each post, the visit method of the AverageTextLengthCalculator is invoked, updating the total text length and the count of text posts.
 * Upon completion of the iteration, the average text length, computed by the AverageTextLengthCalculator, is printed.
 * 
 * Lastly, a CommonWordsFinder, another type of Visitor, is instantiated. Its function is to identify the most frequently occurring words in text posts.
 * The application iterates over the list of posts once again, invoking the accept method of each post with the CommonWordsFinder as the argument.
 * Within the accept method of each post, the visit method of the CommonWordsFinder is invoked, updating the word counts.
 * Upon completion of the iteration, the most frequently occurring words, identified by the CommonWordsFinder, are displayed.
 * 
 * This application exemplifies the versatility of the Visitor pattern: it allows for the addition of new operations (such as post counting, average text length calculation, and common word finding) to the Post classes without necessitating their modification.
 */

public class App 
{
    public static void main( String[] args )
    {
        List<Post> posts = Arrays.asList(new TextPost("Text Post Title","This text post"), 
                                         new ImagePost("Image Post Title","https://hakangezginci.site/images/pic12.png"), 
                                         new VideoPost("Video Post Title","https://www.youtube.com/watch?v=4Wa5DivljOM"));
        PostCounter postCounter = new PostCounter();
        for (Post post : posts) {
            post.accept(postCounter);
        }
        System.out.println("Total number of posts: " + postCounter.getCount());

        AverageTextLengthCalculator averageTextLengthCalculator = new AverageTextLengthCalculator();
        for (Post post : posts) {
            post.accept(averageTextLengthCalculator);
        }
        System.out.println("Average text length: " + averageTextLengthCalculator.getAverageTextLength());
    
        CommonWordsFinder commonWordsFinder = new CommonWordsFinder();
        for (Post post : posts) {
            post.accept(commonWordsFinder);
        }
        commonWordsFinder.displayCommonWords();
    }
}
