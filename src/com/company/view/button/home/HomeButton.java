package com.company.view.button.home;

import javax.swing.*;
import java.awt.*;

public class HomeButton {
    private static JButton home;

    public HomeButton() {
        home = new JButton();
        home.setBackground(Color.WHITE);
        home.setIcon(new ImageIcon("C:/Users/zayil/ideaProjects/Gym/Resources/buttons/home.jpg"));
        home.setPreferredSize(new Dimension(50, 50));
        home.setMinimumSize(new Dimension(50, 50));
        home.setMaximumSize(new Dimension(50, 50));
    }

    public JButton getHomeButton() {
        return home;
    }

    public GridBagConstraints GBCHome() {
        return new GridBagConstraints(3, 5, 1, 1, 0.0, 1.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 15, 10, 13), 0, 0);
    }
}
