package Insider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InsiderTests extends BaseTests {

    @Test
    public void testApplyForTheJob() throws InterruptedException {
        assertEquals("#1 Leader in Individualized, Cross-Channel CX — Insider",
                homePage.getTitle(),
                "Home page title not as expected");
        var careersPage = homePage.clickCareers();
        assertEquals("Insider Careers",
                careersPage.getTitle(),
                "Careers page title not as expected");
        assertTrue(careersPage.isLocationsBlockDisplayed(),
                "Locations not displayed");
        assertTrue(careersPage.isTeamsBlockDisplayed(),
                "Teams not displayed");
        assertTrue(careersPage.isLifeAtInsiderBlockDisplayed(),
                "Life At Insider not displayed");
        careersPage.clickSeeAllTeams();
        var qualityAssurancePage = careersPage.clickQualityAssurance();
        var openPositionsPage = qualityAssurancePage.clickSelectAllQAJobsButton();
        openPositionsPage.selectFromDropDown();
        assertTrue(openPositionsPage.isTitleContain());
        assertTrue(openPositionsPage.isDepartmentContain());
        assertTrue(openPositionsPage.isLocationContain());
        openPositionsPage.hoverOverApplylNowButton(1);
        openPositionsPage.clickApplyNowButton(1);
        openPositionsPage.switchToTab("Insider. - Software Quality Assurance Engineer (Remote)");
        assertEquals("Insider. - Software Quality Assurance Engineer (Remote)",
                openPositionsPage.getTitle(),
                "Home page title not as expected");
    }
}
