package com.epam.esm.model;

import com.epam.esm.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TagModel extends BaseModel {
    private List<GiftCertificateModel> gifts;
}
