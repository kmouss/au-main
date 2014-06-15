package com.example.dreamplay;

import java.util.Arrays;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") 

public class DreamPlayMainActivity extends YouTubeFailureRecoveryActivity {

	private YouTubePlayer mPlayer;
	private final YouTubePendingVideosQueue mVideosQueue;
	private final YouTubeVideosProvider mVideosProvider;
	
		
	//-------------------------------------------------------------------------------
	//    Initialize Activity 
	//-------------------------------------------------------------------------------
	
	public DreamPlayMainActivity() {
		mVideosQueue = new YouTubePendingVideosQueue();
		mVideosProvider = new YouTubeVideosProvider(mVideosQueue);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_main);
		initializeYouTubePlayerFragment();
		
	}

	private void initializeYouTubePlayerFragment() {
		YouTubePlayerFragment youTubePlayerFragment =
				(YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
		youTubePlayerFragment.initialize(DeveloperKey.DEVELOPER_KEY, this);
	}

	
	//-------------------------------------------------------------------------------
	//    YouTube Player API Callbacks 
	//-------------------------------------------------------------------------------
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
			mPlayer = player;
			try {
				mPlayer.loadVideos(mVideosQueue.popNextUrls());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
	}
	
	public YouTubePlayer getYouTubePlayer() {
		return mPlayer;
	}

}
