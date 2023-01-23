package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class PurchaseTicketPage {
    private final SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("input[placeholder='08']");
    private final SelenideElement yearField = $("input[placeholder='22']");
    private final SelenideElement cardHolderField = $(" div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private final SelenideElement cvcCodeField = $("input[placeholder='999']");
    private final SelenideElement purchaseButton = $("div > form > fieldset > div:nth-child(4) > button");

    private final SelenideElement successNotification = $(".notification_status_ok");

    private final SelenideElement wrongNotification = $(" .notification_status_error");

    private final SelenideElement cardFieldError = $("div:nth-child(1) > span > span > span.input__sub");
    private final SelenideElement monthPeriodFieldError = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private final SelenideElement yearPeriodFieldError = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private final SelenideElement holderFieldError = $("div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub");
    private final SelenideElement cvcFieldError = $("div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub");


    public void purchase(DataHelper.HolderInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getHolderName());
        cvcCodeField.setValue(info.getCvc());
        purchaseButton.click();
    }

    public void checkSuccessNotification() {
        successNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void checkWrongNotification() {
        wrongNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void checkErrorCardNumberFieldNotification() {
        cardFieldError.should(Condition.visible);
    }

    public void checkMonthErrorFieldNotification() {
        monthPeriodFieldError.should(Condition.visible);
    }

    public void checkYearErrorFieldNotification() {
        yearPeriodFieldError.should(Condition.visible);
    }

    public void checkErrorHolderFieldNotification() {
        holderFieldError.should(Condition.visible);
    }

    public void checkErrorCVCFieldNotification() {
        cvcFieldError.should(Condition.visible);
    }

    public String getCardFieldValue() {
        var value = cardNumberField.getValue();
        return value;
    }

    public String getCVCFieldValue() {
        var value = cvcCodeField.getValue();
        return value;
    }

}

