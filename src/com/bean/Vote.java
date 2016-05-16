package com.bean;

public class Vote {
	private int voteID; // vote id
	private String voteName; // vote name
	private int channelID; // channel id correspond
	public Vote(int id, String name, int c_id) {
		// TODO Auto-generated constructor stub
		this.voteID = id;
		this.voteName = name;
		this.channelID = c_id;
	}
	public Vote() {
		// TODO Auto-generated constructor stub
		voteID = 0;
		voteName = "";
		channelID = 0;
	}
	public int getVoteID(){ // get vote id
		return voteID;
	}
	public void setVoteID(int id) { // set vote id
		this.voteID = id;
	}
	public String getVoteName() { // get vote name
		return voteName;
	}
	public void setVoteName(String name) { // set vote name
		this.voteName = name;
	}
	public int getChannelID() { // get channel id correspond
		return channelID;
	}
	public void setChannelID(int id) { // set channel id correspond
		this.channelID = id;
	}
}
