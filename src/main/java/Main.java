import controller.Controller;
import orderObject.Order;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        Controller controller = new Controller();
        double answer = controller.calculate(order);

        OutputView outputView = new OutputView();
        outputView.output(answer);
    }
}
