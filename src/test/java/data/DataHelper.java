package data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class DataHelper {

    static String wrongMonth = "33";
    static String wrongPastYear = "15";
    static String wrongFutureYear = "55";
    static String activeCard = "4444 4444 4444 4441";
    static String blockedCard = "4444 4444 4444 4442";


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

    public static String generateValidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentYear = date.getYear();
        int millennium = 2000;
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 7);
        int someYear = currentYear + random;
        int validFormOfMonth = millennium - someYear;
        String Year = String.valueOf(validFormOfMonth);
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

    public static String generateCVC(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String CVC = faker.number().digits(3);
        return CVC;
    }

    public static HolderInfo getValidHolderInfo() {
        return new HolderInfo(generateName("eng"), activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getDeclinedCardNumberHolderInfo() {
        return new HolderInfo(generateName("eng"), blockedCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithRuName() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithNameWithNumber() {
        return new HolderInfo("ALENIN ADREY1", activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithNameWithSymbol() {
        return new HolderInfo("ALENI$$ ADREY%%", activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoNameWithFreeSpace() {
        return new HolderInfo("ALEN  IN AD   REY", activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoEmptyNameField() {
        return new HolderInfo("", activeCard, generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWordsInCardNumber() {
        return new HolderInfo(generateName("ru"), "CARD NUMBER", generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithCardNumberNotAtList() {
        return new HolderInfo(generateName("ru"), generateCardNumber("visa"), generateValidMonth(), generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongMonth() {
        return new HolderInfo(generateName("ru"), activeCard, wrongMonth, generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithEmptyMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, " ", generateValidYear(), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongPastYear() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), wrongPastYear, generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongFutureYear() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), wrongFutureYear, generateCVC("3"));
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


    //SneakyThrows
    // public static String getTransferCard() {
    //   var runner = new QueryRunner();
    // var codeSQL = "SELECT card from  ???  order by created DESC LIMIT 1";
    //try (
    //            var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "user", "pass");
    //  ) {
    //     return runner.query(conn, codeSQL, new ScalarHandler<>());
    //  }
    // }
    //


}
