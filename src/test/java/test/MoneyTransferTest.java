package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.DashBoardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @BeforeEach
    void loginVerification () {
    open("http://localhost:9999");
    val loginPage = new LoginPage();
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    }

    @Test
    @DisplayName("Тест должен пополнять баланс первой карты и проверять в конце правильность")
    void shouldTransferMoneyToBalance1() {
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToCard1(300);
        dashBoardPage.dashBoardPageVisible();
    }

    @Test
    @DisplayName("Тест должен пополнять баланс второй карты и проверять в конце правильность")
    void shouldTransferMoneyToBalance2() {
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToCard2(300);
        dashBoardPage.dashBoardPageVisible();
    }
    @Test
    @DisplayName("(BUG_1 Нет сообщения об ошибке при минусовом балансе")
    void shouldTransferMoneyToNegative() {
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoneyToNegativeBalance(100000);
    }

    @Test
    @DisplayName("BUG_2_Нет сообщения об ошибке при одновременном пополнении и списании с одной и той же карты")
    void shouldTransferMoneyBetweenDifferentUser() {
        val dashBoardPage = new DashBoardPage();
        dashBoardPage.transferMoney(300);
    }
}
