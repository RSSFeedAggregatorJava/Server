package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;

import dao.FeedsDAO;
import io.swagger.model.Article;
import io.swagger.model.Feed;
import utils.RSSParser;

public class ArticlesController {
	
	public static List<Article> getArticles(String feedId, String apiKey) throws SQLException, IllegalArgumentException, FeedException, IOException {
		Feed feed = FeedsDAO.readFeed(Long.valueOf(feedId));
		RSSParser parser = new RSSParser(feed.getFeedUrl());
		SyndFeed xml = parser.getFeed();
		List<Article> articles = new ArrayList<Article>();
		List<?> entries = xml.getEntries();
		Iterator<?> itEntries = entries.iterator();
 
		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			System.out.println("Title: " + entry.getTitle());
			System.out.println("Link: " + entry.getLink());
			System.out.println("Author: " + entry.getAuthor());
			System.out.println("Publish Date: " + entry.getPublishedDate());
			System.out.println("Description: " + entry.getDescription().getValue());
		}
		
		//return articles;
		return null;
	}
}
