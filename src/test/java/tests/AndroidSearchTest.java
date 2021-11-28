package tests;

import lib.CoreTestCase;
import lib.ui.pages.android.AndroidSearchPageObject;
import lib.ui.pages.android.AndroidStartPageObject;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class AndroidSearchTest extends CoreTestCase {

    @Test
    public void successfullyTestSearch() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        AndroidStartPageObject startPage = new AndroidStartPageObject(driver);
        AndroidSearchPageObject searchPage = new AndroidSearchPageObject(driver);

        onboardingPage.skipOnboarding();

        startPage.waitForElementPresent(
                "id:org.wikipedia:id/single_fragment_toolbar_wordmark",
                "Cannot find Wikipedia Logo"
        );

        startPage.waitForElementPresent(
                "id:org.wikipedia:id/largeLabel",
                "Cannot find Explore Button Label"
        );

        startPage.waitForElementPresent(
                "xpath:(//android.widget.ImageView[@content-desc=\"More options\"])[1]",
                "Cannot find News More Options Button"

        );

        startPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("Island of Indonesia");
    }

    @Test(expected = TimeoutException.class)
    public void unsuccessfullyTestSearch() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        AndroidStartPageObject startPage = new AndroidStartPageObject(driver);
        AndroidSearchPageObject searchPage = new AndroidSearchPageObject(driver);

        onboardingPage.skipOnboarding();

        startPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("wfewfewfwegweg");
    }
}