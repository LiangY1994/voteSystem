package com.DAO;

import java.util.List;
import com.bean.Vote;
import com.util.*;

public interface VoteDAO {
	public void addVote(Vote vote); // add a vote
	public void deleteVoteByName(String voteName, int channelID); // delete a vote by name
	public void updateVoteByName(Vote vote, String voteName, int channelID); // update a vote by name
	public Vote findVoteByName(String voteName, int channelID); // find a vote by name
	public List<Vote> findAllVoteByChannel(int channelID, Page page); // find all votes for one page
	public List<Vote> findAllVote(Page page); // find all votes
	public int findVotesAmountByChannel(int channelID); // find amount of votes of a channel
	public int findAllAmount(); // find amount of all votes
}