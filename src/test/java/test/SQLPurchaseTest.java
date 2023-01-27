package test;

import data.DataHelper;
import data.SQLDataHelper;
import org.junit.jupiter.api.*;
import page.MainPage;
import page.PurchaseTicketPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class SQLPurchaseTest {

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
        Assertions.assertEquals(expected, actual);
    }

    @Test
        // Покупка в кредит по карте
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
        Assertions.assertEquals(expected, actual);
    }


    @AfterAll
    public static void tearDown() throws SQLException {
        SQLDataHelper.clearSUT();
    }
}
