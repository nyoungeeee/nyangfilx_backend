package com.gamza.nyangflix.domain.tag.service.mapper;

import com.gamza.nyangflix.domain.tag.entity.TagForCat;
import com.gamza.nyangflix.domain.tag.service.model.TagForCatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagForCatMapper {

    TagForCatMapper INSTANCE = Mappers.getMapper(TagForCatMapper.class);

    @Mapping(source = "id", target = "tagId")
    public TagForCatDto toDto(TagForCat tagForCat);

    @Mapping(source = "id", target = "tagId")
    public List<TagForCatDto> toDtoList(List<TagForCat> tagForCatList);

    @Mapping(target = "tagName")
    public TagForCat toTagForCat(TagForCatDto tagForCatDto);

}
