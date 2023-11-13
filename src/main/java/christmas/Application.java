package christmas;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.Model.Menu;
import christmas.controller.DiscountController;
import christmas.controller.InputController;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Consumer consumer = new Consumer();
        EventDiscount eventDiscount = new EventDiscount();
        InputController inputController = new InputController(consumer);
        inputController.proceedInputDate();
        inputController.proceedInputMenuAndNum();
        inputController.print();

        DiscountController discountController = new DiscountController(consumer,eventDiscount);
        discountController.proceedDiscount();
        System.out.println("크리스마스 디데이 할인: "+eventDiscount.getChristmasDDayDiscount());
        System.out.println("평일 할인: "+eventDiscount.getDailyDiscount());
        System.out.println("주말 할인: "+eventDiscount.getWeekendDiscount());
        System.out.println("특별 할인: "+eventDiscount.getSpecialDiscount());
        System.out.println("총 구매 금액: "+eventDiscount.getTotalMoney());
        System.out.println("증정 이벤트: "+eventDiscount.isGiftEvent());
        System.out.println("총 혜택 금액: "+eventDiscount.getTotalBenefitMoney());
    }
}
