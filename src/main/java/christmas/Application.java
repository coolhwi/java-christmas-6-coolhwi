package christmas;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.Model.Menu;
import christmas.controller.DiscountController;
import christmas.controller.InputController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Consumer consumer = new Consumer();
        EventDiscount eventDiscount = new EventDiscount();
        InputController inputController = new InputController(consumer);
        inputController.proceedInputDate();
        inputController.proceedInputMenuAndNum();
        OutputView.printDateOfVisited(consumer.getDate());
        OutputView.printOrderMenu(consumer);

        DiscountController discountController = new DiscountController(consumer,eventDiscount);
        discountController.proceedDiscount();

        OutputView.printOrderMenu(consumer);
        OutputView.printBeforeDiscountTotalMoney(eventDiscount);
        OutputView.printGiftDetail(eventDiscount);
        OutputView.printBenefitDetail(eventDiscount);
        OutputView.printTotalBenefitMoney(eventDiscount);
        OutputView.printAfterDiscountMoney(eventDiscount);
        OutputView.printEventBadge(eventDiscount.getTotalMoney());

    }
}
