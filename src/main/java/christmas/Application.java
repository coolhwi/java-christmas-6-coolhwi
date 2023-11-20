package christmas;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.Model.Menu;
import christmas.controller.DiscountController;
import christmas.controller.InputController;
import christmas.controller.TotalController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalController totalController = new TotalController();
        totalController.run();

    }
}
