import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderNegativeTest {

    @BeforeEach
    public void openPage() {
        open("http://localhost:9999/");
    }

    @Test
    public void shouldShowErrorInvalidNameFieldEmpty() {
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldShowErrorInvalidNameField() {
        $("[data-test-id=name] input").setValue("John Mayson");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldShowErrorInvalidNumberTelephoneField() {
        $("[data-test-id=name] input").setValue("Джон Мэйсон");
        $("[data-test-id=phone] input").setValue("+780055535355");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldShowErrorInvalidNumberTelephoneFieldWithWord() {
        $("[data-test-id=name] input").setValue("Джон Мэйсон");
        $("[data-test-id=phone] input").setValue("Mayson");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldShowErrorInvalidNumberTelephoneFieldEmpty() {
        $("[data-test-id=name] input").setValue("Джон Мэйсон");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldShowErrorInvalidTermsAgreement() {
        $("[data-test-id=name] input").setValue("Джон Мэйсон");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[type=button]").click();
        $(".input_invalid .checkbox__text").shouldHave(Condition.exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    public void shouldShowErrorInvalidValueFieldsEmpty() {
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
}