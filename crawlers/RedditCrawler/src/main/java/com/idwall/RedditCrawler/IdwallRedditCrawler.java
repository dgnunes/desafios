package com.idwall.RedditCrawler;

import java.util.ArrayList;
import java.util.List;

public class IdwallRedditCrawler {
	private String[] redditList;
	private List<RedditCrawlThread> crawlers = new ArrayList<RedditCrawlThread>();
	
	public IdwallRedditCrawler (String redditListString) {
		this.redditList = redditListString.split(";");
		
		for (String subreddit: redditList){
			crawlers.add(new RedditCrawlThread (subreddit));
		}
	}
	
	public void start() {
		for (Thread thread: crawlers){
			thread.run();
		}
	}
	
	public boolean isCrawlingFinished(){
		for (Thread thread: crawlers){
			if (thread.isAlive())
				return false;
		}
		
		return true;
	}
	
	public String getResult() throws InterruptedException{
		
		while (!isCrawlingFinished()){
    		Thread.sleep(1000);
    		
    	}
		
		String result = "";
		
		for (RedditCrawlThread thread: crawlers){
			result += thread.getResponse();
		}
		
		return result;
	}
	
	public String[] getRedditList() {
		return redditList;
	}

	public void setRedditList(String[] redditList) {
		this.redditList = redditList;
	}
	
	
	
	
}
