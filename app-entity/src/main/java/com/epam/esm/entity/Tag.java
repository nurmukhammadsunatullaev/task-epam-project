package com.epam.esm.entity;

import com.epam.esm.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tag extends Base {
    @ManyToMany(fetch = FetchType.LAZY)
    private List<GiftCertificate> gifts;
}
