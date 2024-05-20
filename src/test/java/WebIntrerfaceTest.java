import ModelForWebInterface.StepModelForWebTest;
import org.junit.jupiter.api.Test;

public class WebIntrerfaceTest
{

    @Test
    public void AnnotationSearchTest() {
        StepModelForWebTest tests = new StepModelForWebTest();
        tests.openMainPage();
        tests.searchForRepository(tests.getRepository());
        tests.clickOnLinkRepository(tests.getRepository());
        tests.goToIssueTab();
        tests.CheckedResults(tests.getNumberIssue());
    }
}
