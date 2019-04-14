package com.company.view.mainpanel;

import com.company.model.account.Data;
import com.company.view.button.exercise.ExerciseButton;
import com.company.view.button.help.HelpButton;
import com.company.view.button.home.HomeButton;
import com.company.view.button.note.NoteButton;
import com.company.view.button.user.UserButton;
import com.company.view.statistic.Statistic;
import com.company.view.text.help.Help;
import com.company.view.text.note.Note;
import com.company.view.trainingpanel.TrainingPanel;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainPanel extends JFrame {

    public MainPanel(Data data) {
        super("Gym");
        setPreferredSize(new Dimension(300, 500));
        setMinimumSize(new Dimension(300, 500));
        setMaximumSize(new Dimension(400, 600));
        getMainPanel(data);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private MainPanel getMainPanel(Data data) {
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new GridBagLayout());

        setJMenuBar(new Menu().MainMenu(this));
        ExerciseButton exercise = new ExerciseButton();
        UserButton user = new UserButton(data);
        NoteButton note = new NoteButton();
        HomeButton home = new HomeButton();
        HelpButton help = new HelpButton();

        panel.add(exercise, exercise.GBCExercise());
        exercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data.getCounter(data.getLogin(), data);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(new JPanel(), "Ваш прогресс будет сохраняться в файле \"of_"
                            + data.getLogin() + ".txt\"\nВ папке \"statistic\"", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
                }
                TrainingPanel tr = new TrainingPanel(data);
                tr.setVisible(true);
                setVisible(false);
                home.getHomeButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        data.setElementDayTrain(0);
                        tr.setVisible(false);
                        setVisible(true);
                    }
                });
            }
        });

        panel.add(user, user.GBCUser());
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                try {
                    counter = data.getCounter(data.getLogin(), data);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(new JPanel(), "У вас нет пройденных дней!",
                            "Предупреждение!", JOptionPane.INFORMATION_MESSAGE);
                }
                if (counter != 0) {
                    final Statistic statistic = new Statistic(data, counter);
                    statistic.pack();
                    RefineryUtilities.centerFrameOnScreen(statistic);
                    statistic.repaint();
                    statistic.revalidate();
                    statistic.setVisible(true);
                }
            }
        });
        setVisible(true);

        panel.add(note, note.GBCNote());
        note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Note n = new Note();
                n.setVisible(true);
                home.getHomeButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(true);
                        n.setVisible(false);
                    }
                });
            }
        });

        panel.add(home.getHomeButton(), home.GBCHome());

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

        return this;
    }
}