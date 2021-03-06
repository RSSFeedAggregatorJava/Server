package controller;

import java.io.IOException;
import java.net.URLDecoder;
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
		RSSParser parser = new RSSParser(URLDecoder.decode(feedUrl.substring(feedUrl.lastIndexOf('=') + 1)));
		SyndFeed xml = parser.getFeed();

		feed.setUserId(user.getUserId());
		if (xml.getTitle() != null)
			feed.setTitle(xml.getTitle());
		feed.setFeedUrl(feedUrl);
		if (xml.getDescription() != null)
			feed.setDescription(xml.getDescription());
		if (xml.getLink() != null)
			feed.setLink(xml.getLink());
		if (xml.getCopyright() != null)
			feed.setCopyright(xml.getCopyright());
		if (xml.getImage() != null && xml.getImage().getUrl() != null)
			feed.setImage(xml.getImage().getUrl());
		if (xml.getLanguage() != null)
			feed.setLanguage(xml.getLanguage());
		if (xml.getPublishedDate() != null)
			feed.setPubDate(xml.getPublishedDate().toString());
		FeedsDAO.createFeed(feed);
	}

	public static List<InlineResponse2001> getFeeds(String apiKey) throws SQLException, IllegalArgumentException, FeedException, IOException {
		User user = UsersDAO.readUserByApiKey(apiKey);
		return FeedsDAO.readFeeds(user.getUserId());
	}

	public static void unsubscribeFeed(String feedId, String apiKey) throws SQLException {
		String buff = feedId.toString();
		FeedsDAO.deleteFeed(buff.substring(buff.lastIndexOf('=') + 1));
	}

	public static Feed getFeed(Long feedId, String apiKey) throws SQLException {
		//TODO: secure
		return FeedsDAO.readFeed(feedId);
	}
}
