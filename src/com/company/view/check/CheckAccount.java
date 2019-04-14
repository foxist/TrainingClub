package com.company.view.check;

import javax.swing.*;

public class CheckAccount {

    public boolean getCheck(JPanel panel, String name, String surname, boolean gender, String login, String password) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(panel, "Вы не указали Имя!",
                    "Предупреждение!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (surname.equals("")) {
            JOptionPane.showMessageDialog(panel, "Вы не указали Фамилию!",
                    "Предупреждение!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!gender) {
            JOptionPane.showMessageDialog(panel, "Вы не выбрали Пол!",
                    "Предупреждение!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (login.equals("")) {
            JOptionPane.showMessageDialog(panel, "Вы не указали Логин!",
                    "Предупреждение!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(panel, "Вы не указали Пароль!",
                    "Предупреждение!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
