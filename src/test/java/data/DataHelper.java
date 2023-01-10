package data;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.time.Year;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    static String wrongMonth = "33";
     static String wrongPastYear = "15";
     static String wrongFutureYear = "55";
     static String activeCard = "4444 4444 4444 4441";
     static String blockedCard = "4444 4444 4444 4442";


    public static String generateValidMonth(String locale) {
        Faker faker = new Faker (new Locale(locale));
        String Month = "0" + String.valueOf(faker.random().nextInt(1,9));
        return Month;
    }
    public static String generateValidYear(String locale) {
        Faker faker = new Faker (new Locale(locale));
        String Year = "2" + String.valueOf(String.valueOf(faker.random().nextInt(3,8)));
        return Year;
    }


    public static String generateName(String locale) {
        Faker faker = new Faker (new Locale(locale));
        String HolderName = faker.name().fullName();
        return HolderName;
    }


    public static String generateCardNumber(String locale) {
        Faker faker = new Faker (new Locale(locale));
        String CardNumber = faker.finance().creditCard();
        return CardNumber;
    }

    public static String generateCVC(String locale) {
        Faker faker = new Faker (new Locale(locale));
        String CVC = faker.number().digits(3);
        return CVC;
    }

    public static HolderInfo getValidHolderInfo() {
        return new HolderInfo(generateName("eng"), activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getDeclinedCardNumberHolderInfo() {
        return new HolderInfo(generateName("eng"), blockedCard,generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }
    public static HolderInfo getHolderInfoWithRuName() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithNameWithNumber() {
        return new HolderInfo("ALENIN ADREY1", activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithNameWithSymbol() {
        return new HolderInfo("ALENI$$ ADREY%%", activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoNameWithFreeSpace() {
        return new HolderInfo("ALEN  IN AD   REY", activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoEmptyNameField() {
        return new HolderInfo("", activeCard, generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWordsInCardNumber() {
        return new HolderInfo(generateName("ru"), "CARD NUMBER", generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithCardNumberNotAtList() {
        return new HolderInfo(generateName("ru"), generateCardNumber("visa"), generateValidMonth("2"), generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongMonth() {
        return new HolderInfo(generateName("ru"), activeCard, wrongMonth, generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithEmptyMonthField() {
        return new HolderInfo(generateName("ru"), activeCard, " ", generateValidYear("2"), generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongPastYear() {
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth("2"), wrongPastYear, generateCVC("3"));
    }

    public static HolderInfo getHolderInfoWithWrongFutureYear() {
        return new HolderInfo(generateName("ru"),activeCard , generateValidMonth("2"), wrongFutureYear, generateCVC("3"));
    }




    //контейнер для данных
    @Value
    public static class HolderInfo {
        private String HolderName;
        private String cardNumber;
        private String month;
        private String year;
        private String CVC;
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
