package com.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.DAO.VoteDAO;
import com.DAOFactory.VoteDAOFactory;
import com.bean.Vote;
import com.util.*;

public class VoteDAOImpl implements VoteDAO {

	@Override
	public void addVote(Vote vote) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "insert into tb_vote(voteName, channelID)"
				+ " values(?,?);";
		try{
			Vote vote2 = VoteDAOFactory.getVoteDAOInstance().findVoteByName(vote.getVoteName(), vote.getChannelID());
			if(vote2 == null){
				preparedStatement = connection.prepareStatement(query);
				// set query parameters
				preparedStatement.setString(1, vote.getVoteName());
				preparedStatement.setInt(2, vote.getChannelID());
				preparedStatement.executeUpdate(); // execute query
			}
			else{
				System.out.println("Vote already exists");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public void deleteVoteByName(String voteName, int channelID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		String query = "delete from tb_vote where voteName=? and channelID=?;";
		Vote vote = VoteDAOFactory.getVoteDAOInstance().findVoteByName(voteName, channelID);
		int voteID = vote.getVoteID();
		String query2 = "delete from tb_option where voteID=?";
		try{
			preparedStatement = connection.prepareStatement(query2); // delete options correspond
			preparedStatement.setInt(1, voteID);
			preparedStatement.executeUpdate();
			preparedStatement2 = connection.prepareStatement(query); // delete vote
			preparedStatement2.setString(1, voteName);
			preparedStatement2.setInt(2, channelID);
			preparedStatement2.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public void updateVoteByName(Vote vote, String voteName, int channelID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "update tb_vote set voteID=?, voteName=?, channelID=? where voteName=? and channelID=?;";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, vote.getVoteID());
			preparedStatement.setString(2, vote.getVoteName());
			preparedStatement.setInt(3, vote.getChannelID());
			preparedStatement.setString(4, voteName);
			preparedStatement.setInt(5, channelID);
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public Vote findVoteByName(String voteName, int channelID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "select * from tb_vote where voteName=? and channelID=?;";
		ResultSet resultSet = null;
		Vote vote = null;
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, voteName);
			preparedStatement.setInt(2, channelID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				vote = new Vote(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return vote;
	}

	@Override
	public List<Vote> findAllVoteByChannel(int channelID, Page page) {
		// TODO Auto-generated method stub
		List<Vote> votes = new ArrayList<Vote>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from tb_vote where channelID = ? limit ?,?";
		try {
			int sqlOffset = page.getCurrentPage()-1;
			sqlOffset *= page.getEachPage();
			int sqlSum = page.getEachPage();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, channelID);
			preparedStatement.setInt(2, sqlOffset);
			preparedStatement.setInt(3, sqlSum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Vote vote = new Vote(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				votes.add(vote);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return votes;
	}

	public List<Vote> findAllVote(Page page) {
		// TODO Auto-generated method stub
		List<Vote> votes = new ArrayList<Vote>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from tb_vote limit ?,?";
		try {
			int sqlOffset = page.getCurrentPage()-1;
			sqlOffset *= page.getEachPage();
			int sqlSum = page.getEachPage();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sqlOffset);
			preparedStatement.setInt(2, sqlSum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Vote vote = new Vote(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				votes.add(vote);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return votes;
	}
	
	@Override
	public int findVotesAmountByChannel(int channelID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "select count(voteID) as total from tb_vote where channelID=?";
		ResultSet resultSet = null;
		int amount = 0; // initialization
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, channelID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) // get the last id of all votes
				amount = resultSet.getInt("total");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return amount;
	}

	@Override
	public int findAllAmount() {
		// TODO Auto-generated method stub
		int amount = 0;
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select count(voteID) as total from tb_vote";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				amount = resultSet.getInt("total");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return amount;
	}
}
