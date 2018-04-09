package com.idwall.RedditCrawler;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RedditCrawlThread extends Thread {
	private final String PRE_SUBREDDIT_URL = "https://www.reddit.com/r/";
	private final String POST_SUBREDDIT_URL = "/top/";
	
	private String subReddit;
	private String response = "";
	
	public RedditCrawlThread (String subReddit) {
		this.subReddit = subReddit;
	}
	
	
	@Override
	public void run() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get(PRE_SUBREDDIT_URL + this.subReddit+ POST_SUBREDDIT_URL);
		
		List<WebElement> posts = driver.findElements(By.className("linkflair"));
		
		for(WebElement post:posts){
			int votes = Integer.parseInt(post.findElement(By.className("score unvoted")).getText());
			
			if (votes >= 5000) {
				//número de upvotes, subreddit, título da thread, link para os comentários da thread, link da thread
				response += String.valueOf(votes) + " - " +
						this.subReddit + " - " + 
						post.findElement(By.className("title")).getText() + " - " + 
						post.getAttribute("data-permalink") + " - " + 
						post.getAttribute("data-permalink") + "\n";
				
			}
			
		}

	}

	
	public String getSubReddit() {
		return subReddit;
	}


	public void setSubReddit(String subReddit) {
		this.subReddit = subReddit;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}	
	
	public static void main (String[] args) throws InterruptedException {
		RedditCrawlThread testThread = new RedditCrawlThread ("cats");
		
		testThread.run();
		
		while(testThread.isAlive()) {
			Thread.sleep(1000);
		}
		
		String response = testThread.getResponse();
		System.out.println(response);
		
	}
	
}
