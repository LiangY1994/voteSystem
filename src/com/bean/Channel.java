package com.bean;

public class Channel {
	private int channelID; // channel id
	private String channelName; // channel name
	public Channel(String name) {
		// constructor stub
		this.channelName = name;
	}
	public int getChannelID(){ // get channel id
		return channelID;
	}
	public void setChannelID(int id){ // set channel id
		this.channelID = id;
	}
	public String getChannelName(){ // get channel name
		return channelName;
	}
	public void setChannelName(String name) { // set channel name
		this.channelName = name;
	}
}
