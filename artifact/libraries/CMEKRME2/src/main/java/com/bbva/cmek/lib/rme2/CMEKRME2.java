package com.bbva.cmek.lib.rme2;

import com.bbva.cmek.dto.accounts.AccountDTO;

/**
 * The  interface CMEKRME2 class...
 */
public interface CMEKRME2 {

	/**
	 * The execute method...
	 */
	void execute();
	AccountDTO executeAccountValidation(AccountDTO account);
}
