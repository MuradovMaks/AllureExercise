import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private static final String Repository = "eroshenkoam/allure-example";
    private static final int NumberIssue = 87;

    @Test
    public void testLambdaTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + Repository, () ->
        {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(Repository);
            $("#query-builder-test").pressEnter();
        });
        step("Кликаем по ссылке репозитория" + Repository, () ->
        {
            $(By.linkText(Repository)).click();
        });
        step("Переходим в Ишью в " + Repository, () ->
        {
            $("#issues-tab").click();
        });

        step("Проверяем что есть ишью с таким номер" + NumberIssue, () ->
        {
            $(withText("#" + NumberIssue)).should(Condition.exist);
        });


    }


}
