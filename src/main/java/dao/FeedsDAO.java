package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Feed;
import io.swagger.model.InlineResponse2001;
import utils.DBConnect;

public class FeedsDAO {

	public static void createFeed(Feed feed) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("INSERT IGNORE INTO feeds SET user_id = ?, title = ?, url = ?, description = ?, link = ?");
		stt.setLong(1, feed.getUserId());
		stt.setString(2, feed.getTitle());
		stt.setString(3, feed.getFeedUrl());
		stt.setString(4, feed.getDescription());
		stt.setString(5, feed.getLink());
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}

	public static List<InlineResponse2001> readFeeds(int userId) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT id, title FROM feeds WHERE user_id = ?");
		stt.setInt(1, userId);
		ResultSet rs = stt.executeQuery();
		if (rs.isLast())
			return null;
		List<InlineResponse2001> feeds = new ArrayList<InlineResponse2001>();
		while (rs.next()) {
			InlineResponse2001 feed = new InlineResponse2001();
			feed.setId(rs.getInt("id"));
			feed.setTitle(rs.getString("title"));
			feeds.add(feed);
		}
		//TODO: Gestion erreur
		stt.close();
		return feeds;
	}

	public static void deleteFeed(Integer feedId) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("DELETE FROM feeds WHERE id = ?");
		stt.setLong(1, feedId);
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}

	public static Feed readFeed(Long feedId) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT * FROM feeds WHERE id = ?");
		stt.setLong(1, feedId);
		ResultSet rs = stt.executeQuery();
		if (rs.isLast())
			return null;

		rs.next();
		Feed feed = new Feed();
		feed.setId(rs.getInt("id"));
		feed.setTitle(rs.getString("title"));
		feed.setFeedUrl(rs.getString("url"));
		feed.setDescription(rs.getString("description"));
		feed.setLink(rs.getString("link"));
		feed.setCopyright(rs.getString("copyright"));
		feed.setImage(rs.getString("image"));
		feed.setLanguage(rs.getString("language"));
		feed.setPubDate(rs.getString("pubDate"));
		//TODO: Gestion erreur
		stt.close();
		return feed;
	}

}
