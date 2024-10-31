package pro.sky.calculator;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String startMessage() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String addTwoNumbers(String num1, String num2) {
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return String.format("%s + %s = %d", num1, num2, result);
    }

    @Override
    public String minusTwoNumbers(String num1, String num2) {
        int result = Integer.parseInt(num1) - Integer.parseInt(num2);
        return String.format("%s - %s = %d", num1, num2, result);
    }

    @Override
    public String multiplyTwoNumbers(String num1, String num2) {
        int result = Integer.parseInt(num1) * Integer.parseInt(num2);
        return String.format("%s * %s = %d", num1, num2, result);
    }

    @Override
    public String divideTwoNumbers(String num1, String num2) {
        if (num2.equals("0")) {
            return "На ноль делить нельзя!";
        }
        int result = Integer.parseInt(num1) / Integer.parseInt(num2);
        return String.format("%s / %s = %d", num1, num2, result);
    }

}
