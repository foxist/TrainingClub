package com.company.view.button.user;

import com.company.model.account.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserButton extends JButton {

    public UserButton(Data d) {
        super(new ButtonAction(d));
        setBackground(Color.WHITE);
        setIcon(new ImageIcon("C:/Users/zayil/ideaProjects/Gym/Resources/buttons/user.jpg"));
        setPreferredSize(new Dimension(50, 50));
        setMinimumSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
        revalidate();
    }

    public GridBagConstraints GBCUser() {
        return new GridBagConstraints(5, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL,
                new Insets(10, 21, 5, 10), 0, 0);
    }

    static class ButtonAction extends AbstractAction {
        public ButtonAction(Data data) {
            putValue(AbstractAction.SHORT_DESCRIPTION, "User: " + data.getLogin());
        }

        @Override
        public void actionPerformed(ActionEvent e) {}
    }
}
