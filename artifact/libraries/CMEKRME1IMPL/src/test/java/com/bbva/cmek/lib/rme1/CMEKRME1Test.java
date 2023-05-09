package com.bbva.cmek.lib.rme1;

import com.bbva.cmek.dto.accounts.AccountDTO;
import com.bbva.cmek.dto.payments.BillDTO;
import com.bbva.cmek.dto.payments.PaymentDTO;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.server.endpoint.mapping.XPathPayloadEndpointMapping;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CMEKRME1-app.xml",
		"classpath:/META-INF/spring/CMEKRME1-app-test.xml",
		"classpath:/META-INF/spring/CMEKRME1-arc.xml",
		"classpath:/META-INF/spring/CMEKRME1-arc-test.xml" })
public class CMEKRME1Test {

	@Spy
	private Context context;

	@Resource(name = "cmekRME1")
	private CMEKRME1 cmekRME1;

	@Mock
	private CMEKRME1 cmekRME2;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cmekRME1;
		if(this.cmekRME1 instanceof Advised){
			Advised advised = (Advised) this.cmekRME1;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		cmekRME1.execute();
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeDoBillTest(){
		PaymentDTO payment = new PaymentDTO();
		AccountDTO account = new AccountDTO();
		BillDTO bill = new BillDTO();
		// DATA
		account.setBalance(20000);
		account.setId("1000");
		account.setStatus(true);
		account.setOwnerAccount("Alejandro Mateus");
		//
		//
		bill.setIdBill(UUID.randomUUID().toString());
		bill.setValue(10000);
		bill.setNumber("100");
		//
		//
		payment.setBill(bill);
		payment.setAccount(account);
		Mockito.when(cmekRME2.executeDoBillPayment(payment)).thenReturn(payment);
	}
}
