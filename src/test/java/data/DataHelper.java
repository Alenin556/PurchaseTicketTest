package data;

import com.github.javafaker.Faker;

import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;



public class DataHelper {
    static Faker faker = new Faker();
    static String wrongMonth = "13";
    static String wrongPastYear = "15";
    static  String invalidYear = "2045";
    static String activeCard = "4444 4444 4444 4441";
    static String blockedCard = "4444 4444 4444 4442";
    static String shortCard = "4444";
    static String longCard = "4444 4444 4444 4441 1";

    static String longCVC = "1234";


    public static String generateValidMonth() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        var dateFormat = date.format(DateTimeFormatter.ISO_DATE);
        var month = dateFormat.substring(4);
        return month;
    }

    public static String generateInvalidMonthWithoutZero() {
        var random = faker.random().nextInt(1, 9);
        var month = String.valueOf(random);
        return month;
    }

    public static String generateValidYear() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        var dateFormat = date.format(DateTimeFormatter.ISO_DATE);
        var year = dateFormat.substring(2);
        return year;
        }


    public static String generateName(String locale) {
        var holderName = faker.name().fullName();
        return holderName;
    }


    public static String generateCardNumber(String locale) {
        var cardNumber = faker.finance().creditCard();
        return cardNumber;
    }

    public static String generateCVC() {
        var cvc = faker.number().digits(3);
        return cvc;
    }

    public static String generateShortCVC() {
        var cvc = faker.number().digits(1);
        return cvc;
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
        return new HolderInfo(generateName("ru"), activeCard, generateValidMonth(), invalidYear, generateCVC());
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
}
