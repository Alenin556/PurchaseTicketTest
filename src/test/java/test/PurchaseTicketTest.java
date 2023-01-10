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
    @Test // Покупка по карте
        //проходит +
    void shouldPurchasingTicketFromCard() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.Purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();

    }

    @Test // Покупка по кредитной карте
        //проходит +
    void shouldPurchasingTicketFromCreditCard() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByCreditCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.Purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();
    }

    @Test  // Покупка по заблокированной карте
        //не проходит (баг)-
    void shouldntPurchasingTicketFromCardWithWrongCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getDeclinedCardNumberHolderInfo();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkWrongNotification();

    }

    @Test //Валидация поля Имя (русскими буквами)
        // не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithRuName() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithRuName();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test //Валидация поля Имя (ввод в поле цифр)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNameWithNumber();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test//Валидация поля Имя (ввод в поле специальных символов)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithSymbol() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNameWithSymbol();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test//Валидация поля Имя (ввод в поле пропусков)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithFreeSpace() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoNameWithFreeSpace();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test//Валидация поля Имя (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyNameField() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoEmptyNameField();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }


    @Test //Валидация поля номер карты (ввод карты не из списка)
        //проходит +
    void shouldntPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithCardNumberNotAtList();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkWrongNotification();

    }

    @Test //проходит
    void shouldntPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongMonth();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkPeriodErrorMonthFieldNotification();
    }

    @Test //
    void shouldntPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongPastYear();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkEmptyErrorYearFieldNotification();

    }

    @Test
    void shouldntPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongFutureYear();
        PurchaseTicketPage.Purchase(invalidCardInformation);

    }



}
