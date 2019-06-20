package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.BookDTO;
import com.kafein.kbook.model.Book;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookTypeMapper.class, PublisherMapper.class, AuthorMapper.class})
public interface BookMapper {

    @Named("toBook")
    Book toBook(BookDTO bookDTO);

    @Named("toBookDTO")
    @Mapping(target = "publishers", ignore = true)
    BookDTO toBookDTO(Book book);

    @IterableMapping(qualifiedByName = "toBook")
    List<Book> toBookList(List<BookDTO> bookDTOList);

    @IterableMapping(qualifiedByName = "toBookDTO")
    List<BookDTO> toBookDTOList(List<Book> bookList);

}
