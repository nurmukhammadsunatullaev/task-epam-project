package com.epam.esm.repository.mapper;

import com.epam.esm.entity.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GiftCertificateRowMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        GiftCertificate gift=new GiftCertificate();
        gift.setId(rs.getLong("id"));
        gift.setName(rs.getString("name"));
        gift.setDescription(rs.getString("description"));
        gift.setPrice(rs.getDouble("price"));
        gift.setDuration(rs.getInt("duration"));
        gift.setCreateDate(rs.getString("create_date"));
        gift.setLastUpdateDate(rs.getString("last_update_time"));
        return gift;
    }
}
