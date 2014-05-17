package com.example.dreamplay;

import junit.framework.TestCase;
import java.util.Arrays;

public class TestPlayController extends TestCase {

	public void testInitialize() {

	  PlayList playlist = new PlayList(Arrays.asList("a", "b", "c"));
	  assertEquals(playlist.size(), 3);
	 }
}
