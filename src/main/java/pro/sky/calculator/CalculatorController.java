package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "calculator")
    public String startMessage() {
        return calculatorService.startMessage();
    }

    @GetMapping(path = "/calculator/plus")
    public String addCalculator(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.addTwoNumbers(num1, num2);
    }

    @GetMapping(path = "/calculator/minus")
    public String minusCalculator(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.minusTwoNumbers(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply")
    public String multiplyCalculator(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.multiplyTwoNumbers(num1, num2);
    }
    @GetMapping(path = "/calculator/divide")
    public String divideCalculator(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.divideTwoNumbers(num1, num2);
    }


}
