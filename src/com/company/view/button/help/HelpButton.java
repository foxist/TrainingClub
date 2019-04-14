package com.company.view.button.help;

import javax.swing.*;
import java.awt.*;

public class HelpButton extends JButton{

    public HelpButton() {
        super();
        setBackground(Color.WHITE);
        setIcon(new ImageIcon("C:/Users/zayil/ideaProjects/Gym/Resources/buttons/help.png"));
        setPreferredSize(new Dimension(50, 50));
        setMinimumSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
    }

    public GridBagConstraints GBCHelp() {
        return new GridBagConstraints(5, 5, 1, 1, 0.0, 1.0,
                GridBagConstraints.SOUTHEAST, GridBagConstraints.HORIZONTAL,
                new Insets(10, 18, 10, 12), 0, 0);
    }
}
