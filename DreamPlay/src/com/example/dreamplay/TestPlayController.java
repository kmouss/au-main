package com.example.dreamplay;

import junit.framework.TestCase;

public class TestPlayController extends TestCase {

	public void testInitialize() {

	  PlayList playlist = new PlayList();
	  assertEquals(playlist.size(), 0);
	 }
}
