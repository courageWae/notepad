package com.company;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.KeyEvent;

public class UndoAndRedo
{
    private Document editorPaneDocument;
    protected UndoHandler undoHandler = new UndoHandler();
    protected static UndoManager undoManager = new UndoManager() ;
    public static UndoAction undoAction = new UndoAction();
    public static RedoAction redoAction = new RedoAction();


    private void assignClasses()
    {
        editorPaneDocument = MainFrame.textArea.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);

        KeyStroke undoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.META_MASK);
        KeyStroke redoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.META_MASK);

        undoAction = new UndoAction();
        MainFrame.textArea.getInputMap().put(undoKeystroke, "undoKeystroke");
        MainFrame.textArea.getActionMap().put("undoKeystroke", undoAction);

        redoAction = new RedoAction();
        MainFrame.textArea.getInputMap().put(redoKeystroke, "redoKeystroke");
        MainFrame.textArea.getActionMap().put("redoKeystroke", redoAction);
    }

}
