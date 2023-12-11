package com.sever0x.nurelab4.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    @Min(0)
    private int id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String line;

    private BranchStation nextStation;

    private BranchStation prevStation;

    private BranchStation transferTo;
}
