package com.example.demo.dto;

public class PositionDto {
    private int positionId;
    private String positionName;

    public PositionDto() {
    }


    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
