package com.epam.esm.service.mapper;


import com.epam.esm.entity.Tag;
import com.epam.esm.model.TagModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagModel tagToTagModel(Tag tag);
    Tag tagModelToTag(TagModel model);
    List<TagModel> tagsToTagModels(List<Tag> tags);
    List<Tag> tagModelsToTags(List<TagModel> models);

}
