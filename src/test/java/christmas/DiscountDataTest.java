package christmas;

import christmas.Model.Consumer;
import christmas.Model.EventDiscount;
import christmas.controller.DiscountController;
import christmas.controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountDataTest {
    Consumer consumer = new Consumer();
    EventDiscount eventDiscount = new EventDiscount();
    InputController inputController = new InputController(consumer);
    DiscountController discountController = new DiscountController(consumer,eventDiscount);

    @DisplayName("12월 3일 일때 크리스마스 디데이, 평일디저트, 특별할인이 들어간다.")
    @Test
    void dailyDiscountTest(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("3");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 4046);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 1200);
        assertThat(eventDiscount.getWeekendDiscount() == 0);
        assertThat(eventDiscount.getSpecialDiscount() == 1000);
    }

    @DisplayName("12월 5일 일때 크리스마스 디데이, 평일디저트할인이 들어간다.")
    @Test
    void dailyDiscountTest2(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("5");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 4046);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 1400);
        assertThat(eventDiscount.getWeekendDiscount() == 0);
        assertThat(eventDiscount.getSpecialDiscount() == 0);
    }
    @DisplayName("12월 26일 일때 평일디저트할인이 들어간다.")
    @Test
    void dailyDiscountTest3(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("26");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 4046);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 0);
        assertThat(eventDiscount.getWeekendDiscount() == 0);
        assertThat(eventDiscount.getSpecialDiscount() == 0);
    }
    @DisplayName("12월 31일 일때 평일디저트할인이 들어간다.")
    @Test
    void dailyDiscountTest4(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("31");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 4046);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 0);
        assertThat(eventDiscount.getWeekendDiscount() == 0);
        assertThat(eventDiscount.getSpecialDiscount() == 1000);
    }
    @DisplayName("12월 25일 일때 특별할인, 크리스마스 디데이 할인, 평일디저트할인이 들어간다.")
    @Test
    void dailyDiscountTest5(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("31");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 4046);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 3400);
        assertThat(eventDiscount.getWeekendDiscount() == 0);
        assertThat(eventDiscount.getSpecialDiscount() == 1000);
    }

    @DisplayName("12월 8일일때 크리스마스 디데이, 주말메인음식 할인이 들어간다.")
    @Test
    void weekendDiscountTest(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("8");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 0);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 1700);
        assertThat(eventDiscount.getWeekendDiscount() == 4046);
        assertThat(eventDiscount.getSpecialDiscount() == 0);
    }
    @DisplayName("12월 29일일때 주말 메인음식 할인이 들어간다.")
    @Test
    void weekendDiscountTest2(){
        inputController.processMenuAndNumInput("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        inputController.insertDate("29");
        discountController.proceedDiscount();
        assertThat(eventDiscount.getDailyDiscount() == 0);
        assertThat(eventDiscount.getChristmasDDayDiscount() == 0);
        assertThat(eventDiscount.getWeekendDiscount() == 4046);
        assertThat(eventDiscount.getSpecialDiscount() == 0);
    }


}
