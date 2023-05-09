package com.bbva.cmek.lib.rme2;

import com.bbva.cmek.dto.accounts.AccountDTO;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CMEKRME2-app.xml",
		"classpath:/META-INF/spring/CMEKRME2-app-test.xml",
		"classpath:/META-INF/spring/CMEKRME2-arc.xml",
		"classpath:/META-INF/spring/CMEKRME2-arc-test.xml" })
public class CMEKRME2Test {

	@Spy
	private Context context;

	@Resource(name = "cmekRME2")
	private CMEKRME2 cmekRME2;

	@Mock
	private CMEKRME2 cmekRME3;

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
		Object result = this.cmekRME2;
		if(this.cmekRME2 instanceof Advised){
			Advised advised = (Advised) this.cmekRME2;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		cmekRME2.execute();
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeAccountValidation(){
		AccountDTO account = new AccountDTO();
		account.setStatus(false);
		Mockito.when(cmekRME3.executeAccountValidation(account)).thenReturn(account);
	}
	
}
