package com.company;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class EditMenu
{
    public static JMenuItem undo;
    public static JMenuItem cut;
    public static JMenuItem copy;
    public static JMenuItem past;
    public static JMenuItem delete;
    public static JMenuItem search_with_google;
    public static JMenuItem find;
    public static JMenuItem find_Next;
    public static JMenuItem find_previous;
    public static JMenuItem Replace;
    public static JMenuItem select_all;
    public static JMenuItem date_time;

    EditMenu()
    {
        undo.addActionListener(new Undo());

    }

    class Undo implements ActionListener
    {
        private Document editorPaneDocument;
        protected UndoHandler undoHandler = new UndoHandler();
        protected UndoManager undoManager = new UndoManager();
        private UndoAction undoAction = null;
        //private RedoAction redoAction = null;

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {

        }

        private void assignClass()
        {
            editorPaneDocument = MainFrame.textArea.getDocument();
            editorPaneDocument.addUndoableEditListener(undoHandler);

            KeyStroke undoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.META_MASK);
            KeyStroke redoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.META_MASK);

            undoAction = new UndoAction();
            MainFrame.textArea.getInputMap().put(undoKeystroke, "undoKeystroke");
            MainFrame.textArea.getActionMap().put("undoKeystroke", undoAction);
        }
    }







}
