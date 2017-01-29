package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;

import dao.FeedsDAO;
import dao.UsersDAO;
import io.swagger.model.Feed;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.User;
import utils.RSSParser;

public class FeedsController {

	public static void subscribeFeed(String feedUrl, String apiKey) throws SQLException, IllegalArgumentException, FeedException, IOException {
		Feed feed = new Feed();
		User user = UsersDAO.readUserByApiKey(apiKey);
		RSSParser parser = new RSSParser(feedUrl);
		SyndFeed xml = parser.getFeed();

		feed.setUserId(user.getUserId());
		feed.setTitle(xml.getTitle());
		feed.setFeedUrl(feedUrl);
		feed.setDescription(xml.getDescription());
		feed.setLink(xml.getLink());
		feed.setCopyright(xml.getCopyright());
		feed.setImage(xml.getImage().getUrl());
		feed.setLanguage(xml.getLanguage());
		feed.setPubDate(xml.getPublishedDate().toString());
		FeedsDAO.createFeed(feed);
	}

	public static List<InlineResponse2001> getFeeds(String apiKey) throws SQLException, IllegalArgumentException, FeedException, IOException {
		User user = UsersDAO.readUserByApiKey(apiKey);
		return FeedsDAO.readFeeds(user.getUserId());
	}

	public static void unsubscribeFeed(Integer feedId, String apiKey) throws SQLException {
		FeedsDAO.deleteFeed(feedId);
	}

	public static Feed getFeed(Long feedId, String apiKey) throws SQLException {
		//TODO: secure
		return FeedsDAO.readFeed(feedId);
	}
}
