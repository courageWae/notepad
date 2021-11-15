package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewMenuEvent
{
    public static JMenuItem zoom;
    public static JMenuItem status_bar;

    ViewMenuEvent()
    {
        zoom  = Menus.viewMenu.getItem(0);
        status_bar = Menus.viewMenu.getItem(1);

        assignListeners();
    }

    public void assignListeners()
    {
        status_bar.addActionListener(new StatusBar());
        zoom.addItemListener(new Zoom());
    }


    class Zoom implements ItemListener
    {
       int fontSize = MainFrame.textAreaFontSize;
          /// continue tomorrow
        @Override
        public void itemStateChanged(ItemEvent itemEvent)
        {
            if(itemEvent.getItem().equals("Zoom"))
            {
                MainFrame.textAreaFont.deriveFont(fontSize + 2f);
                System.out.println("no");
            }

            else
            {
                System.out.println("world");
            }

        }
    }

    class StatusBar implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {

        }
    }
}
