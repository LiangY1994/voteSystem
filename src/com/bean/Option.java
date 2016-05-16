package com.bean;

public class Option {
	private int optionID; // option id
	private String optionName; // option name
	private int optionNumber; // number of this option
	private int voteID; // vote id correspond
	public Option(){
		optionID = 0;
		optionName = "";
		optionNumber = 0;
		voteID = 0;
	}
	public Option(int id, String name, int number, int v_id) {
		optionID = id;
		this.optionName = name;
		this.optionNumber = number;
		this.voteID = v_id;
	}
	public int getOptionID() { // get option id
		return optionID;
	}
	public void setOptionID(int id){ // set option id
		this.optionID = id;
	}
	public String getOptionName(){ // get option name
		return optionName;
	}
	public void setOptionName(String name){ // set option name
		this.optionName = name;
	}
	public int getOptionNumber(){ // get option number
		return optionNumber;
	}
	public void setOptionNumber(int number){ // set option number
		this.optionNumber = number;
	}
	public int getVoteID() { // get vote id
		return voteID;
	}
	public void setVoteID(int id){ // set vote id
		this.voteID = id;
	}
}