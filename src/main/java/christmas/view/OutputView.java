package christmas.view;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;

public class OutputView {
    private static final String DATE_OF_VISITED = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_MONEY = "<할인 전 총주문 금액>";
    private static final String PRESENTATION_MENU = "<증정 메뉴>";
    private static final String BENEFITS = "<혜택 내역>";
    private static final String TOTAL_BENEFITS = "<총혜택 금액>";
    private static final String AFTER_DISCOUNT_MONEY = "<할인 후 예상 결제 금액>";
    private static final String BADGE_EVENT = "<12월 이벤트 배지>";

    public static void printDateOfVisited(int date){
        System.out.printf(DATE_OF_VISITED,date);
        System.out.println("");
    }

    public static void printOrderMenu(Consumer consumer){
        System.out.println("");
        System.out.println(ORDER_MENU);
        for(String menu: consumer.getMenuAndNum().keySet()){
            System.out.println(menu+" "+consumer.getMenuAndNum().get(menu)+"개");
        }
    }
    public static void printBeforeDiscountTotalMoney(EventDiscount eventDiscount){
        System.out.println("");
        System.out.println(BEFORE_DISCOUNT_MONEY);
        System.out.println(eventDiscount.getTotalMoney());

    }

    public static void printGiftDetail(EventDiscount eventDiscount){
        System.out.println("");
        System.out.println(PRESENTATION_MENU);
        if(eventDiscount.isGiftEvent()){
            System.out.println("샴페인 1개");
        }
        if(!eventDiscount.isGiftEvent()){
            System.out.println("없음");
        }
        System.out.println("");

    }

    public static void printBenefitDetail(EventDiscount eventDiscount) {
        System.out.println(BENEFITS);

        printDiscount("크리스마스 디데이 할인", eventDiscount.getChristmasDDayDiscount());
        printDiscount("평일 할인", eventDiscount.getDailyDiscount());
        printDiscount("주말 할인", eventDiscount.getWeekendDiscount());
        printDiscount("특별 할인", eventDiscount.getSpecialDiscount());

        if (eventDiscount.isGiftEvent()) {
            printDiscount("증정 이벤트", 25000);
        }

        if (eventDiscount.getTotalBenefitMoney() == 0) {
            System.out.println("없음");
        }

        System.out.println();
    }

    private static void printDiscount(String label, int discountAmount) {
        if (discountAmount != 0) {
            System.out.printf("%s: -%d원%n", label, discountAmount);
        }
    }


    public static void printTotalBenefitMoney(EventDiscount eventDiscount){
        System.out.println(TOTAL_BENEFITS);
        System.out.println("-"+eventDiscount.getTotalBenefitMoney());
        System.out.println("");
    }

    public static void printAfterDiscountMoney(EventDiscount eventDiscount){
        int afterDiscountMoney = eventDiscount.getTotalMoney() - eventDiscount.getTotalBenefitMoney();
        if(eventDiscount.isGiftEvent()){
            afterDiscountMoney+=25000;
        }
        System.out.println(AFTER_DISCOUNT_MONEY);
        System.out.println(afterDiscountMoney+"원");
        System.out.println("");
    }

    public static void printEventBadge(int totalMoney){
        System.out.println(BADGE_EVENT);
        if(totalMoney >= 5000 && totalMoney < 10000){
            System.out.println("별");
        }
        if(totalMoney >= 10000 && totalMoney <20000){
            System.out.println("트리");
        }
        if(totalMoney >= 20000){
            System.out.println("산타");
        }

    }

}
