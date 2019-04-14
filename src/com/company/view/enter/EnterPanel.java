package com.company.view.enter;

import com.company.model.account.Data;
import com.company.view.mainpanel.MainPanel;
import com.company.view.registration.User;
import com.company.view.window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EnterPanel extends JFrame {
    private JTextField login;
    private JPasswordField password;
    private JButton enter, registration;

    public EnterPanel() {
        super("Enter");
        setPreferredSize(new Dimension(300, 200));
        setMaximumSize(new Dimension(300, 200));
        setMinimumSize(new Dimension(300, 200));
        login = new JTextField(24);
        password = new JPasswordField(24);
        enter = new JButton("Enter");
        registration = new JButton("Registration");
        getEnterPanel();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new Window());
    }

    public void setLogin(JTextField login) {
        this.login = login;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public void setEnter(JButton enter) {
        this.enter = enter;
    }

    public void setRegistration(JButton registration) {
        this.registration = registration;
    }

    public JTextField getLogin() {
        return login;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JButton getEnter() {
        return enter;
    }

    public JButton getRegistration() {
        return registration;
    }

    private void getEnterPanel() {
        setLayout(new GridLayout(3, 1));
        add(getLoginPanel());
        add(getPasswordPanel());
        add(getButtonPanel());
    }

    private JPanel getLoginPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Login"));
        panel.add(getLogin(), BorderLayout.EAST);
        return panel;
    }

    private JPanel getPasswordPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Password"));
        panel.add(getPassword(), BorderLayout.EAST);
        return panel;
    }

    private JPanel getButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        User user = new User();
        panel.add(getEnter(), new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        getEnter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = new Data();
                try {
                    if (data.getComparePassword(getLogin().getText(),
                            String.valueOf(getPassword().getPassword()))) {
                        setVisible(false);
                        data.setPassword("12345");
                        new MainPanel(data.getUser(getLogin().getText())).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Неправильный пароль",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(panel, "Данный пользователь не существует!",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(getRegistration(), new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        getRegistration().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                user.setVisible(true);
            }
        });
        return panel;
    }
}
