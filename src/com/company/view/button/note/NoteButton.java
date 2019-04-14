package com.company.view.button.note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NoteButton extends JButton {
    public NoteButton() {
        super(new ButtonAction());
        setBackground(Color.WHITE);
        setIcon(new ImageIcon("C:/Users/zayil/ideaProjects/Gym/Resources/buttons/note.png"));
        setPreferredSize(new Dimension(50, 50));
        setMinimumSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
    }

    public GridBagConstraints GBCNote() {
        return new GridBagConstraints(1, 5, 1, 1, 0.0, 1.0,
                GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
                new Insets(10, 12, 10, 15), 0, 0);
    }

    static class ButtonAction extends AbstractAction {
        public ButtonAction() {
            putValue(AbstractAction.SHORT_DESCRIPTION, "Notes");
        }

        @Override
        public void actionPerformed(ActionEvent e) {}
    }
}
