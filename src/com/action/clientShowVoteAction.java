package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DAOFactory.OptionDAOFactory;
import com.DAOFactory.VoteDAOFactory;
import com.bean.Option;
import com.bean.Vote;
import com.bean.VoteResult;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Page;
import com.util.PageUtil;

public class clientShowVoteAction extends ActionSupport{
	private int channelID; // channel id
	private int currentPage; // current page
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		int sumRecord = VoteDAOFactory.getVoteDAOInstance().findVotesAmountByChannel(channelID);
		Page page = PageUtil.createPage(5, sumRecord, currentPage);
		List<Vote> votes = 
					VoteDAOFactory.getVoteDAOInstance().findAllVoteByChannel(channelID, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		List<VoteResult> voteResults = new ArrayList<VoteResult>();
		for(Vote vote:votes){ // get vote result
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			List<Option> options = OptionDAOFactory.getOptionDAOInstance().
										findOptionByVoteID(vote.getVoteID());
			voteResult.setOptions(options);
			voteResults.add(voteResult);
		}
		request.setAttribute("voteResults", voteResults);
		request.setAttribute("page", page);
		return Action.SUCCESS;
	}
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
