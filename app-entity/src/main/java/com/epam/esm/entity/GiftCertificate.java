package com.epam.esm.entity;


import com.epam.esm.entity.audit.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class GiftCertificate  extends AuditableEntity {
    private String description;
    private Double price;
    private Integer duration;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "gifts_tags",
            joinColumns = {@JoinColumn(name = "gift_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;
}
