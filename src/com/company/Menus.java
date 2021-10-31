package com.company;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menus {

    public static JMenu fileMenu;
    public static JMenu editMenu;
    public static JMenu helpMenu;
    public static JMenu formatMenu;
    public static JMenu viewMenu;

    public static JMenu fileMenu()
    {
        String [] menuItems = {"New", "New Window", "Open...", "Save", "Save As...", "Print", "Exit"};
        fileMenu = new JMenu("File");

        for(String menuItem : menuItems)
        {
            fileMenu.add(new JMenuItem(menuItem));
        }
        return fileMenu;
    }

    public static JMenu editMenu()
    {
        String [] menuItems = {"Undo", "Cut", "Copy", "Past", "Delete", "Search with Google", "Find", "Find Next", "Find Previous", "Replace", "Select All", "Date/Time"};
        editMenu = new JMenu("Edit");
        for(String menuItem : menuItems)
        {
            editMenu.add(new JMenuItem(menuItem));
        }
        return editMenu;
    }

    public static JMenu formatMenu()
    {
        formatMenu = new JMenu("Format");
        JMenuItem WordWrap = new JMenuItem(new ImageIcon("C:/Users/cahorttor/Desktop/check.png"));
        WordWrap.setText("Word Wrap");
        JMenuItem Font = new JMenuItem("Font");

        formatMenu.add(WordWrap);
        formatMenu.add(Font);

        return formatMenu;
    }

    public static JMenu viewMenu()
    {
        JMenu Zoom = new JMenu("Zoom");
        // Zoom menu items
        JMenuItem ZoomIn = new JMenuItem("Zoom In");
        JMenuItem ZoomOut = new JMenuItem("Zoom Out");

        Zoom.add(ZoomIn);
        Zoom.add(ZoomOut);

        viewMenu = new JMenu("View");
        JMenuItem StatusBar = new JMenuItem(new ImageIcon("C:/Users/cahorttor/Desktop/check.png"));
        StatusBar.setText("Status Bar");

        viewMenu.add(Zoom);
        viewMenu.add(StatusBar);

        return viewMenu;
    }

    public static JMenu helpMenu()
    {
        helpMenu = new JMenu("Help");
        JMenuItem ViewHelp = new JMenuItem("View Help");
        JMenuItem SendFeedback = new JMenuItem("Send Feedback");
        JMenuItem AboutChalkBoard = new JMenuItem("About ChalkBoard");

        helpMenu.add(ViewHelp);
        helpMenu.add(SendFeedback);
        helpMenu.add(AboutChalkBoard);


        return helpMenu;
    }

}
