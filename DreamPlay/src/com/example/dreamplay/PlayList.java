package com.example.dreamplay;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

	List<Video> _videos;
	List<Video> _playedVideos;
	PlayerFactory _player;
	
	public PlayList(List<String> urls, PlayerFactory player) {
		_videos = new ArrayList<Video>();
		_playedVideos = new ArrayList<Video>();
		_player = player;
		
		for(String url : urls) {
			// CR: do we need to pay the cost of construction here?
			// can we just pass live with strings?
			_videos.add(new Video(url));
		}
	}

	//users YoutubePlayerFactory by default
	public PlayList(List<String> urls) {
		_videos = new ArrayList<Video>();
		_playedVideos = new ArrayList<Video>();
		_player = new YoutubePlayerFactory();
		
		for(String url : urls) {
			// CR: do we need to pay the cost of construction here?
			// can we just pass live with strings?
			_videos.add(new Video(url));
		}
	}
	
	public PlayList() {
		// TODO Auto-generated constructor stub
	}

	public long size() {
		// TODO Auto-generated method stub
		return _videos.size();
	}
	
	//CR: Can we expose this to tests only?
	public List<Video> getVideos() {
		return _videos;
	}
	
	public List<Video> getPlayedVideos() {
		return _playedVideos;
	}
	
	public void play()
	{
		//Note: we can do PlayerFactory.play and pass to it the full current list
		// pros: it can optimize by suing player.cueVideos on youtube api
		// cons: doesn's allow mixing youtube and other videos in a single playlist
		//       don't know how to get feedback when a video is completed to pop it from playlist queue
		
		//otherwise: can do for each video: video.play
		// pro: videos know how to play themselves, mixed video-type playlist
		// cons: each video carry extra memory to indicate its player type, can be a small type (byte or even bit)
	
		//we are going to go with the PlayerFactory for now
		while(!_videos.isEmpty())
		{
			Video video = _videos.get(0);
	
			//TODO fix data structures (this should probably be a compact queue)
			_player.play(video);
			
			//TODO: this should be atomic
			_videos.remove(video);
			_playedVideos.add(video);
		}
	}
	
}

