package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.PublisherDTO;
import com.kafein.kbook.model.Publisher;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface PublisherMapper {

    @Named("toPublisher")
    Publisher toPublisher(PublisherDTO publisherDTO);

    @Named("toPublisherDTO")
    @Mapping(target = "books", ignore = true)
    PublisherDTO toPublisherDTO(Publisher publisher);

    @IterableMapping(qualifiedByName = "toPublisher")
    List<Publisher> toPublisherList(List<PublisherDTO> publisherDTOList);

    @IterableMapping(qualifiedByName = "toPublisherDTO")
    List<PublisherDTO> toPublisherDTOList(List<Publisher> publisherList);

}
