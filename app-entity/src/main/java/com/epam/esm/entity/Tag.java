package com.epam.esm.entity;

import com.epam.esm.entity.base.Base;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tag extends Base {
    private List<GiftCertificate> gifts;
}
