package com.DAO;

import java.util.List;

import com.bean.Option;
import com.util.Page;

public interface OptionDAO {
	public void addOption(Option option); // add a Option
	public void deleteOptionByName(String optionName, int voteID); // delete a Option by name
	public void updateOptionByID(Option option, int optionID); // update a Option by id
	public Option findOptionByID(int optionID); // find a Option by id
	public List<Option> findAllOption(int voteID, Page page); // find all Options for one page
	public List<Option> findOptionByVoteID(int voteID); // find options by vote id
	public int findOptionsAmount(int voteID); // find amounts of Options
}