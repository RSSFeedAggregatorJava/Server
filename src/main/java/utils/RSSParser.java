package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSParser {
	
	private SyndFeed feed = null;
	
	public RSSParser(String feedUrl) throws IllegalArgumentException, FeedException, IOException {
		URL url = new URL(feedUrl);
		HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
		SyndFeedInput input = new SyndFeedInput();
		this.feed = input.build(new XmlReader(httpcon));
	}

	public SyndFeed getFeed() {
		return feed;
	}

	public void setFeed(SyndFeed feed) {
		this.feed = feed;
	}
	

}
