package test;

import data.DataHelper;
import data.PostgresSqlDataHelper;
import data.SQLDataHelper;
import org.junit.jupiter.api.*;
import page.MainPage;
import page.PurchaseTicketPage;

import static com.codeborne.selenide.Selenide.open;

public class SQLPurchaseTest {

    @BeforeEach
    void setUpAll() {
        open("http://localhost:8080");
    }

  /*  @Test
        // Покупка по карте (sql)
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
        // Покупка в кредит по карте (sql)
        //проходит +
    void shouldCreditPurchasingTicketFromCard() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(validCardInformation);
        page.checkSuccessNotification();
        var expected = "APPROVED";
        var actual = SQLDataHelper.getTransactionCardStatusByCreditCard();
        Assertions.assertEquals(expected,actual);
    }

     */
   @Test
        // Покупка по карте (postgresql)
        //проходит +
    void shouldPurchasingTicketFromCard1() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByDebitCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(validCardInformation);
        page.checkSuccessNotification();
        var expected = "APPROVED";
        var actual = PostgresSqlDataHelper.getTransactionCardStatusByDebitCard();
        Assertions.assertEquals(expected,actual);
    }

    @Test
        // Покупка в кредит по карте (postgresql)
        //проходит +
    void shouldCreditPurchasingTicketFromCard1() {
        var mainPage = new MainPage();
        mainPage.purchaseBuyByCreditCard();
        var validCardInformation = DataHelper.getValidHolderInfo();
        PurchaseTicketPage page = new PurchaseTicketPage();
        page.purchase(validCardInformation);
        page.checkSuccessNotification();
        var expected = "APPROVED";
        var actual = PostgresSqlDataHelper.getTransactionCardStatusByCreditCard();
        Assertions.assertEquals(expected,actual);
    }



    @AfterAll
    public static void tearDown(){
        PostgresSqlDataHelper.clearSUT();
    }


/*
     @AfterAll
    public static void tearDown(){
        SQLDataHelper.clearSUT();
    }

 */



}
