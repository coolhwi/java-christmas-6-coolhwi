package christmas.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String FIRST_LINE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String INPUT_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_FOOD_MENU_AND_NUM = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static int enterVisitDate(){
        System.out.println(FIRST_LINE);
        System.out.println(INPUT_VISIT_DATE);
        return Integer.parseInt(Console.readLine());
    }

    public static String enterFoodAndNum(){
        System.out.println(INPUT_FOOD_MENU_AND_NUM);
        return Console.readLine();
    }


}
