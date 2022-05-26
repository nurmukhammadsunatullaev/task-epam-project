package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.model.TagModel;
import com.epam.esm.repository.custom.TagRepository;
import com.epam.esm.service.custom.TagService;
import com.epam.esm.service.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository repository;
    private final TagMapper mapper;

    @Override
    public List<TagModel> getAll(){
        return mapper.tagsToTagModels(repository.findAll());
    }


    @Override
    public Optional<TagModel> getById(Long id){
        Optional<Tag> tag = repository.findById(id);
        return tag.map(mapper::tagToTagModel);
    }

    @Override
    public TagModel save(TagModel value){
        Tag tag = mapper.tagModelToTag(value);
        tag = repository.save(tag);
        return mapper.tagToTagModel(tag);
    }

    @Override
    public boolean delete(Long id){
        return repository.delete(id);
    }
}
