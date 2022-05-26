package com.epam.esm.repository;

import com.epam.esm.entity.Tag;
import com.epam.esm.repository.custom.TagRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagRepositoryImpl implements TagRepository {

    public TagRepositoryImpl() {

    }

    @Override
    public List<Tag> findAll() {
       return null;
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return null;
    }

    @Override
    public Tag save(Tag value) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }
}
