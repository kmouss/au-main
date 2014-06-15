package com.example.dreamplay;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class YouTubePendingVideosQueueTest extends TestCase {

	public void testInitialize() {
	  YouTubePendingVideosQueue playlist = new YouTubePendingVideosQueue(Arrays.asList("a", "b", "c"));
	  assertEquals(playlist.size(), 3); 
	 }
	
	public void testGetVideos() {
		YouTubePendingVideosQueue playlist = new YouTubePendingVideosQueue(Arrays.asList("a", "b", "c"));
	    assertEquals(playlist.size(), 3); 
	    try {
			assertEquals(playlist.popNextUrls().size(), 3);
		} catch (InterruptedException e) {
			fail("InterruptedException thrown while attempting to wait for the next urls in the queue " + e.toString());
			e.printStackTrace();
		} 
	}
	
	public void testPlayListGetVideos() {
		YouTubePendingVideosQueue playlist = new YouTubePendingVideosQueue(Arrays.asList("a", "b", "c"));
		try {
			assertEquals(playlist.popNextUrls().get(0), "a");
		} catch (InterruptedException e) {
			fail("InterruptedException thrown while attempting to wait for the next urls in the queue " + e.toString());
			e.printStackTrace();
		} 
	}
	
	
//	class FakePlayerFactory implements PlayerFactory
//	{
//		public FakePlayerFactory()
//		{
//			_played_urls = new ArrayList<String>();
//		}
//		public void play(Video video) 
//		{
//			_played_urls.add(video.getUrl());
//		}
//		
//		public ArrayList<String> _played_urls;
//	}

	
//	public void testPlayListPlay() {
//		FakePlayerFactory player = new FakePlayerFactory();
//		PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"), player);
//		playlist.play();
//		assertEquals(player._played_urls.size(), 3); 
//		assertEquals(playlist.getPlayedVideos().size(), 3);
//		assertEquals(playlist.getVideos().size(), 0);
//	}
}
