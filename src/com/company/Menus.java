package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Menus {

    // Menu items;

    public static JMenu fileMenu()
    {
        String [] menuItems = {"New", "New Window", "Open...", "Save", "Save As...", "Print", "Exit"};
        JMenu fileMenu = new JMenu("File");

        for(String menuItem : menuItems)
        {
            fileMenu.add(new JMenuItem(menuItem));
        }
        return fileMenu;
    }

    public static JMenu editMenu()
    {
        String [] menuItems = {"Undo", "Cut", "Copy", "Past", "Delete", "Search with Google", "Find", "Find Next", "Find Previous", "Replace", "Select All", "Date/Time"};
        JMenu editMenu = new JMenu("Edit");
        for(String menuItem : menuItems)
        {
            editMenu.add(new JMenuItem(menuItem));
        }
        return editMenu;
    }

    public static JMenu formatMenu()
    {
        JMenu formatMenu = new JMenu("Format");
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

        JMenu viewMenu = new JMenu("View");
        JMenuItem StatusBar = new JMenuItem("Status Bar");

        viewMenu.add(Zoom);
        viewMenu.add(StatusBar);

        return viewMenu;
    }

}
