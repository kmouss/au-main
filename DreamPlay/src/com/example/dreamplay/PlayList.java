package com.example.dreamplay;

import java.util.List;

public class PlayList {

	List<String> videos;
	
	public PlayList(List<String> list) {
		videos = list;
	}

	public PlayList() {
		// TODO Auto-generated constructor stub
	}

	public long size() {
		// TODO Auto-generated method stub
		return videos.size();
	}

}
