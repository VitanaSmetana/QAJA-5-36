package tests;

import lib.CoreTestCase;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;

public class SearchTest extends CoreTestCase {

    @Test
    public void testSearch() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("Island of Indonesia");
    }
}
//	//*[contains(@text,"Island of")]
//org.wikipedia:id/search_container