package com.idwall.RedditCrawler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
       
    	IdwallRedditCrawler teste = new IdwallRedditCrawler ("brazil;programming;dogs;brazil;cats");
    	teste.start();
    	
    	while (!teste.isCrawlingFinished()){
    		Thread.sleep(1000);
    		
    	}
    	
    	System.out.println("TERMINOU");

    	System.out.println(teste.getResult());
    	
    }
}