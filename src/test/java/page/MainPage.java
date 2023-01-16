package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement buttonBuyByDebit = $(byText("Купить"));
    private final SelenideElement buttonBuyByCredit = $(byText("Купить в кредит"));

    private final SelenideElement purchaseByDebitHeader = $(withText("Оплата по карте"));
    private final SelenideElement purchaseByCreditHeader = $(withText("Кредит по данным карты"));



    public PurchaseTicketPage purchaseBuyByDebitCard() {
        buttonBuyByDebit.click();
        purchaseByDebitHeader.shouldBe(Condition.visible);
        return new PurchaseTicketPage();
    }

    public PurchaseTicketPage purchaseBuyByCreditCard() {
        buttonBuyByCredit.click();
        purchaseByCreditHeader.shouldBe(Condition.visible);
        return new PurchaseTicketPage();
    }

}
