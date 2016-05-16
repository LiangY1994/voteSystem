package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DAO.OptionDAO;
import com.DAOFactory.OptionDAOFactory;
import com.bean.Option;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class clientVoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int voteID; // vote id
	private int optionID; // option id
	public String execute() throws Exception{
		OptionDAO optionDAO = OptionDAOFactory.getOptionDAOInstance();
		Option option = optionDAO.findOptionByID(optionID);
		int sum = option.getOptionNumber();
		sum++;
		option.setOptionNumber(sum);
		optionDAO.updateOptionByID(option, optionID);
		return Action.SUCCESS;
	}
	public int getVoteID() {
		return voteID;
	}
	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
	public int getOptionID() {
		return optionID;
	}
	public void setOptionID(int optionID) {
		this.optionID = optionID;
	}

}
