package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.DashBoardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    @DisplayName("(Bug)В конце теста должно быть сообщение об ошибке, при попытка перевести " +
            "с карыт на карту с одинаковым номером")
    void shouldTransferMoneyBetweenDiffrentUser() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoney();
    }

    @Test
    @DisplayName("Тест должен пополнять баланс первой карты и проверять в конце правильность")
    void shouldTransferMoneyToBalance1() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToCard1();
        dashBoardPage.dashBoardPageVisible();
    }

    @Test
    @DisplayName("Тест должен пополнять баланс второй карты и проверять в конце правильность")
    void shouldTransferMoneyToBalance2() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToCard2();
        dashBoardPage.dashBoardPageVisible();
    }
    @Test
    @DisplayName("(BUG)Тест уводить баланс в минус")
    void shouldTransferMoneyToNegative() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToNegativeBalance();
        dashBoardPage.dashBoardPageVisible();
    }
}
