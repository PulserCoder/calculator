package pro.sky.calculator;

import org.springframework.stereotype.Service;
import pro.sky.calculator.exceptions.WrongLoginException;
import pro.sky.calculator.exceptions.WrongPasswordException;

@Service
public class EnterAccountImpl implements EnterAccount {
    @Override
    public void checkLoginData(String login, String password, String passwordConfirm) {
        String acceptedSymbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        if (!password.equals(passwordConfirm) || password.length() > 20) {
            throw new WrongPasswordException("Пароли неверные");
        }
        for (int i = 0; i < password.length(); i++) {
            if (acceptedSymbols.indexOf(password.charAt(i)) == -1) {
                throw new WrongPasswordException("Пароль из некорректных символов");
            }
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длина больше 20");
        }
        for (int i = 0; i < login.length(); i++) {
            if (acceptedSymbols.indexOf(login.charAt(i)) == -1) {
                throw new WrongLoginException("Login из некорректных символов");
            }
        }

    }
}
