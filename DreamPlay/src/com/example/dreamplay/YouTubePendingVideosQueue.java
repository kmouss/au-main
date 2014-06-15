package com.example.dreamplay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class YouTubePendingVideosQueue {

	private static final int MAX_PLAYLIST_ELEMENTS  = 100;
	private final BlockingQueue<String> mVideosBlqQueue;
	private final BlockingQueue<String> mPlayedVideosBlqQueue;  // may be does not need to be blocking queue? array suffice?


	//users YoutubePlayerFactory by default
	public YouTubePendingVideosQueue(List<String> urls) {
		mVideosBlqQueue = new ArrayBlockingQueue<String>(MAX_PLAYLIST_ELEMENTS);
		mPlayedVideosBlqQueue = new ArrayBlockingQueue<String>(MAX_PLAYLIST_ELEMENTS);
		
		pushUrls(urls);
	}
	
	public YouTubePendingVideosQueue() {
		mVideosBlqQueue = new ArrayBlockingQueue<String>(MAX_PLAYLIST_ELEMENTS);
		mPlayedVideosBlqQueue = new ArrayBlockingQueue<String>(MAX_PLAYLIST_ELEMENTS);
	}

	public long size() {
		// TODO Auto-generated method stub
		return mVideosBlqQueue.size();
	}	
	
	public List<String> popNextUrls() throws InterruptedException {
		List<String> urlsList = new ArrayList<String>();
		
		//wait for up to 2 seconds until there is at least one item in the queue
		urlsList.add(mVideosBlqQueue.poll(2000, TimeUnit.MILLISECONDS)); 
		mVideosBlqQueue.drainTo(urlsList);
		return urlsList;
	}
	
	public List<String> popPlayedUrls() {
		List<String> list = new ArrayList<String>();
		mPlayedVideosBlqQueue.drainTo(list);
		return list;
	}
	
	public void pushUrls(List<String> urls)
	{
		mVideosBlqQueue.addAll(urls);
	}
}

