package com.company.view.training;

import javax.swing.*;
import java.awt.*;

public class Training extends JButton {
    private int flag;

    public Training(String str, int flag) {
        super(str);
        this.flag = flag;
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(50, 50));
        setMinimumSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
    }

    public int getFlag() {
        return flag;
    }
}