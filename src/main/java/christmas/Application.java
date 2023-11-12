package christmas;

import christmas.controller.InputController;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputController inputController = new InputController();
        inputController.proceedInputDate();
        inputController.proceedInputMenuAndNum();
        inputController.print();
    }
}
