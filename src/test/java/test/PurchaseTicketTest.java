package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseTicketPage;
import static com.codeborne.selenide.Selenide.open;

public class PurchaseTicketTest {

    @Test
    void shouldPurchasingTicketFromCard() {
        open("http://localhost:8080");
        var mainPage = new MainPage();
        var purchasingPage = new PurchaseTicketPage();
    }

}
