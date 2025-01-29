package view;

import calculatorEnum.CalculatorEnum;
import calculatorEnum.MethodName;
import orderObject.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;

class InputViewTest {


    @Test
    @DisplayName("정상적인 값 - 일반계산기")
    void goodInputNormal() {
        //given
        String input = "일반계산기\n더하기\n1\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Normal_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(3);
    }

    @Test
    @DisplayName("정상적인 값 - 공학용계산기-읿반사칙연산")
    void goodInputSciNormal() {
        //given
        String input = "공학용계산기\n더하기\n1\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Scientific_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(3);
    }

    @Test
    @DisplayName("정상적인 값 - 공학용계산기-삼각함수")
    void goodInputSciTri() {
        //given
        String input = "공학용계산기\n사인\n90\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Scientific_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.sin);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(90);
    }

    @Test
    @DisplayName("잘못된 값 - 계산기 이름실수")
    void badInputCalcName() {
        //given
        String input = "잘못된 계산기 이름\n일반계산기\n더하기\n1\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Normal_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 값 - 연산 이름실수")
    void badInputMethodName() {
        //given
        String input = "일반계산기\n사인\n더하기\n1\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Normal_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 값 - 첫번째 정수 대입 실수")
    void badInputFirstNum() {
        //given
        String input = "일반계산기\n더하기\n이상한값\n1\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Normal_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 값 - 두번째 정수 대입 실수")
    void badInputSecondNum() {
        //given
        String input = "일반계산기\n더하기\n1\n이상한값\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Normal_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.plus);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(1);
        Assertions.assertThat(order.getSecondNum()).isEqualTo(2);
    }

    @Test
    @DisplayName("잘못된 값 - 공학용 계산기 정수대입 실수")
    void badInputSciFirstNum() {
        //given
        String input = "공학용계산기\n사인\n이상한값\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        InputView inputView = new InputView();
        Order order = inputView.getCalcInput();

        //then
        Assertions.assertThat(order.getWantToUse()).isEqualTo(CalculatorEnum.Scientific_calculator);
        Assertions.assertThat(order.getMethodName()).isEqualTo(MethodName.sin);
        Assertions.assertThat(order.getFirstNum()).isEqualTo(2);
    }
}