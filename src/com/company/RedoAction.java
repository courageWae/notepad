package com.company;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction
{
    public RedoAction()
    {
        super("Redo");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        try
        {
            UndoAndRedo.undoManager.redo();
        }
        catch (CannotRedoException ex)
        {
            // TODO deal with this
            ex.printStackTrace();
        }
        update();
        UndoAndRedo.undoAction.update();
    }

    protected void update()
    {
        if (UndoAndRedo.undoManager.canRedo())
        {
            setEnabled(true);
            putValue(Action.NAME, UndoAndRedo.undoManager.getRedoPresentationName());
        }
        else
        {
            setEnabled(false);
            putValue(Action.NAME, "Redo");
        }
    }


}
