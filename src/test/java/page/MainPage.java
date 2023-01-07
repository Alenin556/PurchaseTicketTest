package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    private final SelenideElement heading = $(".heading");
    private final SelenideElement BuyButton = $("//span[contains(text(),'Купить')]");


    public PurchaseTicketPage page() {
        heading.shouldBe(visible);
        BuyButton.click();
        return new PurchaseTicketPage();
    }
}
