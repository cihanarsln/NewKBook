package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.BookTypeDTO;
import com.kafein.kbook.model.BookType;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookTypeMapper {

    @Named("toBookType")
    BookType toBookType(BookTypeDTO bookTypeDTO);

    @Named("toBookTypeDTO")
    BookTypeDTO toBookTypeDTO(BookType bookType);

    @IterableMapping(qualifiedByName = "toBookType")
    List<BookType> toBookTypeList(List<BookTypeDTO> bookTypeDTOList);

    @IterableMapping(qualifiedByName = "toBookTypeDTO")
    List<BookTypeDTO> toBookTypeDTOList(List<BookType> bookTypeList);



}
