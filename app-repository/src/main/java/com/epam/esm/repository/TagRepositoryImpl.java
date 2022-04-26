package com.epam.esm.repository;

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
        String insert = "INSERT INTO db_tag(name) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getName());
            return ps;
        }, keyHolder);
        value.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return value;
    }

    @Override
    public boolean delete(Long id) {
        String deleteById= "DELETE FROM db_tag WHERE id = ?";
        return template.update(deleteById,new Object[] {id}) == 1;
    }
}
