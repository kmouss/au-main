package com.example.dreamplay;

public class Video {

	private String _url;
	
	public Video(String url) {
		_url = url;
	}
	
	public String getUrl() {
		return _url;
	}
	
	public String toString() {
        return _url;
    }

}
