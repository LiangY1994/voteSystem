package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.DAOFactory.OptionDAOFactory;
import com.bean.Option;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class clientShowResultAction extends ActionSupport{

	/**
	 * 
	 */
	private int voteID; // vote id
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Option> options = OptionDAOFactory.getOptionDAOInstance().findOptionByVoteID(voteID);
		request.setAttribute("options", options);
		return Action.SUCCESS;
	}
	public int getVoteID() {
		return voteID;
	}
	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
}
