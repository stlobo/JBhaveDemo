package com.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.generic.actions.WebActions;
import com.generic.exceptions.WaitException;
import com.generic.page.base.WebPageBase;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;
import com.web.locators.GoogleSearchResultsLocators;

public class GoogleSearchResultsPage extends WebPageBase implements GoogleSearchResultsLocators{
    private static final Logger LOGGER = Logg.createLogger();

	public GoogleSearchResultsPage(WebDriver driver) throws WaitException {
		super(driver);
        this.webActions = new WebActions(driver);

	}
	
	public String getSearchResult(){
		try {
		String searchText = 	webActions.getText(PRESENCE, SEARCH_RESULT);
		return searchText;
		} catch (TimeoutException e) {
			LOGGER.error(Utilities.getCurrentThreadId()+"TimeoutException in getSearchResult()"+e.getStackTrace(),e);
		} catch (WaitException e) {
			LOGGER.error(Utilities.getCurrentThreadId()+"WaitException in getSearchResult()"+e.getStackTrace(),e);
		}
		return null;
		
	}

	
	
}
