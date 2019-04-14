package com.company.view.text.note;

import com.company.view.button.home.HomeButton;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Note extends JDialog {

    public Note() {
        super(new JFrame(), "My Note", false);
        setPreferredSize(new Dimension(300, 500));
        setMinimumSize(new Dimension(300, 500));
        setMaximumSize(new Dimension(300, 500));
        getNote();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void getNote() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());

        JButton save = new JButton("SAVE AS");
        JTextField theme = new JTextField("Enter the theme", 25);
        theme.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JTextArea text = new JTextArea("Enter the text", 20, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(text);

        buttons.add(new HomeButton().getHomeButton(), new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(1, 15, 1, 15), 0, 0));
        buttons.add(save, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        add(theme, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fil = new FileNameExtensionFilter("Word document (\"*.doc\")", "*.doc");
                fileChooser.setFileFilter(fil);
                fileChooser.setSelectedFile(new File(theme.getText() + ".doc"));
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
                        writer.write(text.getText());
                        writer.flush();
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
