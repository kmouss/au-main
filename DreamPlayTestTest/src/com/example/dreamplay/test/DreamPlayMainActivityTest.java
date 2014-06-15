package com.example.dreamplay.test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.example.dreamplay.R;
import com.example.dreamplay.DreamPlayMainActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) 
public class DreamPlayMainActivityTest extends
ActivityInstrumentationTestCase2<DreamPlayMainActivity> {

	private DreamPlayMainActivity mActivity;
	private YouTubePlayerFragment mYouTubePlayerFragment;

	public DreamPlayMainActivityTest() {
		super(DreamPlayMainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);

		mActivity = getActivity();
		mYouTubePlayerFragment =
				(YouTubePlayerFragment) mActivity.getFragmentManager().findFragmentById(R.id.youtube_fragment);

	}

	@Test
	public void testOnCreateBundle() {
		assertTrue(mYouTubePlayerFragment.isInLayout());
		assertTrue(mYouTubePlayerFragment.isAdded());
		assertTrue(mYouTubePlayerFragment.isVisible());
	}
	
	@Test
	public void testOnInitializationSuccess() {
		try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		YouTubePlayer ytPlayer = mActivity.getYouTubePlayer();
		assertTrue(ytPlayer.hasNext());
		assertTrue(ytPlayer.isPlaying());	
	}
	
}

