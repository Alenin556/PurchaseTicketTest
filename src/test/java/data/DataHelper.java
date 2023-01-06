package data;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DataHelper {

    public static HolderInfo getValidHolderInfo() {
        return new HolderInfo("ANDREY", "ALENIN");
    }

    public static TransferCard getValidCardInfo() {

        return new TransferCard("4444 4444 4444 4441");
    }

    public static TransferCard getInvalidCardInfo() {

        return new TransferCard("4444 4444 4444 4442");
    }

    public static ValidPeriod getValidPeriodInfo() {
        return new ValidPeriod("12.26");
    }

    public static CVCCode getValidCVCInfo() {
        return new CVCCode("143");
    }

    @Value
    public static class HolderInfo {
        private String FirstName;
        private String LastName;
    }
    @Value
    public static class TransferCard {
        private String cardNumber;
    }
    @Value
    public static class ValidPeriod {
        private String period;
    }
    @Value
    public static class CVCCode {
        private String CVC;
    }



    SneakyThrows
    public static String getTransferCard() {
        var runner = new QueryRunner();
        var codeSQL = "SELECT card from  ???  order by created DESC LIMIT 1";
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "user", "pass");
        ) {
            return runner.query(conn, codeSQL, new ScalarHandler<>());
        }
    }


}
