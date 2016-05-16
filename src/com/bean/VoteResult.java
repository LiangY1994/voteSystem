package com.bean;

import java.util.List;

public class VoteResult {
	private Vote vote;
	private List<Option> options;
	public Vote getVote(){ // get vote
		return this.vote;
	}
	public void setVote(Vote v){ // set vote
		this.vote = v;
	}
	public List<Option> getOptions(){ // get options
		return this.options;
	}
	public void setOptions(List<Option> ops) { // set options
		this.options = ops;
	}
}
