package christmas.controller;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.Model.Menu;

import java.util.ArrayList;
import java.util.List;

public class DiscountController {
    Consumer consumer;
    EventDiscount eventDiscount;
    public DiscountController(Consumer consumer,EventDiscount eventDiscount){
        this.consumer = consumer;
        this.eventDiscount = eventDiscount;
    }

    public void proceedDiscount(){
        calculateDDayChristmas(consumer.getDate());
        calculateDaily(consumer.getDate());
        calculateWeekend(consumer.getDate());
        calculateSpecial(consumer.getDate());
        calculateTotalMoney();
        calculateGift(eventDiscount.getTotalMoney());
        eventDiscount.setTotalBenefitMoney();

    }
    public void calculateTotalMoney(){
        int sumMoney = 0;
        for(String name : consumer.getMenuAndNum().keySet()){
            sumMoney += compareMenu(name,consumer.getMenuAndNum().get(name));
        }
        eventDiscount.setTotalMoney(sumMoney);
    }
    public int compareMenu(String name,int num){
        Menu[] m = Menu.values();
        for(Menu menu : m){
            if(menu.getName().equals(name)){
                return menu.getPrice()*num;
            }
        }
        return 0;
    }
    public void calculateDDayChristmas(int date){
        int discountMoney = 0;
        if(date >25){
            eventDiscount.setChristmasDDayDiscount(0);
            return;
        }
        discountMoney = 1000 + (date-1)*100;
        eventDiscount.setChristmasDDayDiscount(discountMoney);

    }
    public void calculateDaily(int date){
        String[] s = {"초코케이크", "아이스크림"};
        List<String> dessertMenu = List.of(s);
        int dailyDate = date % 7;
        int dessertNum = 0;
        if(dailyDate == 0 || (dailyDate >2 && dailyDate < 7)){
            dessertNum = calculateDessert(dessertMenu);
        }
        eventDiscount.setDailyDiscount(2023*dessertNum); //디저트 몇개인지 계산 하고 할인 값 계산
    }
    public int calculateDessert(List<String> dessertMenu){
        int count = 0;
        for(String s : consumer.getMenuAndNum().keySet()){
            if(dessertMenu.contains(s)){
                count= count + consumer.getMenuAndNum().get(s);
            }
        }
        return count;
    }
    public void calculateWeekend(int date){
        String[] s = {"티본스테이크", "바비큐립","해산물파스타","크리스마스파스타"};
        List<String> mainMenu = List.of(s);
        int WeekendDate = date % 7;
        int mainNum = 0;
        if(WeekendDate == 1 || WeekendDate == 2){
            mainNum = calculateMain(mainMenu);
        }
        eventDiscount.setWeekendDiscount(2023*mainNum);
    }
    public int calculateMain(List<String> mainMenu){
        int count = 0;
        for(String s : consumer.getMenuAndNum().keySet()){
            if(mainMenu.contains(s)){
                count++;
            }
        }
        return count;
    }
    public void calculateSpecial(int date){
        int specialDate = date % 7;
        if(specialDate == 3 || date == 25){
            eventDiscount.setSpecialDiscount(1000);
        }
    }
    public void calculateGift(int totalMoney){
        if(totalMoney >= 120000){
            eventDiscount.setGiftEvent(true);
        }
    }

}
