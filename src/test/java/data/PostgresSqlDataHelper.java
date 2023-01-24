package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class PostgresSqlDataHelper {
    @SneakyThrows
    public static String getTransactionCardStatusByDebitCard() {
        var runner = new QueryRunner();
        var codeSQL = "SELECT status from payment_entity order by created DESC LIMIT 1;";

                var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");

            return runner.query(conn, codeSQL, new ScalarHandler<>());


    }

    @SneakyThrows
    public static String getTransactionCardStatusByCreditCard() {
        var runner = new QueryRunner();

        var codeSQL = "SELECT status from credit_request_entity order by created DESC LIMIT 1;";

                var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");

            return runner.query(conn, codeSQL, new ScalarHandler<>());


    }

    @SneakyThrows
    public static void clearSUT() {
        var runner = new QueryRunner();
        var deleteCreditPaymentInfoTableSQL = "DELETE FROM public.credit_request_entity ;";
        var deleteOrderInfoTableSQL = "DELETE FROM public.order_entity ;";
        var deleteDebitPaymentInfoTableSQL1 = "DELETE FROM public.payment_entity ;";


                var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");

            var deleteCodes = runner.update(conn, deleteCreditPaymentInfoTableSQL);
            var deleteCardsInfo = runner.update(conn, deleteOrderInfoTableSQL);
            var deleteUsers1 = runner.update(conn, deleteDebitPaymentInfoTableSQL1);

    }
}

