package com.company;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static com.sun.org.apache.xml.internal.resolver.Catalog.URI;

public class EditMenuEvent
{
    public static JMenuItem undo;
    public static JMenuItem cut;
    public static JMenuItem copy;
    public static JMenuItem paste;
    public static JMenuItem delete;
    public static JMenuItem search_with_google;
    public static JMenuItem find;
    public static JMenuItem find_Next;
    public static JMenuItem find_previous;
    public static JMenuItem Replace;
    public static JMenuItem select_all;
    public static JMenuItem date_time;

    EditMenuEvent()
    {
        undo = Menus.editMenu.getItem(0);
        cut = Menus.editMenu.getItem(1);
        copy = Menus.editMenu.getItem(2);
        paste = Menus.editMenu.getItem(3);
        delete = Menus.editMenu.getItem(4);
        search_with_google = Menus.editMenu.getItem(5);
        find = Menus.editMenu.getItem(6);
        find_Next = Menus.editMenu.getItem(7);
        find_previous = Menus.editMenu.getItem(8);
        Replace = Menus.editMenu.getItem(9);
        select_all = Menus.editMenu.getItem(10);
        date_time = Menus.editMenu.getItem(11);

        assignListeners();
    }

    public void assignListeners()
    {
        undo.addActionListener(new Undo());
        cut.addActionListener(new Cut());
        paste.addActionListener(new Paste());
        copy.addActionListener(new Copy());
        delete.addActionListener(new Delete());
        search_with_google.addActionListener(new Search_with_Google());
        find.addActionListener(new Find());
    }

    class Undo implements ActionListener
    {
        private String newText = "";

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            getRecentCharacter();

        }

        public void getRecentCharacter()
        {
            String recentCharacter = MainFrame.textArea.getText();
            for(int i=0; i<recentCharacter.length()-1; i++)
            {
                newText += recentCharacter.charAt(i);
            }
            MainFrame.textArea.setText(newText);
            newText = "";
        }

    }

    class Cut implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            MainFrame.textArea.cut();
        }
    }

    class Copy implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            MainFrame.textArea.copy();
        }
    }

    class Paste implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            MainFrame.textArea.paste();
        }
    }

    class Delete implements ActionListener
    {
        private String originalText ;
        private String selectedText ;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            selectedText = MainFrame.textArea.getSelectedText();
            originalText = MainFrame.textArea.getText();
            String newText = originalText.replace(selectedText, "");
            MainFrame.textArea.setText(newText);
        }
    }

    class Search_with_Google implements ActionListener
    {

        private String selectedText ;
        private Desktop desktop;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            selectedText = MainFrame.textArea.getSelectedText();
            String urlLink = "https://www.google.com/search?q=" + selectedText;
            URL url = null;
            try
            {
                url = new URL(urlLink);
                openWebpage(url);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }

        public boolean openWebpage(java.net.URI uri) {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try
                {
                    desktop.browse(uri);
                    return true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return false;
        }

        public boolean openWebpage(URL url) {
            try
            {
                return openWebpage(url.toURI());
            }
            catch (URISyntaxException e)
            {
                e.printStackTrace();
            }
            return false;
        }
    }

    class Find implements ActionListener
    {
        private String mainText;
        private String wordToFind;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            mainText = MainFrame.textArea.getText();
            wordToFind = JOptionPane.showInputDialog("Word to find");

            DefaultHighlighter highLighter = new DefaultHighlighter();

            String newText = mainText.replace(wordToFind, wordToFind.);
            MainFrame.textArea.setText(newText);

        }

    }



}
