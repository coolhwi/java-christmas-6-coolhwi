package christmas.controller;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.view.OutputView;

public class TotalController {
    Consumer consumer = new Consumer();
    EventDiscount eventDiscount = new EventDiscount();
    InputController inputController = new InputController(consumer);
    DiscountController discountController = new DiscountController(consumer,eventDiscount);
    public void run(){

        inputController.proceedInputDate();
        inputController.proceedInputMenuAndNum();
        OutputView.printDateOfVisited(consumer.getDate());
        OutputView.printOrderMenu(consumer);

        discountController.proceedDiscount();

        outputRun();

    }
    public void outputRun(){
        OutputView.printOrderMenu(consumer);
        OutputView.printBeforeDiscountTotalMoney(eventDiscount);
        OutputView.printGiftDetail(eventDiscount);
        OutputView.printBenefitDetail(eventDiscount);
        OutputView.printTotalBenefitMoney(eventDiscount);
        OutputView.printAfterDiscountMoney(eventDiscount);
        OutputView.printEventBadge(eventDiscount.getTotalMoney());
    }
}
