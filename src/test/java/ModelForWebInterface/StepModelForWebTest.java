package ModelForWebInterface;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepModelForWebTest
{
    private static final String Repository = "eroshenkoam/allure-example";
    private static final int NumberIssue = 87;

    public int getNumberIssue()
    {
        return NumberIssue;
    }
    public String getRepository()
    {
        return Repository;
    }
    @Step("Открываем главную страницу")
    public void openMainPage()
    {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo)
    {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
    }
    @Step ("Кликаем по ссылке репозитория {repo}")
    public void clickOnLinkRepository(String repo)
    {
        $(By.linkText(repo)).click();

    }

    @Step("Переходим в Ишью {repo}")
    public void goToIssueTab()
    {
        $("#issues-tab").click();
    }
    @Step("Проверяем что есть ишью с таким номер {issue}")
    public void CheckedResults(int issue)
    {
        $(withText("#" + issue)).should(Condition.exist);

    }
}
