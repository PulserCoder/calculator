package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.exceptions.WrongLoginException;
import pro.sky.calculator.exceptions.WrongPasswordException;

@RestController
public class EnterAccountController {
    private final EnterAccount enterAccount;

    public EnterAccountController(EnterAccount enterAccount) {
        this.enterAccount = enterAccount;
    }


    @GetMapping(path = "login")
    public String enterAccount(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("passwordConfirm") String passwordConfirm) {
        try {
            enterAccount.checkLoginData(login, password, passwordConfirm);
            return "Success";
        } catch (WrongLoginException e) {
            return "Вы ввели некоректный логин";
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return "Вы ввели некорректный пароль";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка неизвестного рода";
        }
    }
}
