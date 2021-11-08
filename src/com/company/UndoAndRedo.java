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
    public static UndoAction Undo = new UndoAction();
    public static RedoAction Redo = new RedoAction();


    private void assignClasses()
    {
        editorPaneDocument = MainFrame.textArea.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);

        KeyStroke undoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.META_MASK);
        KeyStroke redoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.META_MASK);

        MainFrame.textArea.getInputMap().put(undoKeystroke, "undoKeystroke");
        MainFrame.textArea.getActionMap().put("undoKeystroke", Undo);

        MainFrame.textArea.getInputMap().put(redoKeystroke, "redoKeystroke");
        MainFrame.textArea.getActionMap().put("redoKeystroke", Redo);
    }

}
