package test;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseTicketPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PurchaseTicketTest {

    @BeforeEach
     void setUpAll(){
        open("http://localhost:8080");
    }
    @Test
    void shouldPurchasingTicketFromCard() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var purchasePage = new PurchaseTicketPage();
    }

    @Test
    void shouldPurchasingTicketFromCreditCard() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByCreditCard();
        var purchasePage = new PurchaseTicketPage();
    }
}
