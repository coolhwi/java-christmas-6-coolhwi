package christmas.controller;

import christmas.Model.Consumer;
import christmas.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputController {
    Consumer consumer;

    public InputController(Consumer consumer){
        this.consumer = consumer;
    }

    public void print(){
        System.out.println(consumer.getDate());
        System.out.println(consumer.getMenuAndNum());
    }
    public void proceedInputDate(){
        while(true) {
            try {
                insertDate(InputView.enterVisitDate());
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public void proceedInputMenuAndNum(){
        while(true) {
            try {
                insertMenuAndNum(InputView.enterFoodAndNum());
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

    }

    public void insertDate(String inputDate){
        int date = 0;
        try {
            date = Integer.parseInt(inputDate);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 날짜를 숫자로 넣어 주세요");
        }
        if(date <1 || date > 31){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        consumer.setDate(date);
    }

    public void insertMenuAndNum(String menuAndNum){
        String notEmptyMenu = menuAndNum.replace(" ","");
        List<String> menuNum = List.of(notEmptyMenu.split(","));
        HashMap<String,Integer> menusAndNums = new HashMap<>();
        for(String menuNums : menuNum){
            String[] s = menuNums.split("-");
            try {
                menusAndNums.put(s[0],Integer.parseInt(s[1]));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 메뉴 수량을 숫자를 넣어주세요.");
            }
        }
        validateMenuName(menusAndNums);
        consumer.setMenuAndNum(menusAndNums);
    }
    public void validateMenuName(HashMap<String,Integer> menusAndNums){
        List<String> menu = new ArrayList<>();
        String[] s = {"양송이수프","타파스","시저샐러드","티본스테이크","바비큐립","해산물파스타","크리스마스파스타","초코케이크","아이스크림","제로콜라","레드와인","샴페인"};
        menu = List.of(s);
        for(String key : menusAndNums.keySet()){
            if(!menu.contains(key)){
                throw new IllegalArgumentException("[ERROR] 메뉴 이름이 잘못 되었습니다. 다시 입력 바랍니다.");
            }
        }

    }
}
