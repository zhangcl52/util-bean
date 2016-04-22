package com.hunter.entity;

import java.util.List;

/**
 * @author Administrator 下午11:52:08
 */
public class ExcelRow {
    // cell
    private List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Cell cell : cells) {
            sb.append(cell.getContents().equals("") ? "" : cell.getContents()).append("     ");
        }
        return sb.toString();
    }

}
