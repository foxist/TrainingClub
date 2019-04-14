package com.company.view.button.start;

import com.company.model.account.Data;
import com.company.view.exercise.Exercise;
import com.company.view.training.Training;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Start extends JDialog {
    private Style heading = null, normal = null;
    private Data data;

    public Start(Training tr, Data data) throws Exception {
        super(new JFrame(), "Day " + tr.getFlag(), true);
        setPreferredSize(new Dimension(300, 250));
        setMaximumSize(new Dimension(300, 250));
        setMinimumSize(new Dimension(300, 250));
        setLocationRelativeTo(null);
        this.data = data;
        setLayout(new BorderLayout());
        getStart(tr);
    }

    public void setHeading(Style heading) {
        this.heading = heading;
    }

    public void setNormal(Style normal) {
        this.normal = normal;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Style getHeading() {
        return heading;
    }

    public Style getNormal() {
        return normal;
    }

    public Data getData() {
        return data;
    }

    private void getStart(Training tr) throws Exception {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JTextPane text = new JTextPane();
        JButton start = new JButton("Start");
        start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        start.setPreferredSize(new Dimension(200, 60));
        start.setMinimumSize(new Dimension(200, 60));
        start.setMaximumSize(new Dimension(200, 60));

        createStyles(text);
        insertText(text, data.getDay(tr), getHeading());
        //insertText(text, new InformUser().getExerciseOfTrainingDay(tr), getHeading());
        StyledDocument doc = text.getStyledDocument();
        text.setCaretPosition(doc.getLength());

        add(text, BorderLayout.NORTH);
        panel.add(start, new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                int count = 0;
                Exercise exercise = null;
                if (!getData().getTrueFalse(tr.getFlag() - 1) && getData().getCheck(tr.getFlag() - 1) != 0) {
                    try {
                        exercise = new Exercise(tr, getData().getCheck(tr.getFlag() - 1), 0, true, data);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Не удается найти указанный путь к файлу " +
                                        "\"C:/Users/zayil/ideaProjects/Gym/Resources/exercise/exercises.txt\"",
                                "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        getData().getCounter(getData().getLogin(), getData());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Файл \"of_" + data.getLogin() + ".txt\" " +
                                "будет создан, после выполнения хотя бы 1 упражнения!", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    try {
                        exercise = new Exercise(tr,0, 0, true, data);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Не удается найти указанный путь к файлу " +
                                        "\"C:/Users/zayil/ideaProjects/Gym/Resources/exercise/exercises.txt\"",
                                "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                exercise.setVisible(true);
                for (int i = 0; i < exercise.getCheckBox().length; i++)
                    count = exercise.getCheck(i);

                if (count == exercise.getCheckBox().length) {
                    JOptionPane.showMessageDialog(panel, "" + Integer.toString(tr.getFlag()) + " День пройден! Вам открыт следующий день!",
                            "Day " + Integer.toString(tr.getFlag()), JOptionPane.INFORMATION_MESSAGE);
                    tr.setBackground(Color.GREEN);
                    getData().setCheckBox(count);
                    getData().setTrue(tr.getFlag() - 1);
                    try {
                        getData().setDayCheckBox(getData().getLogin(), getData().getDayTrain(), getData().getCheckBox(),
                                getData().getTrueFalse(tr.getFlag() - 1));
                        getData().getCounter(getData().getLogin(), getData());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Данный файл не существует!\nРезультаты не сохранены!",
                                "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                    getData().setDayTrain();
                    getData().setCheckBox(0);
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "Данный день, пройден не до конца",
                            "Предупреждение!", JOptionPane.ERROR_MESSAGE);
                    getData().setCheckBox(count);
                    try {
                        getData().setDayCheckBox(getData().getLogin(), getData().getDayTrain(), getData().getCheckBox(),
                                getData().getTrueFalse(tr.getFlag() - 1));
                        getData().getCounter(getData().getLogin(), getData());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Данный файл не существует!\nРезультаты не сохранены!",
                                "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(panel, BorderLayout.CENTER);
    }

    private void createStyles(JTextPane editor) {
        setNormal(editor.addStyle("normal", null));
        StyleConstants.setFontFamily(getNormal(), "Times New Roman");
        StyleConstants.setFontSize(getNormal(), 16);

        setHeading(editor.addStyle("heading", getNormal()));
        StyleConstants.setFontSize(getHeading(), 24);
        StyleConstants.setBold(getHeading(), true);
    }

    private void insertText(JTextPane editor, String string, Style style) {
        try {
            Document doc = editor.getDocument();
            doc.insertString(doc.getLength(), string, style);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
