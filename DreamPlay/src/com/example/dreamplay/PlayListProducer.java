package com.example.dreamplay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PlayListProducer {

	private static final int MAX_PLAYLIST_ELEMENTS  = 100;
	private final BlockingQueue<Video> _videos;
	private final BlockingQueue<Video> _playedVideos;  // may be does not need to be blocking queue? array suffice?


	//users YoutubePlayerFactory by default
	public PlayListProducer(List<String> urls) {
		_videos = new ArrayBlockingQueue<Video>(MAX_PLAYLIST_ELEMENTS);
		_playedVideos = new ArrayBlockingQueue<Video>(MAX_PLAYLIST_ELEMENTS);
		
		for(String url : urls) {
			// CR: do we need to pay the cost of construction here?
			// can we just pass live with strings?
			_videos.add(new Video(url));
		}
	}
	
	public PlayListProducer() {
		_videos = new ArrayBlockingQueue<Video>(MAX_PLAYLIST_ELEMENTS);
		_playedVideos = new ArrayBlockingQueue<Video>(MAX_PLAYLIST_ELEMENTS);
	}

	public long size() {
		// TODO Auto-generated method stub
		return _videos.size();
	}
	
	public List<Video> popNextVideos() {
		List<Video> list = new ArrayList<Video>();
		_videos.drainTo(list);
		return list;
	}
	
	public List<String> popNextUrls() {
		//CR: This might be too expensive:
		//  duplicate list and walk through entire list twice
		//  may be simplify video type to be string only?
		//   or have an implicit conversion Video to string
		//TODO: Fix this later. Perf hit here. decide if it is worth it after measure.
		List<Video> videosList = popNextVideos();
		List<String> urlsList = new ArrayList<String>();
		for(Video video : videosList)
		{
			urlsList.add(video.getUrl());
		}
		
		return urlsList;
	}
	
	public List<Video> popPlayedVideos() {
		List<Video> list = new ArrayList<Video>();
		_playedVideos.drainTo(list);
		return list;
	}
	
//	public void play()
//	{
//		//Note: we can do PlayerFactory.play and pass to it the full current list
//		// pros: it can optimize by suing player.cueVideos on youtube api
//		// cons: doesn's allow mixing youtube and other videos in a single playlist
//		//       don't know how to get feedback when a video is completed to pop it from playlist queue
//		
//		//otherwise: can do for each video: video.play
//		// pro: videos know how to play themselves, mixed video-type playlist
//		// cons: each video carry extra memory to indicate its player type, can be a small type (byte or even bit)
//	
//		//we are going to go with the PlayerFactory for now
//		while(!_videos.isEmpty())
//		{
//			Video video = _videos.get(0);
//	
//			//TODO fix data structures (this should probably be a compact queue)
//			_player.play(video);
//			
//			//TODO: this should be atomic
//			_videos.remove(video);
//			_playedVideos.add(video);
//		}
//	}
	
}

