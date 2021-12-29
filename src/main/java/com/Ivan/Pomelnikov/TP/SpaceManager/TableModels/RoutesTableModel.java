package com.Ivan.Pomelnikov.TP.SpaceManager.TableModels;

import javax.swing.table.AbstractTableModel;

public class RoutesTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "id";
            case 1 -> "point A";
            case 2 -> "point B";
            case 3 -> "length";
            case 4 -> "ships";
            case 5 -> "circulation";
            default -> "not stated";
        };
    }
}
