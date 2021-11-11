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
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.text.*;

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
    public static JMenuItem replace;
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
        replace = Menus.editMenu.getItem(7);
        select_all = Menus.editMenu.getItem(8);
        date_time = Menus.editMenu.getItem(9);

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
        replace.addActionListener(new Replace());
        select_all.addActionListener(new SelectAll());
        date_time.addActionListener(new DateAndTime());
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

            // Creating a highlighter.
            Highlighter  highlighter = MainFrame.textArea.getHighlighter();

            // Tokenize the strings into words
            StringTokenizer newText = new StringTokenizer(mainText);
            int lengthOfSearchWord = wordToFind.length();
            while(newText.hasMoreTokens())
            {
                int indexOfSearchWord = mainText.indexOf(wordToFind);
                int endOfSearchWord =  indexOfSearchWord + lengthOfSearchWord;

                String tok = newText.nextToken();
                if(tok.equals(wordToFind))
                {
                    try
                    {
                        highlighter.addHighlight(indexOfSearchWord, endOfSearchWord, DefaultHighlighter.DefaultPainter);
                    }
                    catch (BadLocationException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Replace implements ActionListener
    {
        private JTextField find ;
        private JTextField replace ;
        private JPanel myPanel;
        private String wordToFind;
        private String wordToReplace;

        Replace()
        {
            myPanel = new JPanel();
            find = new JTextField(5);
            replace = new JTextField(5);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            myPanel.add(new JLabel("Find :"));
            myPanel.add(find);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Replace :"));
            myPanel.add(replace);

            int result = JOptionPane.showConfirmDialog(new JFrame(), myPanel, "Enter words to find and replace", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.OK_OPTION)
            {
                wordToFind = find.getText();
                wordToReplace = replace.getText();

                String newText = MainFrame.textArea.getText().replace(wordToFind,wordToReplace);
                MainFrame.textArea.setText(newText);
            }
        }

    }

    class SelectAll implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            int numberOfWords = MainFrame.textArea.getText().length();
            Highlighter highlighter = MainFrame.textArea.getHighlighter();

            try
            {
                highlighter.addHighlight(0, numberOfWords, DefaultHighlighter.DefaultPainter);
            }
            catch (BadLocationException exception)
            {
                exception.printStackTrace();
            }
        }
    }

    class DateAndTime implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            String text =  MainFrame.textArea.getText();
            Date date = new Date();
            String newText = text + date.toString();

            MainFrame.textArea.setText(newText);

        }

    }







}
