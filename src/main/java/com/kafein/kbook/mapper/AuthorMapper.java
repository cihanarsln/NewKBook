package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.AuthorDTO;
import com.kafein.kbook.model.Author;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Named("toAuthor")
    Author toAuthor(AuthorDTO authorDTO);

    @Named("toAuthorDTO")
    AuthorDTO toAuthorDTO(Author author);

    @IterableMapping(qualifiedByName = "toAuthor")
    List<Author> toAuthorList(List<AuthorDTO> authorDTOList);

    @IterableMapping(qualifiedByName = "toAuthorDTO")
    List<AuthorDTO> toAuthorDTOList(List<Author> authorList);

}
