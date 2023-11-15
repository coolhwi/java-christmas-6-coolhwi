package christmas.controller;

import christmas.Model.Consumer;
import christmas.view.InputView;

import java.util.*;

public class InputController {
    Consumer consumer;
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MANU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InputController(Consumer consumer) {
        this.consumer = consumer;
    }

    public void print() {
        System.out.println(consumer.getDate());
        System.out.println(consumer.getMenuAndNum());
    }

    public void proceedInputDate() {
        while (true) {
            try {
                insertDate(InputView.enterVisitDate());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void proceedInputMenuAndNum() {
        while (true) {
            try {
                processMenuAndNumInput(InputView.enterFoodAndNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void insertDate(String inputDate) {
        int date = 0;
        try {
            date = Integer.parseInt(inputDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
        consumer.setDate(date);
    }

    public void processMenuAndNumInput(String menuAndNum) {
        String notEmptyMenu = menuAndNum.replace(" ", "");
        List<String> menuNumList = splitMenuAndNum(notEmptyMenu);
        validateMenuAndNum(menuAndNum);
        HashMap<String, Integer> menusAndNums = createMenuAndNumMap(menuNumList);
        validateMenuName(menusAndNums);
        validateMenuNum(menusAndNums);
        consumer.setMenuAndNum(menusAndNums);
    }

    private List<String> splitMenuAndNum(String menuAndNum) {
        return List.of(menuAndNum.split(",")); // You may consider a different separator if needed
    }

    private HashMap<String, Integer> createMenuAndNumMap(List<String> menuNumList) {
        HashMap<String, Integer> menusAndNums = new HashMap<>();

        for (String menuNums : menuNumList) {
            String[] s = menuNums.split("-");
            try {
                Set set = menusAndNums.keySet();
                if (set.contains(s[0])) { //중복 메뉴 예외처리
                    throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
                }
                menusAndNums.put(s[0], Integer.parseInt(s[1]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
            }
        }

        return menusAndNums;
    }

    public void validateMenuNum(HashMap<String, Integer> menusAndNums) {
        int totalOrderMenuNum = 0;
        for (String name : menusAndNums.keySet()) {
            totalOrderMenuNum += menusAndNums.get(name);
        }
        if (totalOrderMenuNum > 20) {
            throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
        }
    }

    public void validateMenuAndNum(String menuAndNum) {
        String[] s = menuAndNum.split("-");
        if (menuAndNum.equals("")) {
            throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
        }
        if (!menuAndNum.contains("-")) {
            throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
        }
        if (s.length == 1) {
            throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
        }
    }

    public void validateMenuName(HashMap<String, Integer> menusAndNums) {
        List<String> menu = new ArrayList<>();
        String[] s = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"};
        menu = List.of(s);
        for (String key : menusAndNums.keySet()) {
            if (!menu.contains(key)) {
                throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
            }
        }
        menuDuplicateCheck(menusAndNums);
        onlyDrinkCheck(menusAndNums);

    }

    public void menuDuplicateCheck(HashMap<String, Integer> menusAndNums) {

    }

    public void onlyDrinkCheck(HashMap<String, Integer> menusAndNums) {
        String[] s = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림"};
        List<String> menus = List.of(s);
        int count = 0;
        for (String menuName : menusAndNums.keySet()) {
            if (menus.contains(menuName)) {
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException(MANU_ERROR_MESSAGE);
        }
    }
}
