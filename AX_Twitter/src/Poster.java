import java.util.ArrayList;

import processing.core.PApplet;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Poster extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Poster");
	}

	public void settings(){
		size(1080,1080);
	}

	//Build an ArrayList to hold all of the words that we get from the imported tweets
	ArrayList<String> words = new ArrayList();

	public void setup() {
		//Set the size of the stage, and the background to black.
		//size(550,550);
		background(0);
		smooth();

		//Credentials
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("*****");
		cb.setOAuthConsumerSecret("*****");
		cb.setOAuthAccessToken("***-******");
		cb.setOAuthAccessTokenSecret("*****");

		//Now we’ll make the main Twitter object that we can use to do pretty much anything you can do on the twitter website
		//– get status updates, run search queries, find follower information, etc. This Twitter object gets built by something
		//called the TwitterFactory, which needs our configuration information that we set above:
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		//Now that we have a Twitter object, we want to build a query to search via the Twitter API for a specific term or phrase.
		// This is code that will not always work – sometimes the Twitter API might be down, or our search might not return any results,
		//or we might not be connected to the internet. The Twitter object in twitter4j handles those types of conditions by throwing back
		//an exception to us; we need to have a try/catch structure ready to deal with that if it happens:
		Query query = new Query("#audio");
		query.setCount(100);;
		//Try making the query request.
		try {
			QueryResult result = twitter.search(query);
			ArrayList tweets = (ArrayList) result.getTweets();

			for (int i = 0; i < tweets.size(); i++) {
				Tweet t = (Tweet) tweets.get(i);
				String user = t.getFromUser();
				String msg = t.getText();
				Date d = t.getCreatedAt();
				println("Tweet by " + user + " at " + d + ": " + msg);

				//Break the tweet into words
				String[] input = msg.split(" ");
				for (int j = 0; j < input.length; j++) {
					//Put each word into the words ArrayList
					words.add(input[j]);
				}
			};
		}
		catch (TwitterException te) {
			println("Couldn't connect: " + te);
		};
	}

	public void draw() {
		//Draw a faint black rectangle over what is currently on the stage so it fades over time.
		fill(0,1);
		rect(0,0,width,height);

		//Draw a word from the list of words that we've built
		int i = (frameCount % words.size());
		String word = words.get(i);

		//Put it somewhere random on the stage, with a random size and colour
		fill(255,random(50,150));
		textSize(random(10,30));
		text(word, random(width), random(height));
	}
}
