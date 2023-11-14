package christmas;

import christmas.Model.Consumer;
import christmas.controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputDataTest {
    Consumer consumer = new Consumer();
    InputController inputController = new InputController(consumer);

    @DisplayName("날짜를 1~31 범위를 벗어나거나 문자가 들어오면 예외를 발생시킨다.")
    @Test
    void createErrorNotValidInputDate(){
        assertThatThrownBy(() -> inputController.insertDate("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertDate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertDate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 이름이 이상하면 예외를 발생시킨다.")
    @Test
    void createErrorNotValidMenuName(){
        assertThatThrownBy(() -> inputController.insertMenuAndNum("gkgkg-2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertMenuAndNum("gkgkg-"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertMenuAndNum("티본스테이크-22"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertMenuAndNum("티본스테이크--2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertMenuAndNum("티본스테이크2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputController.insertMenuAndNum("티본스테이크-5,크리스마스파스타-16"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티본스테이크 메뉴를 넣으면 소비자 객체에 잘 들어간다.")
    @Test
    void inputMenuTest(){
        inputController.insertMenuAndNum("티본스테이크-1,크리스마스파스타-2");
        assertThat(consumer.getMenuAndNum().keySet().contains("티본스테이크"));
        assertThat(consumer.getMenuAndNum().keySet().contains("크리스마스파스타"));
        assertThat(consumer.getMenuAndNum().get("티본스테이크")==1);
        assertThat(consumer.getMenuAndNum().get("크리스마스파스타")==2);
    }

}
