package com.action;

import com.DAOFactory.OptionDAOFactory;
import com.DAOFactory.VoteDAOFactory;
import com.bean.Option;
import com.bean.Vote;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class addVoteAction extends ActionSupport{
	private int channelID; // channel id
	private String voteName; // vote name
	private String[] options; // options
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		Vote vote = new Vote();
		vote.setChannelID(channelID);
		vote.setVoteName(voteName);
		VoteDAOFactory.getVoteDAOInstance().addVote(vote);
		int voteID = VoteDAOFactory.getVoteDAOInstance().findVoteByName(voteName, channelID).getVoteID(); // get vote id
		for(String optionName:options){
			Option option = new Option();
			option.setOptionName(optionName);
			option.setVoteID(voteID);
			OptionDAOFactory.getOptionDAOInstance().addOption(option);
		}
		return Action.SUCCESS;
	}
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	public String getVoteName() {
		return voteName;
	}
	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}
	public String[] getOption() {
		return options;
	}
	public void setOption(String[] options) {
		this.options = options;
	}
}
