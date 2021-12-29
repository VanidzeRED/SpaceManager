package com.Ivan.Pomelnikov.TP.SpaceManager.TableModels;

import javax.swing.table.AbstractTableModel;

public class ModelTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "name";
            case 1 -> "payload";
            case 2 -> "max route";
            case 3 -> "speed";
            default -> "not stated";
        };
    }
}
