package com.example.dreamplay;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestPlayListProducer extends TestCase {

	public void testInitialize() {
	  PlayListProducer playlist = new PlayListProducer(Arrays.asList("a", "b", "c"));
	  assertEquals(playlist.size(), 3); 
	 }
	
	public void testGetVideos() {
		PlayListProducer playlist = new PlayListProducer(Arrays.asList("a", "b", "c"));
	    assertEquals(playlist.size(), 3); 
	    assertEquals(playlist.popNextVideos().size(), 3); 
	}
	
	public void testPlayListGetVideos() {
		PlayListProducer playlist = new PlayListProducer(Arrays.asList("a", "b", "c"));
		assertEquals(playlist.popNextVideos().get(0).getUrl(), "a"); 
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
