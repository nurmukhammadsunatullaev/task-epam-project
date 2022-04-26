package com.epam.esm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GiftCertificateModel {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private Date createDate;
    private Date lastUpdateDate;
}
