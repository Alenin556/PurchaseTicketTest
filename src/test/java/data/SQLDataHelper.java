package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class SQLDataHelper {
    @SneakyThrows
    public static String getTransactionCardStatusByDebitCard() {
        var runner = new QueryRunner();
        var codeSQL = "SELECT status from payment_entity order by created DESC LIMIT 1;";

        var urlValue = System.getProperty("db.url");
        var loginValue = System.getProperty("login");
        var passwordValue = System.getProperty("password");

        var conn = DriverManager.getConnection(urlValue, loginValue, passwordValue);

            return runner.query(conn, codeSQL, new ScalarHandler<>());
    }
    @SneakyThrows
    public static String getTransactionCardStatusByDebitCard1() {
        var runner = new QueryRunner();
        var codeSQL = "SELECT status from payment_entity order by created DESC LIMIT 1;";

        var urlValue = System.getProperty("db.url");
        var loginValue = System.getProperty("login");
        var passwordValue = System.getProperty("password");

        var conn = DriverManager.getConnection(urlValue, loginValue, passwordValue);

        return runner.query(conn, codeSQL, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getTransactionCardStatusByCreditCard() {
        var runner = new QueryRunner();

        var codeSQL = "SELECT status from credit_request_entity order by created DESC LIMIT 1;";

        var urlValue = System.getProperty("db.url");
        var loginValue = System.getProperty("login");
        var passwordValue = System.getProperty("password");

        var conn = DriverManager.getConnection(urlValue, loginValue, passwordValue);

            return runner.query(conn, codeSQL, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getTransactionCardStatusByCreditCard1() {
        var runner = new QueryRunner();

        var codeSQL = "SELECT status from credit_request_entity order by created DESC LIMIT 1;";

        var urlValue = System.getProperty("db.url");
        var loginValue = System.getProperty("login");
        var passwordValue = System.getProperty("password");

        var conn = DriverManager.getConnection(urlValue, loginValue, passwordValue);

        return runner.query(conn, codeSQL, new ScalarHandler<>());
    }

    @SneakyThrows
    public static void clearSUT() {
        var runner = new QueryRunner();
        var deleteCreditPaymentInfoTableSQL = "DELETE FROM credit_request_entity ;";
        var deleteOrderInfoTableSQL = "DELETE FROM order_entity ;";
        var deleteDebitPaymentInfoTableSQL1 = "DELETE FROM payment_entity ;";

        var urlValue = System.getProperty("db.url");
        var loginValue = System.getProperty("login");
        var passwordValue = System.getProperty("password");

        var conn = DriverManager.getConnection(urlValue, loginValue, passwordValue);

            var deleteCodes = runner.update(conn, deleteCreditPaymentInfoTableSQL);
            var deleteCardsInfo = runner.update(conn, deleteOrderInfoTableSQL);
            var deleteUsers1 = runner.update(conn, deleteDebitPaymentInfoTableSQL1);
    }
}
