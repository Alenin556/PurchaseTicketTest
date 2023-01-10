package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;


public class PurchaseTicketPage {
    private static final SelenideElement CardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private static final SelenideElement MonthField = $("input[placeholder='08']");
    private static final SelenideElement YearField = $("input[placeholder='22']");
    private static final SelenideElement CardHolderField = $(" div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private static final SelenideElement CVCCodeField = $("input[placeholder='999']");
    private static final SelenideElement PurchaseButton = $("div > form > fieldset > div:nth-child(4) > button");

    private static final SelenideElement SuccessNotification = $("div > div.notification.notification_visible.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white");

    private static final SelenideElement WrongNotification = $(" div > div.notification.notification_visible.notification_status_error.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__content");

    private static final SelenideElement CardFieldError = $("div > form > fieldset > div:nth-child(1) > span > span > span.input__sub");
    private static final SelenideElement MonthEmptyFieldError = $(" div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub");
    private static final SelenideElement MonthPeriodFieldError = $("  div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private static final SelenideElement YearOutPeriodFieldError = $(" div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private static final SelenideElement YearEmptyFieldError = $(" div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private static final SelenideElement HolderFieldError = $("div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub");
    private static final SelenideElement CVCFieldError = $(" div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub");


    public static void  Purchase(DataHelper.HolderInfo info) {
        CardNumberField.setValue(info.getCardNumber());
        MonthField.setValue(info.getMonth());
        YearField.setValue(info.getYear());
        CardHolderField.setValue(info.getHolderName());;
        CVCCodeField.setValue(info.getCVC());
        PurchaseButton.click();
    }

    public static void  checkSuccessNotification() {
        SuccessNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public static void  checkWrongNotification() {
        WrongNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public static void  checkErrorCardNumberFieldNotification() {
        CardFieldError.should(Condition.visible);
    }

    public static void  checkPeriodErrorMonthFieldNotification() {
        MonthPeriodFieldError.should(Condition.visible);
    }

    public static void  checkEmptyErrorMonthFieldNotification() {
        MonthEmptyFieldError.should(Condition.visible);
    }

    public static void  checkEmptyErrorYearFieldNotification() {
        YearEmptyFieldError.should(Condition.visible);
    }

    public static void  checkErrorHolderFieldNotification() {
        HolderFieldError.should(Condition.visible);
    }

    public static void  checkErrorCVCFieldNotification() {
        CVCFieldError.should(Condition.visible);
    }

}

