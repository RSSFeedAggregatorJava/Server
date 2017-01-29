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
import io.swagger.model.InlineResponse2001;
import utils.RSSParser;

public class ArticlesController {

	public static List<InlineResponse2001> getArticles(String feedId, String apiKey) throws SQLException, IllegalArgumentException, FeedException, IOException {
		Feed feed = FeedsDAO.readFeed(Long.valueOf(feedId));
		RSSParser parser = new RSSParser(feed.getFeedUrl());
		SyndFeed xml = parser.getFeed();
		List<InlineResponse2001> articles = new ArrayList<InlineResponse2001>();
		List<?> entries = xml.getEntries();
		Iterator<?> itEntries = entries.iterator();

		int n = 0;
		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			InlineResponse2001 article = new InlineResponse2001();
			article.setTitle(entry.getTitle());
			article.setId(n++);
			articles.add(article);
		}

		return articles;
	}

	public static Article getArticle(String feedId, String articleId) throws SQLException, IllegalArgumentException, FeedException, IOException {
		Feed feed = FeedsDAO.readFeed(Long.valueOf(feedId));
		RSSParser parser = new RSSParser(feed.getFeedUrl());
		SyndFeed xml = parser.getFeed();
		List<Article> articles = new ArrayList<Article>();
		List<?> entries = xml.getEntries();
		Iterator<?> itEntries = entries.iterator();

		int n = 0;
		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			Article article = new Article();
			article.setTitle(entry.getTitle());
			article.setAuthor(entry.getAuthor());
			article.setDescription(entry.getDescription().getValue());
			article.setLink(entry.getLink());
			article.setId(n++);
			articles.add(article);
		}
		
		return articles.get(Integer.valueOf(articleId));
	}
}
