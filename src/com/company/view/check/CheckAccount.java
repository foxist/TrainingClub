package com.company.view.check;

import javax.swing.*;

public class CheckAccount {

    public boolean getCheck(JPanel panel, String name, String surname, boolean gender, String login, String password) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(panel, "�� �� ������� ���!",
                    "��������������!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (surname.equals("")) {
            JOptionPane.showMessageDialog(panel, "�� �� ������� �������!",
                    "��������������!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!gender) {
            JOptionPane.showMessageDialog(panel, "�� �� ������� ���!",
                    "��������������!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (login.equals("")) {
            JOptionPane.showMessageDialog(panel, "�� �� ������� �����!",
                    "��������������!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(panel, "�� �� ������� ������!",
                    "��������������!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
