package data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {

        return new AuthInfo("petya", "123qwerty");

    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }
    public static class CartData {
        private static String numberAccount1 = "5559 0000 0000 0001";
        private static String numberAccount2 = "5559 0000 0000 0002";

        public static String getNumberAccount1() {
            return numberAccount1;
        }

        public static String getNumberAccount2() {
            return numberAccount2;
        }

    }

}

