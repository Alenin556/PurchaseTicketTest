package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainPage {


   // private final SelenideElement heading = $(".heading");
    private final SelenideElement buttonBuyByDebit = $(byText("Купить"));
    private final SelenideElement buttonBuyByCredit = $(byText("Купить в кредит"));

    private final SelenideElement PurchaseByDebitHeader = $(withText("Оплата по карте"));
    private final SelenideElement PurchaseByCreditHeader = $(withText("Кредит по данным карты"));



    public MainPage PurchaseBuyByDebitCard() {
        buttonBuyByDebit.click();
        PurchaseByDebitHeader.shouldBe(Condition.visible);
        return new MainPage();
    }

    public MainPage PurchaseBuyByCreditCard() {
        buttonBuyByCredit.click();
        PurchaseByCreditHeader.shouldBe(Condition.visible);
        return new MainPage();
    }

}
