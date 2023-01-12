package test;


import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseTicketPage;

import static com.codeborne.selenide.Selenide.open;

public class PurchaseTicketTest {

    @BeforeEach
    void setUpAll() {
        open("http://localhost:8080");
    }

    @Test
        // Покупка по карте
        //проходит +
    void shouldPurchasingTicketFromCard() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();

    }

    @Test
        // Покупка по кредитной карте
        //проходит +
    void shouldPurchasingTicketFromCreditCard() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage.purchase(validCardInformation);
        PurchaseTicketPage.checkSuccessNotification();
    }

    @Test
        // Покупка по заблокированной карте
        //не проходит (баг)-
    void shouldntPurchasingTicketFromCardWithWrongCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getDeclinedCardNumberHolderInfo();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkWrongNotification();

    }

    @Test
        //Валидация поля Имя (русскими буквами)
        // не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithRuName() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithRuName();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод в поле цифр)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNameWithNumber();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test
//Валидация поля Имя (ввод в поле специальных символов)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithSymbol() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNameWithSymbol();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test
//Валидация поля Имя (ввод в поле пропусков)
        //не проходит (баг) -
    void shouldntPurchasingTicketFromCardWithNameWithFreeSpace() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoNameWithFreeSpace();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test
//Валидация поля Имя (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoEmptyNameField();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля номер карты (ввод букв в поле)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWordInCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordsInCardNumber();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorCardNumberFieldNotification();

    }


    //****************************** ПО ПЛАНУ ! ************************************

    @Test
        //Валидация поля номер карты (ввод карты не из списка)
        //проходит +
    void shouldntPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithCardNumberNotAtList();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkErrorCardNumberFieldNotification();

    }

    @Test
        // Валидация поля месяц (ввод 33 меясца)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongMonth();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (оставить поле пустым)
        // проходит +
    void shouldntPurchasingTicketFromCardWithEmptyMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyMonthField();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод в поле год который прошел)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongPastYear();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkYearErrorFieldNotification();
    }

    @Test
// Валидация поля год (ввод в поле год который будет)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongFutureYear();
        PurchaseTicketPage.purchase(invalidCardInformation);
        PurchaseTicketPage.checkYearErrorFieldNotification();

    }


}
