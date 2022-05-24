import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderPositiveTestHappyPath {

    @BeforeEach
    public void openPage() {
        open("http://localhost:9999/");
    }

    @Test
    public void shouldReturnValidValue() {
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Джон Мэйсон");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueOneWord() {
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Джон");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueNameHyphen() {
        $(".form-field_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Джон-Уилкс Бут");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}