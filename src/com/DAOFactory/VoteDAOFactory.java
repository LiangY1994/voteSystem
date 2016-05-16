package com.DAOFactory;

import com.DAOImpl.VoteDAOImpl;

public class VoteDAOFactory {
	public static VoteDAOImpl getVoteDAOInstance(){
		return new VoteDAOImpl();
	}
}
