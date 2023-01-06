import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Github extends TestBase{

    @Test
    void githubSolutionsTest() {
        step("Open Main Page", () -> {
            open("https://github.com/");
        });
        step("Open header menu item", () -> {
            $$(".HeaderMenu-link").filterBy(text("Solution")).first().hover();
        });
        step("Open '{page}' link from header open menu", () -> {
            $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
            $(".application-main").shouldHave(text("Build like the best"));
        });
    }

    @Test
    public void dragAndDropTest() {
        step("Open Main Page", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Drag and Drop", () -> {
            $("#column-a").dragAndDropTo($("#column-b"));
            $("#column-a").shouldHave(text("B"));
        });
    }
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
