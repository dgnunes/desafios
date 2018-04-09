package com.idwall.RedditCrawler;

import java.util.ArrayList;
import java.util.List;

public class IdwallRedditCrawler {
	private String[] redditList;
	private List<RedditCrawlThread> crawlers = new ArrayList<RedditCrawlThread>();
	
	public IdwallRedditCrawler (String redditList) {
		this.redditList = redditList.split(";");
		
		for (String subreddit: redditList){
			crawlers.add(new )
		}
	}
	
	public String[] getRedditList() {
		return redditList;
	}

	public void setRedditList(String[] redditList) {
		this.redditList = redditList;
	}
	
	
	
	
}
