package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonBalance1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement buttonBalance2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement amountToTransfer=$(".input__control");
    private SelenideElement userFrom = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement refill = $("[data-test-id='action-transfer']");
    private SelenideElement notificationError = $("[data-test-id='error-notification']");


    public void dashBoardPageVisible() {
        heading.shouldBe(visible);
    }
    public void transferMoneyToCard1(int amount) {
        buttonBalance1.click();
        amountToTransfer.setValue(String.valueOf(amount));
        userFrom.setValue(DataHelper.CartData.getNumberAccount2());
        refill.click();
    }

    public void transferMoneyToCard2(int amount) {
        buttonBalance2.click();
        amountToTransfer.setValue(String.valueOf(amount));
        userFrom.setValue(DataHelper.CartData.getNumberAccount1());
        refill.click();
    }

    public void transferMoneyToNegativeBalance(int amount) {
        buttonBalance1.click();
        amountToTransfer.setValue(String.valueOf(amount));
        userFrom.setValue(DataHelper.CartData.getNumberAccount2());
        refill.click();
        notificationError.shouldBe(visible);
    }
    public void transferMoney(int amount) {
        buttonBalance1.click();
        amountToTransfer.setValue(String.valueOf(amount));
        userFrom.setValue(DataHelper.CartData.getNumberAccount1());
        refill.click();
        notificationError.shouldBe(visible);
    }
}
