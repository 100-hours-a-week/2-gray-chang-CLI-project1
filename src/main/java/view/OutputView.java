package view;

import calculatorEnum.OutputMessage;
import controller.Controller;
import orderObject.Order;

public class OutputView {

    public void output(double answer) {
        System.out.println(OutputMessage.returnAnswer.getMessage() + answer);
    }
}
