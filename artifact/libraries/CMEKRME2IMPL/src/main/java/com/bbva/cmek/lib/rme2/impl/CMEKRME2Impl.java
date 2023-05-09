package com.bbva.cmek.lib.rme2.impl;

import com.bbva.cmek.dto.accounts.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CMEKRME2Impl class...
 */
public class CMEKRME2Impl extends CMEKRME2Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CMEKRME2Impl.class);

	@Override
	public AccountDTO executeAccountValidation(AccountDTO account) {
		if (account.isStatus()){
			LOGGER.error("The account is ACTIVE");
			return account;
		}else{
			LOGGER.error("The account is DEACTIVE");
			return account;
		}
	}

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		// TODO - Implementation of business logic
	}
}
