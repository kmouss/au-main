package com.example.dreamplay;

import java.util.Arrays;

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

	private PlayListProducer mPlayList;
	private YouTubePlayer mPlayer;

	//-------------------------------------------------------------------------------
	//    Initialize Activity 
	//-------------------------------------------------------------------------------
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_main);
		initializeYouTubePlayerFragment();
		initializePlayList();
	}

	private void initializePlayList() {
		mPlayList = new PlayListProducer(Arrays.asList("QrwdTlVxjj4", "0dTHyp3peqk", "xPgni28Kuc8", "-1uF_J6JAMQ"));
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
			mPlayer.loadVideos(mPlayList.popNextUrls());
		}
	}

	@Override
	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
	}

}
