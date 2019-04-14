package com.company.view.mainpanel;

import com.company.view.registration.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private static JMenuBar mainMenu;
    private static JMenu file;
    private static JMenu help;

    public Menu() {
        mainMenu = new JMenuBar();
        file = new JMenu("File");
        help = new JMenu("Help");
    }

    public JMenuBar MainMenu(MainPanel mainPanel) {
        getMainMenu().add(getFile(mainPanel));
        getMainMenu().add(getHelp());
        return getMainMenu();
    }

    private JMenu getFile(MainPanel mainPanel) {
        JMenuItem item = getFile().add(new JMenuItem("New", 'N'));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                mainPanel.setVisible(false);
                user.setVisible(true);
            }
        });
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        getFile().addSeparator();

        item = getFile().add(new JMenuItem("Exit", 'x'));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        return getFile();
    }

    private JMenu getHelp() {
        GetHelp().add(new JMenuItem("About", 'A')).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About().setVisible(true);
            }
        });
        return GetHelp();
    }

    public static JMenu getFile() {
        return file;
    }

    public static JMenu GetHelp() {
        return help;
    }

    public static JMenuBar getMainMenu() {
        return mainMenu;
    }

    static class About extends JDialog {
        public About() {
            super(new JFrame(), "About", true);
            setLayout(new GridBagLayout());
            setLocationRelativeTo(null);
            setSize(200, 100);
            add(new JLabel("Version 1.0"), new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                    new Insets(1, 0, 1, 1), 0, 0));

            add(new JLabel("This project by Ruslan Zainullin"), new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                    new Insets(1, 0, 1, 1), 0, 0));
        }
    }
}