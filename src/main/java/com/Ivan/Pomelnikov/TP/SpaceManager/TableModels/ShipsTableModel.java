package com.Ivan.Pomelnikov.TP.SpaceManager.TableModels;

import javax.swing.table.AbstractTableModel;

public class ShipsTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "id";
            case 1 -> "model";
            case 2 -> "route";
            case 3 -> "time";
            case 4 -> "circulation";
            default -> "not stated";
        };
    }
}
