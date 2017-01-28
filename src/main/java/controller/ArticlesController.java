package controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.synd.SyndFeed;

import io.swagger.model.Article;
import utils.RSSParser;

public class ArticlesController {
	
	public static List<Article> getArticles(String feedId, String apiKey) {
		
		/*FeedsDAO
		RSSParser parser = new RSSParser(feedUrl);
		SyndFeed xml = parser.getFeed();
		List<Article> articles = new ArrayList<Article>();
		
		/*List<?> entries = feed.getEntries();
		Iterator<?> itEntries = entries.iterator();
 
		while (itEntries.hasNext()) {
			entry = (SyndEntry) itEntries.next();
			System.out.println("Title: " + entry.getTitle());
			System.out.println("Link: " + entry.getLink());
			System.out.println("Author: " + entry.getAuthor());
			System.out.println("Publish Date: " + entry.getPublishedDate());
			System.out.println("Description: " + entry.getDescription().getValue());
		}*/
		
		//return articles;
		return null;
	}
}
