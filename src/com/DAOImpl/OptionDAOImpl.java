package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DAO.OptionDAO;
import com.DAOFactory.OptionDAOFactory;
import com.bean.Option;
import com.util.DBConnection;
import com.util.Page;

public class OptionDAOImpl implements OptionDAO {

	@Override
	public void addOption(Option option) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "insert into tb_option(optionName, optionNumber, voteID)"
				+ " values(?,?,?);";
		try{
			Option option2 = OptionDAOFactory.getOptionDAOInstance().findOptionByID(option.getOptionID());
			if(option2 == null){
				preparedStatement = connection.prepareStatement(query);
				// set query parameters
				preparedStatement.setString(1, option.getOptionName());
				preparedStatement.setInt(2, option.getOptionNumber());
				preparedStatement.setInt(3, option.getVoteID());
				preparedStatement.executeUpdate(); // execute query
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public void deleteOptionByName(String optionName, int voteID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "delete from tb_option where optionName=? and voteID=?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, optionName);
			preparedStatement.setInt(2, voteID);
			preparedStatement.executeUpdate(); // execute query
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public void updateOptionByID(Option option, int optionID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "update tb_option set optionID=?, optionName=?, optionNumber=?, voteID=? "
				+ " where optionID=?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, option.getOptionID());
			preparedStatement.setString(2, option.getOptionName());
			preparedStatement.setInt(3, option.getOptionNumber());
			preparedStatement.setInt(4, option.getVoteID());
			preparedStatement.setInt(5, optionID);
			preparedStatement.executeUpdate(); // execute query
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
	}

	@Override
	public Option findOptionByID(int optionID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from tb_option where optionID=?";
		Option option = null;
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, optionID);
			resultSet = preparedStatement.executeQuery(); // execute query
			if(resultSet.next())
				option = new Option(resultSet.getInt(1), resultSet.getString(2), 
						resultSet.getInt(3), resultSet.getInt(4));
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return option;
	}

	@Override
	public List<Option> findAllOption(int voteID, Page page) {
		// TODO Auto-generated method stub
		List<Option> options = new ArrayList<Option>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from tb_option where voteID = ? limit ?,?";
		try {
			int sqlOffset = page.getCurrentPage()-1;
			sqlOffset *= page.getEachPage();
			int sqlSum = page.getEachPage();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, voteID);
			preparedStatement.setInt(2, sqlOffset);
			preparedStatement.setInt(3, sqlSum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Option option = new Option(resultSet.getInt(1),resultSet.getString(2), 
						resultSet.getInt(3), resultSet.getInt(4));
				options.add(option);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return options;
	}

	@Override
	public int findOptionsAmount(int voteID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection(); // initialization
		PreparedStatement preparedStatement = null;
		String query = "select count(optionID) as total from tb_option where voteID=?";
		ResultSet resultSet = null;
		int amount = 0; // initialization
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, voteID);
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
	public List<Option> findOptionByVoteID(int voteID) {
		List<Option> options = new ArrayList<Option>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from tb_option where voteID = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, voteID);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Option option = new Option(resultSet.getInt(1),resultSet.getString(2), 
						resultSet.getInt(3), resultSet.getInt(4));
				options.add(option);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConnection.closeResultSet(resultSet);
			DBConnection.closePreparedStatement(preparedStatement);
			DBConnection.closeConnection(connection);
		}
		return options;
	}

}
