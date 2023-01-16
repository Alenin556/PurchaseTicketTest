package test;


import data.DataHelper;
import data.SQLDataHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(validCardInformation);
        page.checkSuccessNotification();
        var expected = "APPROVED";
        var actual = SQLDataHelper.getTransactionCardStatusByDebitCard();
        Assertions.assertEquals(expected,actual);
    }

    @Test
        // Покупка по заблокированной карте
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithWrongCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getDeclinedCardNumberHolderInfo();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();

    }

    @Test
        // Покупка по карте не из списка
        //проходит +
    void shouldntPurchasingTicketFromCardWithSomeCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithCardNumberNotAtList();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();

    }

    //       Имя

    @Test
        //Валидация поля Имя (ввод имени на русском)
        // не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithRuWordInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithRuNameInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод цифр)
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithNumberInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithNumberInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод специальных символов)
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithSymbolInNameFiedld() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (ввод пропусков)
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithFreeSpaceInNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    @Test
        //Валидация поля Имя (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyNameField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoEmptyNameField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorHolderFieldNotification();

    }

    //        Номер карты

    @Test
        //Валидация поля номер карты (ввод короткого номера)
        // проходит +
    void shouldntPurchasingTicketFromCardWithShortCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithShortCardNumber();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты (ввод 17ти значного номера)
        // проходит +
    void shouldntPurchasingTicketFromCardWithLongCardNumber() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithLongCardNumber();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkSuccessNotification(); //прописать проверку на количество

    }

    @Test
        //Валидация поля номер карты (ввод букв)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWordInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты ( ввод символов )
        //проходит +
    void shouldntPurchasingTicketFromCardWithSymbolInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты (ввод нулей)
        //проходит +
    void shouldntPurchasingTicketFromCardWithZeroInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkWrongNotification();

    }

    @Test
        //Валидация поля номер карты (ввод пропусков)
        //проходит +
    void shouldntPurchasingTicketFromCardWithFreeSpaceInCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    @Test
        //Валидация поля номер карты (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyCardNumberField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyCardNumberField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCardNumberFieldNotification();

    }

    //         Месяц

    @Test
        // Валидация поля месяц (ввод месяца без 0)
        //проходит +
    void shouldntPurchasingTicketFromCardWithMonthWithoutZero() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithMonthWithoutZero();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод 13 меcяца)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWrongMonth() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongMonth();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод букв)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWordInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод символов)
        //проходит +
    void shouldntPurchasingTicketFromCardWithSymbolInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (ввод нулей)
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithZerolInMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    @Test
        // Валидация поля месяц (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyMonthField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyMonthField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkMonthErrorFieldNotification();
    }

    //         Год

    @Test
        // Валидация поля год (ввод в поле года прошедшего)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongPastYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWrongPastYear();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод года превышающего срок годности)
        // проходит +
    void shouldntPurchasingTicketFromCardWithWrongFutureYear() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithInvalidYear();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();

    }

    @Test
        // Валидация поля год (ввод букв)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWordInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод символов)
        //проходит +
    void mbolshouldntPurchasingTicketFromCardWithSymbolInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (ввод нулей)
        //проходит +
    void shouldntPurchasingTicketFromCardWithZeroInYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    @Test
        // Валидация поля год (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyYearField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyYearField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkYearErrorFieldNotification();
    }

    //         CVC

    @Test
        // Валидация поля CVC (ввод 1 символа)
        //проходит +
    void shouldntPurchasingTicketFromCardWithShortCVC() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
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
        page.checkSuccessNotification();
    }

    @Test
        // Валидация поля CVC (ввод букв)
        //проходит +
    void shouldntPurchasingTicketFromCardWithWordInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithWordInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод символов)
        //проходит +
    void mbolshouldntPurchasingTicketFromCardWithSymbolInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSymbolInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод нулей)
        //не проходит (баг *оформлен*)
    void shouldntPurchasingTicketFromCardWithZeroInCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithZeroInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @Test
        // Валидация поля CVC (ввод пробелов)
        //проходит +
    void shouldntPurchasingTicketFromCardWithSpaceCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithSpaceInCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();

    }

    @Test
        // Валидация поля CVC (оставить поле пустым)
        //проходит +
    void shouldntPurchasingTicketFromCardWithEmptyCVCField() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var invalidCardInformation = DataHelper.getHolderInfoWithEmptyCVCField();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(invalidCardInformation);
        page.checkErrorCVCFieldNotification();
    }

    @AfterAll
    public static void tearDown(){
        SQLDataHelper.clearSUT();
    }
}
