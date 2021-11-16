package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewMenuEvent
{
    public static JMenu zoom;
    public static JMenuItem zoom_in;
    public static JMenuItem zoom_out;
    public static JMenuItem status_bar;
    private static int fontSize;

    ViewMenuEvent()
    {
        zoom  = (JMenu) Menus.viewMenu.getItem(0);
        zoom_in = zoom.getItem(0);
        zoom_out = zoom.getItem(1);
        status_bar = Menus.viewMenu.getItem(1);

        fontSize = MainFrame.textAreaFontSize;

        assignListeners();
    }

    public void assignListeners()
    {
        status_bar.addActionListener(new StatusBar());
        zoom_in.addActionListener(new ZoomIn());
        zoom_out.addActionListener(new ZoomOut());
    }


    class ZoomIn implements ActionListener
    {

       @Override
       public void actionPerformed(ActionEvent actionEvent)
       {
           MainFrame.textArea.setFont(new Font("arial", Font.PLAIN, fontSize+3));
           fontSize = fontSize + 3;
       }

    }

    class ZoomOut implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            MainFrame.textArea.setFont(new Font("arial", Font.PLAIN, fontSize-3));
            fontSize = fontSize - 3;

        }

    }

    class StatusBar implements ActionListener
    {
        private JPanel footerPanel = MainFrame.footerPanel;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(footerPanel.isVisible())
            {
                status_bar.setIcon(new ImageIcon(" "));
                footerPanel.setVisible(false);
            }
            else
            {
                status_bar.setIcon(new ImageIcon("C:/Users/cahorttor/Desktop/check.png"));
                footerPanel.setVisible(true);
            }



        }
    }
}
