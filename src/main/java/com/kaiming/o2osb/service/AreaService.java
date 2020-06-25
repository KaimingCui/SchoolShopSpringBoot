package com.kaiming.o2osb.service;

import com.kaiming.o2osb.entity.Area;

import java.util.List;

public interface AreaService {

    public static final String AREALISTKEY = "arealist";


    List<Area> getAreaList();
}
