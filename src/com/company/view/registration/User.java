package com.company.view.registration;

import com.company.model.account.Data;
import com.company.view.check.CheckAccount;
import com.company.view.enter.EnterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class User extends JDialog {
    private JTextField name, surname, login;
    private JPasswordField password;
    private ButtonGroup group;
    private JRadioButton male, female;
    private JButton save, cancel;

    public User() {
        super(new JFrame(), "New User", true);
        setPreferredSize(new Dimension(300, 450));
        setMaximumSize(new Dimension(300, 450));
        setMinimumSize(new Dimension(300, 450));
        name = new JTextField(24);
        surname = new JTextField(24);
        group = new ButtonGroup();
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        login = new JTextField(24);
        password = new JPasswordField(24);
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        setUserPanel();
        setLocationRelativeTo(null);
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public void setSurname(JTextField surname) {
        this.surname = surname;
    }

    public void setMale(JRadioButton male) {
        this.male = male;
    }

    public void setFemale(JRadioButton female) {
        this.female = female;
    }

    public void setLogin(JTextField login) {
        this.login = login;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }

    public void setSave(JButton save) {
        this.save = save;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    public JTextField getname() {
        return name;
    }

    public JTextField getSurname() {
        return surname;
    }

    public JRadioButton getMale() {
        return male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    public JTextField getLogin() {
        return login;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JButton getSave() {
        return save;
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setUserPanel() {
        setLayout(new GridLayout(6, 1));
        add(getNamePanel());
        add(getSurnamePanel());
        add(getGenderPanel());
        add(getLoginPanel());
        add(getPasswordPanel());
        add(getButtonPanel());
    }

    private JPanel getNamePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("*Name"));
        panel.add(name, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        return panel;
    }

    private JPanel getSurnamePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("*Surname"));
        panel.add(surname, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        return panel;
    }

    private JPanel getGenderPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("*Gender"));
        group.add(male);
        group.add(female);
        panel.add(male, BorderLayout.NORTH);
        panel.add(female, BorderLayout.CENTER);
        return panel;
    }

    private JPanel getLoginPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("*Login"));
        panel.add(login, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        return panel;
    }

    private JPanel getPasswordPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("*Password"));
        panel.add(password, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        return panel;
    }

    private JPanel getButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(getSave(), new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        panel.add(getCancel(), new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        getCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EnterPanel().setVisible(true);
            }
        });
        getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = new Data();
                try {
                    if (data.getCompareLogin(getLogin().getText())) {
                        data.setNewUserLogin(getLogin().getText());
                        if (getMale().isSelected()) {
                            try {
                                if (new CheckAccount().getCheck(panel, getname().getText(), getSurname().getText(), getMale().isSelected(),
                                        getLogin().getText(), String.valueOf(getPassword().getPassword()))) {

                                    data.setNewUser(getname().getText(), getSurname().getText(), getMale().getText(),
                                            getLogin().getText(), String.valueOf(getPassword().getPassword()));
                                    JOptionPane.showMessageDialog(new JPanel(), "Сохранение прошло успешно!",
                                            "Сохранение", JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                    new EnterPanel().setVisible(true);
                                }
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(panel, "Данного файла не существует!",
                                        "Ошибка!", JOptionPane.ERROR_MESSAGE);
                                setVisible(false);
                            }
                        } else {
                            try {
                                if (new CheckAccount().getCheck(panel, getname().getText(), getSurname().getText(), getFemale().isSelected(),
                                        getLogin().getText(), String.valueOf(getPassword().getPassword()))) {

                                    data.setNewUser(getname().getText(), getSurname().getText(), getFemale().getText(),
                                            getLogin().getText(), String.valueOf(getPassword().getPassword()));
                                    JOptionPane.showMessageDialog(new JPanel(), "Сохранение прошло успешно!",
                                            "Сохранение", JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                    new EnterPanel().setVisible(true);
                                }
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(panel, "Данного файла не существует!",
                                        "Ошибка!", JOptionPane.ERROR_MESSAGE);
                                setVisible(false);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JPanel(), "Данный логин занят!",
                                "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(panel, "Данного файла не существует!",
                            "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                }
            }
        });
        return panel;
    }
}
