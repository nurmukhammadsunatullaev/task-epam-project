package com.epam.esm.model;

import com.epam.esm.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GiftCertificateModel extends BaseModel {

    private String description;
    private Double price;
    private Integer duration;
    private String createDate;
    private String lastUpdateDate;
    private List<TagModel> tags;
}
