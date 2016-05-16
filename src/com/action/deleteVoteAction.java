package com.action;

import com.DAOFactory.VoteDAOFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class deleteVoteAction extends ActionSupport{
	private String voteName; // vote name
	private int channelID; // channel id
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		VoteDAOFactory.getVoteDAOInstance().deleteVoteByName(voteName, channelID);
		return Action.SUCCESS;
	}
	public void setVoteName(String voteName){
		this.voteName = voteName;
	}
	public String getVoteName(){
		return this.voteName;
	}
	public void setChannelID(int id){
		this.channelID = id;
	}
	public int getChannelID(){
		return this.channelID;
	}
}
