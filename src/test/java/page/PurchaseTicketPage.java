package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class PurchaseTicketPage {
    private final SelenideElement CardNumberField = $("//input[@placeholder='0000 0000 0000 0000']");
    private final SelenideElement MonthField = $("//input[@placeholder='08']");
    private final SelenideElement YearField = $("//input[@placeholder='22']");
    private final SelenideElement CardHolderField = $("//span[contains(text(),'Владелец')]");
    private final SelenideElement CVCCodeField = $("//input[@placeholder='999']");
    private final SelenideElement PurchaseButton = $("//span[contains(text(),'Продолжить')]");


    public PurchaseTicketPage page (DataHelper.ValidHolderInfo info) {
        CardNumberField.setValue(info.getCardNumber());
        MonthField.setValue(info.getMonth());
        YearField.setValue(info.getYear());
        CardHolderField.setValue(info.getHolderName());
        CVCCodeField.setValue(info.getCVC());
        PurchaseButton.click();
        return new PurchaseTicketPage();
    }
}
