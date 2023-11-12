package christmas.view;

public class OutputView {
    private static final String DATE_OF_VISITED = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_MONEY = "<할인 전 총주문 금액>";
    private static final String PRESENTATION_MENU = "<증정 메뉴>";
    private static final String BENEFITS = "<혜택 내역>";

    public static void printDateOfVisited(int date){
        System.out.printf(DATE_OF_VISITED,date);
    }
}
