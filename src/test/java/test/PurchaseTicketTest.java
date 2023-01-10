package test;


import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseTicketPage;

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
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.Purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();

    }

    @Test //проходит
    void shouldPurchasingTicketFromCreditCard() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByCreditCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.Purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();
    }

    @Test //не проходит (баг)
    void shouldntPurchasingTicketFromCardWithWrongCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidCardNumberHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkWrongNotification();

    }

    @Test // не проходит (баг)
    void shouldntPurchasingTicketFromCardWithRuName() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithRuNameHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test //не проходит (баг)
    void shouldntPurchasingTicketFromCardWithNameWithNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithNameWithNumber();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test //проходит
    void shouldntPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithSomeCardNumberHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkWrongNotification();

    }

    @Test //проходит
    void shouldntPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithWrongMonthHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkPeriodErrorMonthFieldNotification();
    }

    @Test //
    void shouldntPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithWrongPastYearHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkEmptyErrorYearFieldNotification();

    }

    @Test
    void shouldntPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getInvalidWithWrongFutureYearHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);

    }



}
