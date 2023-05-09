package com.bbva.cmek.lib.rme1.impl;

import com.bbva.cmek.dto.accounts.AccountDTO;
import com.bbva.cmek.dto.payments.BillDTO;
import com.bbva.cmek.dto.payments.PaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The CMEKRME1Impl class...
 */
public class CMEKRME1Impl extends CMEKRME1Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CMEKRME1Impl.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		// TODO - Implementation of business logic
	}

	@Override
	public PaymentDTO executeDoBillPayment(PaymentDTO payment) {
		AccountDTO account = payment.getAccount();
		BillDTO bill = payment.getBill();
		if (account.getBalance() < bill.getValue()){
			account.setStatus(false);
			LOGGER.error("The account not have balance");
			return payment;
		}
		else{
			long newBalance = payment.getAccount().getBalance() - payment.getBill().getValue();
			payment.getAccount().setBalance(newBalance);
			payment.setId(UUID.randomUUID().toString());
			payment.setOperationDateTime(LocalDateTime.now().toString());
			return payment;
		}
	}
}
