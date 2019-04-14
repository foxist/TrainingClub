package com.company.view.exercise;

import com.company.model.account.Data;
import com.company.view.button.help.HelpButton;
import com.company.view.text.help.Help;
import com.company.view.training.Training;
import com.company.view.window.Window;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise extends JDialog {
    private Style heading = null, normal = null;
    private JCheckBox check[];
    private int i = 1, count = 0;

    public Exercise(Training tr, int countDataCheckBox, int idx, boolean pass, Data data) throws Exception {
        super(new JFrame(), "Day " + Integer.toString(tr.getFlag()), true);
        setPreferredSize(new Dimension(300, 500));
        setMaximumSize(new Dimension(300, 500));
        setMinimumSize(new Dimension(300, 500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        check = new JCheckBox[data.getApproach() + 1];
        for (int i = 0; i < check.length; i++)
            check[i] = new JCheckBox();

        if (idx == 0)
            getStartExercise(tr, countDataCheckBox, data);
        else if (idx == 1)
            getEndExercise(tr, countDataCheckBox, pass, data);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new Window());
    }

    public JCheckBox[] getCheckBox() {
        return this.check;
    }

    public int getCheck(int i) {
        if (check[i].isSelected())
            count++;
        return count;
    }

    public void setHeading(Style heading) {
        this.heading = heading;
    }

    public void setNormal(Style normal) {
        this.normal = normal;
    }

    public Style getHeading() {
        return heading;
    }

    public Style getNormal() {
        return normal;
    }

    private void getStartExercise(Training tr, int countDataCheckBox, Data data) throws Exception {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JButton end = new JButton("END");
        HelpButton help = new HelpButton();
        end.setPreferredSize(new Dimension(200, 50));
        end.setMinimumSize(new Dimension(200, 50));
        end.setMaximumSize(new Dimension(200, 50));

        panel.add(end, new GridBagConstraints(4, 5, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        panel.add(help, help.GBCHelp());
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Help().setVisible(true);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(new JPanel(), "Не удается найти указанный путь к файлу " +
                                    "\"C:/Users/zayil/ideaProjects/Gym/Resources/exercise/help.txt\"",
                            "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        char array[] = data.getExercise(tr).toCharArray();
        JTextPane text = new JTextPane();
        createStyles(text);
        check = new JCheckBox[data.getApproach()];
        for (int i = 0; i < data.getApproach(); i++) {
            check[i] = new JCheckBox();
            if (i < countDataCheckBox)
                check[i].setSelected(true);

            loadText(text, check[i]);
            insertText(text, getString(array), getHeading());
        }
        data.setApproach(0);
        add(new JScrollPane(text), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private void getEndExercise(Training tr, int countDataCheckBox, boolean pass, Data data) throws Exception {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JButton exit = new JButton("EXIT");

        exit.setPreferredSize(new Dimension(200, 50));
        exit.setMinimumSize(new Dimension(200, 50));
        exit.setMaximumSize(new Dimension(200, 50));

        panel.add(exit, new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        char array[] = data.getExercise(tr).toCharArray();
        JTextPane text = new JTextPane();
        createStyles(text);
        check = new JCheckBox[data.getApproach()];
        for (int i = 0; i < data.getApproach(); i++) {
            check[i] = new JCheckBox();
            if (pass) {
                check[i].setSelected(true);
            } else {
                if (i < countDataCheckBox)
                    check[i].setSelected(true);
            }
            loadText(text, check[i]);
            insertText(text, getString(array), getHeading());
        }
        data.setApproach(0);
        add(new JScrollPane(text), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private String getString(char[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (; i < arr.length; i++) {
            stringBuilder.append(arr[i - 1]);
            if (arr[i] >= '0' && arr[i] <= '9')
                if (arr[i + 1] == '.' && arr[i + 2] == ' ')
                    break;
        }
        i++;
        return stringBuilder.toString();
    }

    private void loadText(JTextPane editor, JCheckBox checkBox) {
        StyledDocument doc = editor.getStyledDocument();
        editor.setCaretPosition(doc.getLength());
        checkBox.setOpaque(false);
        editor.insertComponent(checkBox);
    }

    private void createStyles(JTextPane editor) {
        setNormal(editor.addStyle("normal", null));
        StyleConstants.setFontFamily(getNormal(), "Times New Roman");
        StyleConstants.setFontSize(getNormal(), 16);

        setHeading(editor.addStyle("heading", getNormal()));
        StyleConstants.setFontSize(getHeading(), 16);
        StyleConstants.setBold(getHeading(), true);
    }

    private void insertText(JTextPane editor, String string, Style style) throws Exception {
        Document doc = editor.getDocument();
        doc.insertString(doc.getLength(), string, style);
    }
}
