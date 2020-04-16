package data;

import com.github.javafaker.Faker;
import utils.ConnectionToDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftCertificateData {

    public String getValidCertificateCode() {
        String selectCode = "select code from oc_voucher" +
                " order by amount desc;";
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String code = " ";
        try (ResultSet rs = connection.createStatement().executeQuery(selectCode)) {
            if (rs.next()) {
                code = rs.getObject("code").toString();
            } else {
                code = getNewCertificate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }

    public String getNewCertificate() {
        String insertCode = "insert into oc_voucher values (null, 0, 60606, 'Nina', 'nina@nina.com', 'Lina', " +
                "'Lina@lina.com', 7,\" \", 1000, 1, '2020-04-25 16:24:54');";
        String selectCode = "select code from oc_voucher" +
                " order by amount desc;";
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String code = "";
        try {
            connection.createStatement().executeUpdate(insertCode);
            ResultSet rs = connection.createStatement().executeQuery(selectCode);
            if (rs.next()) {
                code = rs.getObject("code").toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
        return code;
    }

    public String getInvalidCertificateCode() {
        Faker faker = new Faker();
        String code = faker.zipCode();
        while (isCodeExist(code)) {
            code = faker.words(1).toString();
        }
        return code;
    }

    public Boolean isCodeExist(String code) {
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String selectCodeCount = "select count(code) " +
                "from oc_voucher " +
                "where code like \"" + code + "\";";
        Boolean result = false;
        try (ResultSet rs = connection.createStatement().executeQuery(selectCodeCount)) {
            if (rs.next()) {
                String codeCount = rs.getObject("count(code)").toString();
                if (!codeCount.equals("0")) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
