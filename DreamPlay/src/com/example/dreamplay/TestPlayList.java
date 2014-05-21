package com.example.dreamplay;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class TestPlayList extends TestCase {

	public void testInitialize() {
	  PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"));
	  assertEquals(playlist.size(), 3); 
	 }
	
	public void testGetVideos() {
		PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"));
	    assertEquals(playlist.size(), 3); 
	    assertEquals(playlist.getVideos().size(), 3); 
	}
	
	public void testPlayListGetVideos() {
		PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"));
		assertEquals(playlist.getVideos().get(0).getUrl(), "a"); 
	}

	class FakeVideo extends Video
	{
		public FakeVideo(String url) { super (url);}
		
	}
	class FakePlayerFactory implements PlayerFactory
	{
		public FakePlayerFactory()
		{
			_played_urls = new ArrayList<String>();
		}
		public void play(Video video) 
		{
			_played_urls.add(video.getUrl());
		}
		
		public ArrayList<String> _played_urls;
	}

	
	public void testPlayListPlay() {
		FakePlayerFactory player = new FakePlayerFactory();
		PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"), player);
		playlist.play();
		assertEquals(player._played_urls.size(), 3); 
		assertEquals(playlist.getPlayedVideos().size(), 3);
		assertEquals(playlist.getVideos().size(), 0);
	}
}
