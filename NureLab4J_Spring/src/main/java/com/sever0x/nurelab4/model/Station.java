package com.sever0x.nurelab4.model;

import lombok.Data;

@Data
public class Station {

    private int id;

    private String name;

    private String city;

    private String line;

    private BranchStation nextStation;

    private BranchStation prevStation;

    private BranchStation transferTo;
}
