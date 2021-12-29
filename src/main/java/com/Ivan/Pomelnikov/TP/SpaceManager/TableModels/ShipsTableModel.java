package com.Ivan.Pomelnikov.TP.SpaceManager.TableModels;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ShipsDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ShipsService;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ShipsTableModel extends AbstractTableModel {

    private ShipsService shipsService;

    public ShipsTableModel (ShipsService shipsService){
        this.shipsService = shipsService;
    }

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
        List<ShipsEntity> shipsEntityList = shipsService.findAll();
        System.out.println(shipsEntityList.get(0).getModel());
        ShipsDto shipsDto = new ShipsDto();
        return switch (columnIndex){
            case 0 -> shipsDto.getId();
            case 1 -> shipsDto.getModel();
            case 2 -> shipsDto.getTimeOnRoute();
            case 3 -> shipsDto.getCirculation();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
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
