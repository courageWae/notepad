package com.company;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

public class UndoHandler implements UndoableEditListener
{
    @Override
    public void undoableEditHappened(UndoableEditEvent undoableEditEvent)
    {
        UndoAndRedo.undoManager.addEdit(undoableEditEvent.getEdit());
        UndoAndRedo.undoAction.update();
        UndoAndRedo.redoAction.update();
    }
}
