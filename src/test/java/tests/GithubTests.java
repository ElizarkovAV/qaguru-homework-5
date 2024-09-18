package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openGithubEnterprisePageTest() {
        //arrange
        String expTitle = "The AI-powered\n" +
                "developer platform.";
        //act
        open("https://github.com/"); //открыть Github
        $(byTagAndText("button", "Solutions")).hover(); //навести курсор на Solutions
        $(byTagAndText("a", "Enterprise")).click(); //нажать на Enterprise
        // asserts
        $("#hero-section-brand-heading").shouldHave(text(expTitle)); //проверка отображения заголовка страницы
    }
}
