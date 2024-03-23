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
        $("#userNumber").setValue("79111111"); //ввести номер телефона
        $("#dateOfBirthInput").click(); //клик в поле даты рождения
        $(".react-datepicker__month-select").click(); //клик в список выбора месяца
        $(byText("May")).click(); //выбор месяца
        $(".react-datepicker__year-select").click(); // клик в список выбора года
        $(byText("1997")).click(); //выбор года
        $(".react-datepicker__day--023").click(); //выбор дня
        $(".css-2b097c-container input").setValue("computer science").pressEnter(); //выбор предмета
        $("#hobbiesWrapper").$(byText("Music")).click(); //выбор чекбокса
        $("#uploadPicture").uploadFromClasspath("26.jpg");


    }

}
