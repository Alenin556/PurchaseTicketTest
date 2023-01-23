package test;

import data.DataHelper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseTicketPage;

import static com.codeborne.selenide.Selenide.open;

public class CreditPurchaseTicketTest {

    @BeforeEach
    void setUpAll() {
        open("http://localhost:8080");
    }

    @Test
        // Покупка в кредит по заблокированной карте
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithWrongCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getDeclinedCardNumberHolderInfo();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();

    }

    @Test
        // Покупка в кредит по карте не из списка
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithCardNumberNotAtList();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();
    }

    //       Имя

    @Test
        //Валидация поля Имя (ввод имени на русском)
        // не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithRuWordInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithRuNameInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод цифр)
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithNumberInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNumberInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод специальных символов)
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithSymbolInNameFiedld() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод пропусков)
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithFreeSpaceInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }


    @Test
        //Валидация поля Имя (оставить поле пустым)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithEmptyNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoEmptyNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    //        Номер карты

    @Test
        //Валидация поля номер карты (ввод короткого номера)
        // проходит +
    void shouldntCreditPurchasingTicketFromCardWithShortCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithShortCardNumber();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
    void shouldntPurchasingTicketFromCardWithLongCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithLongCardNumber();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        var actual =page.getCardFieldValue();
        var expected = "4444 4444 4444 4441";
        Assertions.assertEquals(expected,actual);

    }
    @Test
        //Валидация поля номер карты (ввод букв)
        // проходит +
    void shouldntCreditPurchasingTicketFromCardWithWordInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты ( ввод символов )
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSymbolInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты (ввод нулей)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithZeroInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();

    }

    @Test
        //Валидация поля номер карты (ввод пропусков)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithFreeSpaceInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты (оставить поле пустым)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithEmptyCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    //         Месяц

    @Test
        // Валидация поля месяц (ввод месяца без 0)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithMonthWithoutZero() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithMonthWithoutZero();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод 13 меcяца)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongMonth();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод букв)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithWordInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод символов)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSymbolInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод нулей)
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithZerolInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (оставить поле пустым)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithEmptyMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    //         Год

    @Test
        // Валидация поля год (ввод в поле года прошедшего)
        // проходит +
    void shouldntCreditPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongPastYear();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод года превышающего срок годности)
        // проходит +
    void shouldntCreditPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithInvalidYear();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();

    }

    @Test
        // Валидация поля год (ввод букв)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithWordInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод символов)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSymbolInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод нулей)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithZeroInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (оставить поле пустым)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithEmptyYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    //         CVC

    @Test
        // Валидация поля CVC (ввод 1 символа)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithShortCVC() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithShortCVC();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод 4 символов)
        //проходит +
    void mbolshouldntPurchasingTicketFromCardWithLongCVC() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithLongCVC();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        var actual =page.getCVCFieldValue();
        var expected = "123";
        Assertions.assertEquals(expected,actual);
    }

    @Test
        // Валидация поля CVC (ввод букв)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithWordInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод символов)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSymbolInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод нулей)
        //не проходит (баг *оформлен*)
    void shouldntCreditPurchasingTicketFromCardWithZeroInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод пробелов)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithSpaceCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (оставить поле пустым)
        //проходит +
    void shouldntCreditPurchasingTicketFromCardWithEmptyCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

}
