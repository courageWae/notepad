package com.company;

import javax.swing.*;
import java.awt.*;

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
        return footerPanel;
    }

}
