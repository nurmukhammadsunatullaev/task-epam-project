package com.epam.esm.entity;


import com.epam.esm.entity.base.Base;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GiftCertificate  extends Base {
    private String description;
    private Double price;
    private Integer duration;
    private String createDate;
    private String lastUpdateDate;
    private List<Tag> tags;
}
