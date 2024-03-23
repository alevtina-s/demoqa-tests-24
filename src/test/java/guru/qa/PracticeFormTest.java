package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy ="eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;

    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alevtina"); //ввести имя
        $("#lastName").setValue("Sergienko"); //ввести фамилию
        $("#userEmail").setValue("Alina230597@mail.ru"); //ввести email
        $("#genterWrapper").$(byText("Female")).click(); //выбрать радиобаттон гендера
        $("#userNumber").setValue("7911111111"); //ввести номер телефона
        $("#dateOfBirthInput").click(); //клик в поле даты рождения
        $(".react-datepicker__month-select").click(); //клик в список выбора месяца
        $(byText("May")).click(); //выбор месяца
        $(".react-datepicker__year-select").click(); // клик в список выбора года
        $(byText("1997")).click(); //выбор года
        $(".react-datepicker__day--023").click(); //выбор дня
        $(".css-2b097c-container input").setValue("computer science").pressEnter(); //выбор предмета
        $("#hobbiesWrapper").$(byText("Music")).click(); //выбор чекбокса
        $("#uploadPicture").uploadFromClasspath("26.jpg"); //загрузка картинки
        $("#currentAddress-wrapper").$("#currentAddress").setValue("Moscow, Pushkin street, Kolotushkin house"); //ввод адреса
        $("#state").click(); //клик в поле ввода штата
        $(byText("NCR")).click(); //выбор штата
        $("#city").click(); //клик в поле ввода города
        $(byText("Delhi")).click(); //выбор города
        $("#submit").click(); //клик на кнопку подтверждения

        //проверки
        $(".modal-body").shouldHave(text("Alevtina Sergienko"));
        $(".modal-body").shouldHave(text("Alina230597@mail.ru"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("23 May,1997"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("26.jpg"));
        $(".modal-body").shouldHave(text("Moscow, Pushkin street, Kolotushkin house"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }

}
