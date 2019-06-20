package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.BookTypeDTO;
import com.kafein.kbook.model.BookType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookTypeService {

    BookType save(BookTypeDTO bookType);

    List<BookTypeDTO> findAll();

    List<BookTypeDTO> findByName(String name);

}
