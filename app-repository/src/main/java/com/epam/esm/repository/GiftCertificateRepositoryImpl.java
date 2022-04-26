package com.epam.esm.repository;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.repository.custom.GiftCertificateRepository;
import com.epam.esm.repository.mapper.GiftCertificateRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class GiftCertificateRepositoryImpl implements GiftCertificateRepository {
    private final JdbcTemplate template;
    private final GiftCertificateRowMapper mapper;

    public GiftCertificateRepositoryImpl(JdbcTemplate template, GiftCertificateRowMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<GiftCertificate> findAll() {
        String select="SELECT *FROM db_gift_certificate;";
        return template.query(select, mapper);
    }

    @Override
    public Optional<GiftCertificate> findById(Long id) {
        String selectById="SELECT *FROM db_gift_certificate WHERE id = ?";
        List<GiftCertificate> gifts = template.query(selectById,new Object[]{id},new int[]{Types.NUMERIC},mapper);
        if(gifts.isEmpty()){
            return Optional.empty();
        }
        return gifts.stream().findFirst();
    }

    @Override
    public GiftCertificate save(GiftCertificate value) {
        String insert = "INSERT INTO db_gift_certificate(name, description, price, duration, create_date, last_update_time) VALUES(?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getName());
            ps.setString(2, value.getDescription());
            ps.setDouble(3, value.getPrice());
            ps.setInt(4, value.getDuration());
            ps.setDate(5, new Date(value.getCreateDate().getTime()));
            ps.setDate(6, new Date(value.getLastUpdateDate().getTime()));
            return ps;
        }, keyHolder);
        value.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return value;
    }

    @Override
    public boolean delete(Long id) {
        String deleteById= "DELETE FROM db_gift_certificate WHERE id = ?";
        return template.update(deleteById,new Object[] {id}) == 1;
    }
}
