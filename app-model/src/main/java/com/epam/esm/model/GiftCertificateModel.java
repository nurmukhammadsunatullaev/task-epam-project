package com.epam.esm.model;

import com.epam.esm.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GiftCertificateModel extends BaseModel {

    private String description;
    private Double price;
    private Integer duration;
    private Date createDate;
    private Date lastUpdateDate;
}
