package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class TheInternetHeroTests {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    //Тест с использованием actions() для drag and drop
    @Test
    void dragAndDropUseActionsTest() {
        //act
        open("/drag_and_drop"); //открыть страницу Drag and Drop
        //проверка, что в изначальном состоянии совпадает текст и локаторы у прямоугольников
        $("#column-a").shouldHave(text("A"));$("#column-b").shouldHave(text("B"));
        //перенос прямоугольника А на место В
        actions().dragAndDrop($("#column-a"), $("#column-b")).release().perform();

        //assert
        //проверить, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    //Тест с использованием команды selenide dragAndDrop
    @Test
    void dragAndDropUseSelenideTest() {
        //act
        open("/drag_and_drop"); //открыть страницу Drag and Drop
        //проверка, что в изначальном состоянии совпадает текст и локаторы у прямоугольников
        $("#column-a").shouldHave(text("A"));$("#column-b").shouldHave(text("B"));
        //перенос прямоугольника А на место В используя selenide
        $("#column-a").dragAndDrop(to($("#column-b")));

        //assert
        //проеврка, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
