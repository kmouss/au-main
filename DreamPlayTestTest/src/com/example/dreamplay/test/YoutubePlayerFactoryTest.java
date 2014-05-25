package com.example.dreamplay.test;

import org.junit.Test;

import com.example.dreamplay.R;
import com.example.dreamplay.YoutubePlayerFactory;
import com.google.android.youtube.player.YouTubePlayerFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) 
public class YoutubePlayerFactoryTest extends
		ActivityInstrumentationTestCase2<YoutubePlayerFactory> {

	private YoutubePlayerFactory mActivity;
	private YouTubePlayerFragment mYouTubePlayerFragment;
	
	public YoutubePlayerFactoryTest() {
		super(YoutubePlayerFactory.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		
		mActivity = getActivity();
		mYouTubePlayerFragment =
		        (YouTubePlayerFragment) mActivity.getFragmentManager().findFragmentById(R.id.youtube_fragment);
	}

	@Test
	public void testGetYouTubePlayerProvider() {
		
	}

	@Test
	public void testOnCreateBundle() {
		assertTrue(mYouTubePlayerFragment.isInLayout());
		assertTrue(mYouTubePlayerFragment.isAdded());
		assertTrue(mYouTubePlayerFragment.isVisible());		
	}

}
