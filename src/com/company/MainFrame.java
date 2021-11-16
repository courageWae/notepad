package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrame extends JFrame {

    private static JMenuBar menuBar;
    public static JTextArea textArea;
    public static int textAreaFontSize;
    public static Font textAreaFont;
    public static JPanel footerPanel;
    public static String title = "Untitled -Chalkboard";

    MainFrame()
    {
        textAreaFontSize = 20;
        frameSettings();
        setJMenuBar(menuBar());
        getContentPane().add(BorderLayout.CENTER, textArea());
        getContentPane().add(BorderLayout.SOUTH, footerPanel());

        setSize(1250, 870);
        new FileMenuEvent();
        new EditMenuEvent();
        new FormatMenuEvent();
        new ViewMenuEvent();

        setVisible(true);
    }


    public void frameSettings()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Untitled -Chalkboard");
    }


    private static JMenuBar menuBar()
    {
        menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(Menus.fileMenu());
        menuBar.add(Menus.editMenu());
        menuBar.add(Menus.formatMenu());
        menuBar.add(Menus.viewMenu());
        menuBar.add(Menus.helpMenu());
        return menuBar;
    }

    private static JScrollPane textArea()
    {
        textAreaFont = new Font("arial", Font.PLAIN, textAreaFontSize);
        textArea = new JTextArea();
        JScrollPane scroller = new JScrollPane(textArea);
        textArea.requestFocus();
        textArea.setFont(textAreaFont);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroller;
    }

    private static JPanel footerPanel()
    {
        footerPanel = new JPanel();
        Font font = new Font("arial", Font.PLAIN, 17);

        MatteBorder border = new MatteBorder(0, 1, 0, 0, Color.gray);

        String textString = "   Ln "+ countColumnsAndLines()[0]+", " +"Col " + countColumnsAndLines()[1]+" ";
        JLabel lineAndColumn = new JLabel(textString);
        JLabel fontCode = new JLabel("   UTF-8   ");
        JLabel percentage = new JLabel("   120%   ");
        JLabel win = new JLabel("   Windows (CRLF)   ");

        lineAndColumn.setFont(font);
        lineAndColumn.setBorder(border);

        fontCode.setFont(font);
        fontCode.setBorder(border);

        percentage.setFont(font);
        percentage.setBorder(border);

        win.setFont(font);
        win.setBorder(border);

        footerPanel.add(lineAndColumn);
        footerPanel.add(percentage);
        footerPanel.add(win);
        footerPanel.add(fontCode);

        return footerPanel;
    }


    private static int[] countColumnsAndLines()
    {
        int columns = MainFrame.textArea.getText().length() + 1;
        int lines = MainFrame.textArea.getLineCount();
        int [] columnsAndLines = {lines, columns};

        return columnsAndLines;

    }






}
