package com.epam.esm.repository;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.repository.custom.TagRepository;
import com.epam.esm.repository.mapper.TagRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class TagRepositoryImpl implements TagRepository {
    private final JdbcTemplate template;
    private final TagRowMapper mapper;

    public TagRepositoryImpl(JdbcTemplate template, TagRowMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<Tag> findAll() {
        String select="SELECT *FROM db_tag;";
        return template.query(select, mapper);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        String selectById="SELECT *FROM db_tag WHERE id = ?";
        List<Tag> tags = template.query(selectById,new Object[]{id},new int[]{Types.NUMERIC},mapper);
        if(tags.isEmpty()){
            return Optional.empty();
        }
        return tags.stream().findFirst();
    }

    @Override
    public Tag save(Tag value) {
        if(Objects.isNull(value.getId())){
            String insert = "INSERT INTO db_tag(name) VALUES(?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, value.getName());
                return ps;
            }, keyHolder);
            value.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
            List<GiftCertificate> gifts = value.getGifts();
            if(gifts != null){
                String gift_tag = "INSERT INTO db_gift_certificate_tag(tag_id, gift_certificate_id) VALUES(?, ?)";
                gifts.forEach(giftCertificate -> template.update(gift_tag, value.getId(), giftCertificate.getId()));
            }
        }
        else{
            String update = "UPDATE db_tag SET name = ? WHERE id = ?";
            template.update(update, value.getName(), value.getId());
        }


        return value;
    }

    @Override
    public boolean delete(Long id) {
        String deleteById= "DELETE FROM db_tag WHERE id = ?";
        return template.update(deleteById, id) == 1;
    }
}
