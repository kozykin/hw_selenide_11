import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Github extends TestBase{

    @Test
    void githubTest() {
        step("Open Selenide Page", () -> {
            open("https://github.com/selenide/selenide");
        });
        step("Open Wiki section", () -> {
            $("#wiki-tab").click();
        });
        step("Check page SoftAssertions", () -> {
            $(".js-wiki-more-pages-link").click();
            $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Check JUnit5 code", () -> {
            $("#wiki-pages-box").$(byText("SoftAssertions")).click();
            $(".markdown-body").shouldHave(text("Using JUnit5"));
        });
    }
}
