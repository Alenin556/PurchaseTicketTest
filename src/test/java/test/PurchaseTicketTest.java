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

    @Test //Валидация поля номер карты (ввод букв в поле)
    //проходит +
    void shouldntPurchasingTicketFromCardWithWordInCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordsInCardNumber();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorCardNumberFieldNotification();

    }


    //****************************** ПО ПЛАНУ ! ************************************

    @Test //Валидация поля номер карты (ввод карты не из списка)
        //проходит +
    void shouldntPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithCardNumberNotAtList();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorCardNumberFieldNotification();

    }

    @Test // Валидация поля месяц (ввод 33 меясца)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongMonth();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkMonthErrorFieldNotification();
    }

    @Test // Валидация поля месяц (оставить поле пустым)
        // проходит +
    void shouldntPurchasingTicketFromCardWithEmptyMonthField() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyMonthField();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkMonthErrorFieldNotification();
    }

    @Test // Валидация поля год (ввод в поле год который прошел)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongPastYear();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkYearErrorFieldNotification();
    }

    @Test// Валидация поля год (ввод в поле год который будет)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.PurchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongFutureYear();
        PurchaseTicketPage.Purchase(invalidCardInformation);
        PurchaseTicketPage.checkYearErrorFieldNotification();

    }



}
