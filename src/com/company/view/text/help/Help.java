package com.company.view.text.help;

import com.company.model.account.Data;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class Help extends JDialog {
    private Style heading = null, normal = null;

    public Help() throws Exception {
        super(new JFrame(), "Help", true);
        setPreferredSize(new Dimension(300, 500));
        setMaximumSize(new Dimension(300, 500));
        setMinimumSize(new Dimension(300, 500));
        setLocationRelativeTo(null);
        getHelp();
        pack();
    }

    private void getHelp() throws Exception {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JTextPane text = new JTextPane();

        createStyles(text);
        insertText(text, new Data().getString(), heading);
        StyledDocument doc = text.getStyledDocument();
        text.setCaretPosition(doc.getLength());

        getContentPane().add(new JScrollPane(text), BorderLayout.CENTER);
    }

    private void createStyles(JTextPane editor) {
        normal = editor.addStyle("normal", null);
        StyleConstants.setFontFamily(normal, "Times New Roman");
        StyleConstants.setFontSize(normal, 14);

        heading = editor.addStyle("heading", normal);
        StyleConstants.setFontSize(heading, 14);
        StyleConstants.setBold(heading, true);
    }

    private void insertText(JTextPane editor, String string, Style style) throws Exception {
        Document doc = editor.getDocument();
        doc.insertString(doc.getLength(), string, style);
    }
}
