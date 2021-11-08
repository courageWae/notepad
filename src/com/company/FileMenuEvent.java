package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class FileMenuEvent
{
    public static JMenuItem New ;
    public static JMenuItem newWindow;
    public static JMenuItem open;
    public static JMenuItem save;
    public static JMenuItem saveAs;
    public static JMenuItem print;
    public static JMenuItem exit;

    FileMenuEvent()
    {
        New= Menus.fileMenu.getItem(0);
        newWindow = Menus.fileMenu.getItem(1);
        open = Menus.fileMenu.getItem(2);
        save = Menus.fileMenu.getItem(3);
        saveAs = Menus.fileMenu.getItem(4);
        print = Menus.fileMenu.getItem(5);
        exit = Menus.fileMenu.getItem(6);

        assignListeners();
    }

    public void assignListeners()
    {
        New.addActionListener(new New());
        newWindow.addActionListener(new NewWindow());
        open.addActionListener(new Open());
        save.addActionListener(new Save());
        saveAs.addActionListener(new SaveAs());
        print.addActionListener(new Print());
        exit.addActionListener(new Exit());
    }

    /*
    * Action listener for the Menu item "new"
     */

    class New implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(!MainFrame.textArea.getText().equals(""))
                if(JOptionPane.showConfirmDialog(new JFrame(),"Do you want to save changes to this file ?") == JOptionPane.YES_OPTION)
                    fileSave();
        }
    }

    /*
     * Action listener for the Menu item "new window"
     */

    class NewWindow implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            new MainFrame();
        }
    }

    /*
     * Action listener for the Menu item "new window"
     */

    class Open implements ActionListener
    {
        private File file ;
        private JFileChooser fileChooser;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            this.fileChooser = new JFileChooser();
            String intialString, stringToDisplay = "" ;

            if(this.fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION)
            {
                this.file = this.fileChooser.getSelectedFile();
                String pathToFile = this.file.getPath();
                try
                {
                    BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
                    while( (intialString = reader.readLine()) != null)
                       stringToDisplay += intialString + "\n" ;

                    MainFrame.textArea.setText(stringToDisplay);

                    reader.close();
                }
                catch(Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }

    }

    class Save implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(! MainFrame.textArea.getText().equals(""))
                fileSave();
        }
    }

    class SaveAs implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(! MainFrame.textArea.getText().equals(""))
                fileSave();
        }
    }

    class Print implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            File file = new File("default.txt");
            try
            {
                Desktop desktop = Desktop.getDesktop();
                BufferedWriter writer= new BufferedWriter(new FileWriter(file));
                writer.write(MainFrame.textArea.getText());

                desktop.print(file);
                writer.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Sorry the file cannot be found.");
            }
        }
    }

    class Exit implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            System.exit(0);
        }
    }

    private void fileSave()
    {
        JFileChooser saveFile = new JFileChooser();
        saveFile.showSaveDialog(new JFrame());
        File file = saveFile.getSelectedFile();

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(MainFrame.textArea.getText());
            writer.close();
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog(new JFrame(), "The file can not be saved. Try again");
        }
    }

}
