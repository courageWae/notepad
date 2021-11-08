package com.company;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction
{

    public UndoAction()
    {
        super("Undo");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        try
        {
            UndoAndRedo.undoManager.undo();
        }
        catch (CannotUndoException ex)
        {
            // TODO deal with this
            //ex.printStackTrace();
        }
        update();
        UndoAndRedo.Redo.update();
    }

    protected void update()
    {
        if (UndoAndRedo.undoManager.canUndo())
        {
            setEnabled(true);
            putValue(Action.NAME, UndoAndRedo.undoManager.getUndoPresentationName());
        }
        else
        {
            setEnabled(false);
            putValue(Action.NAME, "Undo");
        }
    }
}
