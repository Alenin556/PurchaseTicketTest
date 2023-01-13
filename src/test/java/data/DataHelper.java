package data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class DataHelper {

    static String wrongMonth = "13";
    static String wrongPastYear = "15";
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

    public static String generateInvalidMonthWithoutZero() {
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 9);
        String invalidFormOfMonth = String.valueOf(random);
        String Month = invalidFormOfMonth;
        return Month;
    }

    public static String generateValidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentYear = date.getYear();
        int millennium = 2000;
        Faker faker = new Faker();
        int random = faker.random().nextInt(1, 6);
        int someYear = currentYear + random;
        int validFormOfMonth = millennium - someYear;
        String Year = String.valueOf(validFormOfMonth);
        return Year;
    }

    public static String generateInvalidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int currentYear = date.getYear();
        int millennium = 2000;
        Faker faker = new Faker();
        int random = faker.random().nextInt(8, 20);
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

    public static String generateLongCVC() {
        Faker faker = new Faker();
        String CVC = faker.number().digits(4);
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
        return new HolderInfo("ALENI$$ ADREY%%", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoWithSpaceInNameField() {
        return new HolderInfo("ALEN  IN AD   REY", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
    }

    public static HolderInfo getHolderInfoEmptyNameField() {
        return new HolderInfo("", activeCard, generateValidMonth(), generateValidYear(), generateCVC());
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
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(),"год", generateCVC());
    }

    public static HolderInfo getHolderInfoWithSymbolInYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(),"$$", generateCVC());
    }

    public static HolderInfo getHolderInfoWithZeroInYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(),"00", generateCVC());
    }

    public static HolderInfo getHolderInfoWithEmptyYearField() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(),"", generateCVC());
    }

    public static HolderInfo getHolderInfoWithShortCVC() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), generateShortCVC());
    }

    public static HolderInfo getHolderInfoWithLongCVC() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), generateValidYear(), generateLongCVC());
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

    public static HolderInfo getHolderInfoWithSpaceCVCField() {
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
