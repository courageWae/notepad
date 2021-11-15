package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatMenuEvent
{
    public static JMenuItem word_wrap;
    public static JMenuItem font;


    FormatMenuEvent()
    {
        word_wrap = Menus.formatMenu.getItem(0);
        font = Menus.formatMenu.getItem(1);

        assignListeners();
    }

    private void assignListeners()
    {
        word_wrap.addActionListener(new WordWrap());
        font.addActionListener(new Font());
    }

    public class WordWrap implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(MainFrame.textArea.getLineWrap())
            {
                MainFrame.textArea.setLineWrap(false);
                word_wrap.setIcon(new ImageIcon(" "));
            }
            else
            {
                MainFrame.textArea.setLineWrap(true);
                word_wrap.setIcon(new ImageIcon("C:/Users/cahorttor/Desktop/check.png"));
            }
        }
    }

    public class Font implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            JFontChooser fontChooser = new JFontChooser(new JFrame(), MainFrame.textArea.getFont());
            fontChooser.show();

            if(fontChooser.getReturnStatus() == fontChooser.RET_OK)
            {
                MainFrame.textArea.setFont(fontChooser.getFont());
            }
        }
    }
}
