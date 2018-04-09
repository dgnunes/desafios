package com.idwall.crawlers.RedditCrawler.implementation;

import java.util.ArrayList;
import java.util.List;

public class IdwallRedditCrawler {
	private String[] redditList;
	private List<RedditCrawlThread> crawlers = new ArrayList<>();
	
	public IdwallRedditCrawler (String redditList) {
		this.redditList = redditList.split(";");
	}
	
	public String[] getRedditList() {
		return redditList;
	}

	public void setRedditList(String[] redditList) {
		this.redditList = redditList;
	}
	
	
	
	
}
