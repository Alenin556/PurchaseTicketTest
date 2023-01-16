package data;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class DataHelper {

    static String wrongMonth = "13";
    static String wrongPastYear = "15";
    static String activeCard = "4444 4444 4444 4441";
    static String blockedCard = "4444 4444 4444 4442";
    static String shortCard = "4444";
    static String longCard = "4444 4444 4444 4444 1";

    static String longCVC = "1234";


    public static String generateValidMonth() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentMonth = date.getMonthValue();
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 11);
        int someMonth = currentMonth + random;
        String validFormOfMonth = "0" + someMonth;
        String Month = validFormOfMonth;
        return Month;
    }

    public static String generateInvalidMonthWithoutZero() {
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 9);
        String Month = String.valueOf(random);
        return Month;
    }

    public static String generateValidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentYear = date.getYear();
        int millennium = 2000;
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 5);
        int someYear = currentYear + random;
        int validFormOfYear = millennium - someYear;
        String Year = String.valueOf(validFormOfYear);
        return Year;
    }

    public static String generateInvalidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentYear = date.getYear();
        int millennium = 2000;
        Faker faker = new Faker();
        int random = faker.random().nextInt(8, 20);
        int someYear = currentYear + random;
        int invalidFormOfYear = millennium - someYear;
        String Year = String.valueOf(invalidFormOfYear);
        return Year;
    }


    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String HolderName = faker.name().fullName();
        return HolderName;
    }


    public static String generateCardNumber(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String CardNumber = faker.finance().creditCard();
        return CardNumber;
    }

    public static String generateCVC() {
        Faker faker = new Faker();
        String CVC = faker.number().digits(3);
        return CVC;
    }

    public static String generateShortCVC() {
        Faker faker = new Faker();
        String CVC = faker.number().digits(1);
        return CVC;
    }

    public static HolderInfo getValidHolderInfo() {
        return new HolderInfo(generateName("eng"), activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getDeclinedCardNumberHolderInfo() {
        return new HolderInfo(generateName("eng"), blockedCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithRuNameInNameField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithNumberInNameField() {
        return new HolderInfo("ALENIN ADREY1", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSymbolInNameField() {
        return new HolderInfo("ALENI$$ ANDREY%%", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSpaceInNameField() {
        return new HolderInfo("ALEN  IN AD   REY", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoEmptyNameField() {
        return new HolderInfo("", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithShortCardNumber() {
        return new HolderInfo(generateName("ru"), shortCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithLongCardNumber() {
        return new HolderInfo(generateName("ru"), longCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithWordInCardNumberField() {
        return new HolderInfo(generateName("ru"), "CARD NUMBER", generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSymbolInCardNumberField() {
        return new HolderInfo(generateName("ru"), "%%%% **** 4444 4441", generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithZeroInCardNumberField() {
        return new HolderInfo(generateName("ru"), " 0000 0000 0000 0000", generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSpaceInCardNumberField() {
        return new HolderInfo(generateName("ru"), " 444 4  44 4 441", generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithEmptyCardNumberField() {
        return new HolderInfo(generateName("ru"), "", generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithCardNumberNotAtList() {
        return new HolderInfo(generateName("ru"), generateCardNumber("visa"), generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithMonthWithoutZero() {
        return new HolderInfo(generateName("ru"), activeCard, generateInvalidMonthWithoutZero(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithWrongMonth() {
        return new HolderInfo(generateName("ru"), activeCard, wrongMonth, generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithWordInMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, "месяц", generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSymbolInMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, "%$", generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithZeroInMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, "00", generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithEmptyMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, " ", generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithInvalidYear() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateInvalidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithWrongPastYear() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), wrongPastYear, generateCVC());
    }

    public static HolderInfo getHolderInfoWithWordInYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), "год", generateCVC());
    }

    public static HolderInfo getHolderInfoWithSymbolInYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), "$$", generateCVC());
    }

    public static HolderInfo getHolderInfoWithZeroInYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), "00", generateCVC());
    }

    public static HolderInfo getHolderInfoWithEmptyYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), "", generateCVC());
    }

    public static HolderInfo getHolderInfoWithShortCVC() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), generateShortCVC());
    }

    public static HolderInfo getHolderInfoWithLongCVC() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), longCVC);
    }

    public static HolderInfo getHolderInfoWithWordInCVCField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), "цвц");
    }

    public static HolderInfo getHolderInfoWithSymbolInCVCField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), "***");
    }

    public static HolderInfo getHolderInfoWithZeroInCVCField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), "000");
    }

    public static HolderInfo getHolderInfoWithSpaceInCVCField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), "   ");
    }

    public static HolderInfo getHolderInfoWithEmptyCVCField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), "");
    }


    //контейнер для данных
    @Value
    public static class HolderInfo {
        private String holderName;
        private String cardNumber;
        private String month;
        private String year;
        private String cvc;
    }


    @SneakyThrows
    public static String getTransactionCardStatusByDebitCard() {
        var runner = new QueryRunner();
        var codeSQL = "SELECT status from payment_entity where amount = 4500000;";
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            return runner.query(conn, codeSQL, new ScalarHandler<>());
        }

    }

    @SneakyThrows
    public static String getTransactionCardStatusByCreditCard() {
        var runner = new QueryRunner();

        var codeSQL = "SELECT status from credit_request_entity where amount = 4500000;";
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            return runner.query(conn, codeSQL, new ScalarHandler<>());
        }

    }

    @SneakyThrows
    public static void clearSUT() {
        var runner = new QueryRunner();
        var deleteCreditPaymentInfoTableSQL = "DELETE FROM credit_request_entity ;";
        var deleteOrderInfoTableSQL = "DELETE FROM order_entity ;";
        var deleteDebitPaymentInfoTableSQL1 = "DELETE FROM payment_entity ;";

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        ) {
            var deleteCodes = runner.update(conn, deleteCreditPaymentInfoTableSQL);
            var deleteCardsInfo = runner.update(conn, deleteOrderInfoTableSQL);
            var deleteUsers1 = runner.update(conn, deleteDebitPaymentInfoTableSQL1);
        }
    }
}
