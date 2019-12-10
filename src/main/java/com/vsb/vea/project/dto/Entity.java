package com.vsb.vea.project.dto;

public interface Entity {
    public void setId(long id);
    public long getId();
    public void merge(Entity e);
}
