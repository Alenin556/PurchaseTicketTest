package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class PurchaseTicketPage {
    private static SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private static SelenideElement monthField = $("input[placeholder='08']");
    private static SelenideElement yearField = $("input[placeholder='22']");
    private static SelenideElement cardHolderField = $(" div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private static SelenideElement cvcCodeField = $("input[placeholder='999']");
    private static SelenideElement purchaseButton = $("div > form > fieldset > div:nth-child(4) > button");

    private static SelenideElement successNotification = $(".notification_status_ok");

    private static SelenideElement wrongNotification = $(" .notification_status_error");

    private static SelenideElement cardFieldError = $(" div:nth-child(1) > span > span > span.input__sub");
    //   private static final SelenideElement MonthEmptyFieldError = $(" div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub");
    private static SelenideElement monthPeriodFieldError = $(" div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private static SelenideElement yearPeriodFieldError = $(" div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    // private static final SelenideElement YearEmptyFieldError = $(" div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private static SelenideElement holderFieldError = $(" div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub");
    private static SelenideElement cvcFieldError = $("  div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub");


    public static void purchase(DataHelper.HolderInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getHolderName());
        cvcCodeField.setValue(info.getCvc());
        purchaseButton.click();
    }

    public static void checkSuccessNotification() {
        successNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public static void checkWrongNotification() {
        wrongNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public static void checkErrorCardNumberFieldNotification() {
        cardFieldError.should(Condition.visible);
    }

    public static void checkMonthErrorFieldNotification() {
        monthPeriodFieldError.should(Condition.visible);
    }

    public static void checkYearErrorFieldNotification() {
        yearPeriodFieldError.should(Condition.visible);
    }

  /*  public static void  checkEmptyErrorMonthFieldNotification() {
        MonthEmptyFieldError.should(Condition.visible);
    }
   */

  /*  public static void  checkEmptyErrorYearFieldNotification() {
        YearEmptyFieldError.should(Condition.visible);
    }

   */

    public static void checkErrorHolderFieldNotification() {
        holderFieldError.should(Condition.visible);
    }

    public static void checkErrorCVCFieldNotification() {
        cvcFieldError.should(Condition.visible);
    }

}

