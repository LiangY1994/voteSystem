package com.DAOFactory;

import com.DAO.OptionDAO;
import com.DAOImpl.OptionDAOImpl;

public class OptionDAOFactory {
	public static OptionDAO getOptionDAOInstance() {
		return new OptionDAOImpl();
	}
}
