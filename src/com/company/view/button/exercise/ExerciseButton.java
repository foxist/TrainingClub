package com.company.view.button.exercise;

import javax.swing.*;
import java.awt.*;

public class ExerciseButton extends JButton {

    public ExerciseButton() {
        super("Training Club");
        setFont(new Font("Times New Roman", Font.BOLD, 18));
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(200, 50));
        setMinimumSize(new Dimension(200, 50));
        setMaximumSize(new Dimension(200, 50));
    }

    public GridBagConstraints GBCExercise() {
        return new GridBagConstraints(1, 3, 6, 1, 0.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(8, 12, 7, 12), 0, 0);
    }
}
