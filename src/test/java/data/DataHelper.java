package data;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DataHelper {

    public static ValidHolderInfo getValidHolderInfo() {
        return new ValidHolderInfo("ANDREY ALENIN", "4444 4444 4444 4441", "12", "23", "143");
    }

    public static InvalidHolderInfo getInvalidHolderInfo() {
        return new InvalidHolderInfo("ANDREY ALENIN", "4444 4444 4444 4442", "12", "23", "143");
    }


    @Value
    public static class ValidHolderInfo {
        private String HolderName;
        private String cardNumber;
        private String month;
        private String year;
        private String CVC;
    }

    @Value
    public static class InvalidHolderInfo {
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
