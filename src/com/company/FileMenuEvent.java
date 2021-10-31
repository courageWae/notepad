package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import com.company.Menus;
import com.company.MainFrame;
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
        this.New= Menus.fileMenu.getItem(0);
        this.newWindow = Menus.fileMenu.getItem(1);
        this.open = Menus.fileMenu.getItem(2);
        this.save = Menus.fileMenu.getItem(3);
        this.saveAs = Menus.fileMenu.getItem(4);
        this.print = Menus.fileMenu.getItem(5);
        this.print = Menus.fileMenu.getItem(6);

        assignListeners();
    }

    public void assignListeners()
    {
        this.New.addActionListener(new New());
        this.newWindow.addActionListener(new NewWindow());
        this.open.addActionListener(new Open());
        this.save.addActionListener(new Save());
        this.saveAs.addActionListener(new SaveAs());
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
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            JFileChooser fileChooser = new JFileChooser();
            String intialString, stringToDisplay = "" ;
            if(fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION)
            {
                String pathToFile = fileChooser.getSelectedFile().getPath();
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
            JFileChooser saveFile = new JFileChooser();
            saveFile.showSaveDialog(new JFrame());
            String text = MainFrame.textArea.getText();
            //if(!text.equals(""))
        }
    }

    class SaveAs implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {

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
            JOptionPane.showMessageDialog(new JFrame(), "The file can not be save. Try again");
        }
    }

}
