package com.bbva.cmek.lib.rme2.impl;

import com.bbva.cmek.lib.rme2.CMEKRME2;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class CMEKRME2Abstract extends AbstractLibrary implements CMEKRME2 {

	protected ApplicationConfigurationService applicationConfigurationService;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

}