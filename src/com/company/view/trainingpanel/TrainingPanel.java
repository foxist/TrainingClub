package com.company.view.trainingpanel;

import com.company.model.account.Data;
import com.company.view.button.home.HomeButton;
import com.company.view.button.start.Start;
import com.company.view.exercise.Exercise;
import com.company.view.training.Training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TrainingPanel extends JFrame {

    public TrainingPanel(Data data) {
        super("Exercises");
        setPreferredSize(new Dimension(300, 500));
        setMinimumSize(new Dimension(300, 500));
        setMaximumSize(new Dimension(300, 500));
        setLocationRelativeTo(null);
        getTrainingPanel(data);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private TrainingPanel getTrainingPanel(Data data) {
        JPanel panel = new JPanel();
        add(panel);
        panel.setPreferredSize(new Dimension(230, 820));
        panel.setMaximumSize(new Dimension(230, 866));
        panel.setMinimumSize(new Dimension(230, 500));

        ArrayList<Training> day = new ArrayList<>();
        JLabel week[] = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            week[i] = new JLabel("           " + (i + 1) + " WEEK OF TRAINING");
            week[i].setFont(new Font("Times New Roman", Font.BOLD, 14));
            week[i].setPreferredSize(new Dimension(230, 20));
            week[i].setMaximumSize(new Dimension(230, 20));
            week[i].setMinimumSize(new Dimension(230, 20));
        }

        int j = 0;
        for (int i = 0; i < 40; i++) {
            if (i % 4 == 0)
                panel.add(week[j++], BorderLayout.EAST);

            Training tr = new Training((i + 1) + "", i + 1);
            if (data.getDay(i) >= i + 1 && data.getTrueFalse(i)) {
                data.setDayTrain();
                tr.setBackground(Color.GREEN);
            }
            if ((data.getDay(data.getDayTrain()) != 0 && data.getCheck(data.getDayTrain()) != 0) && data.getTrueFalse(data.getDayTrain()))
                data.setCheckBox(data.getCheck(i));

            day.add(tr);
            panel.add(day.get(i), BorderLayout.SOUTH);
            day.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Training tr = (Training) e.getSource();
                    if (tr.getFlag() - data.getDayTrain() > 1) {
                        JOptionPane.showMessageDialog(new JPanel(), "Данный день, закрыт!",
                                "Предупреждение!", JOptionPane.ERROR_MESSAGE);
                    } else if (data.getTrueFalse(tr.getFlag() - 1)) {
                        try {
                            Exercise exercise = new Exercise(tr, data.getCheckBox(), 1, true, data);
                            exercise.setVisible(true);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(new JPanel(), "Не удается найти указанный путь к файлу " +
                                            "\"C:/Users/zayil/ideaProjects/Gym/Resources/exercise/exercises.txt\"",
                                    "Ошибка!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        try {
                            new Start(tr, data).setVisible(true);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(new JPanel(), "Не удается найти указанный путь к файлу " +
                                            "\"C:/Users/zayil/ideaProjects/Gym/Resources/exercise/exercises.txt\"",
                                    "Ошибка!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        HomeButton home = new HomeButton();
        panel1.add(home.getHomeButton(), home.GBCHome());
        add(panel1, BorderLayout.SOUTH);

        return this;
    }
}