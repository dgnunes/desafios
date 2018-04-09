package com.idwall.crawlers.RedditCrawler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.idwall.crawlers.RedditCrawler.implementation.RedditCrawlThread;

public class RedditCrawlThreadTest {

	@Test
	public void test() throws InterruptedException {
		RedditCrawlThread testThread = new RedditCrawlThread ("cats");
		
		testThread.run();
		
		while(testThread.isAlive()) {
			Thread.sleep(1000);
		}
		
		String response = testThread.getResponse();
		System.out.println(response);
		
		assertTrue(!response.isEmpty());
	}

}
