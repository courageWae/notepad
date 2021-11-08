package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static JMenuBar menuBar;
    public static JEditorPane textArea;
    public static JPanel footerPanel;
    public static String title = "Untitled -Chalkboard";

    MainFrame()
    {
        frameSettings(title);
        setJMenuBar(menuBar());
        getContentPane().add(BorderLayout.CENTER, textArea());
        getContentPane().add(BorderLayout.SOUTH, footerPanel());

        setSize(1250, 870);

        new FileMenuEvent();
        new EditMenuEvent();
        setVisible(true);

    }


    public void frameSettings( String title)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(title);
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
        textArea = new JEditorPane();
        JScrollPane scroller = new JScrollPane(textArea);
        textArea.requestFocus();
        //textArea.setLineWrap(true);
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
