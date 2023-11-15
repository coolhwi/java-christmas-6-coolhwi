package christmas.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String EVENT_PRECAUTION1 = "총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다.";
    private static final String EVENT_PRECAUTION2 = "음료만 주문 시, 주문할 수 없습니다.";
    private static final String EVENT_PRECAUTION3 = "메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다.";
    private static final String FIRST_LINE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String INPUT_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_FOOD_MENU_AND_NUM = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static String enterVisitDate() {
        System.out.println("<주의 사항>");
        System.out.println(EVENT_PRECAUTION1);
        System.out.println(EVENT_PRECAUTION2);
        System.out.println(EVENT_PRECAUTION3);
        System.out.println("");
        System.out.println(FIRST_LINE);
        System.out.println(INPUT_VISIT_DATE);
        return Console.readLine();
    }

    public static String enterFoodAndNum() {
        System.out.println(INPUT_FOOD_MENU_AND_NUM);
        return Console.readLine();
    }


}
