package test;

import org.junit.jupiter.api.Test;
import page.PurchaseTicketPage;
import page.WelcomePage;

import static com.codeborne.selenide.Selenide.open;

public class PurchaseTicketTest {
    @Test
    void shouldPurchasingTicketFromCard() {
        open("http://localhost:8080");
        var welcomePage = new WelcomePage();
        var purchasingPage = new PurchaseTicketPage();
    }

}
