package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.BookTypeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookTypeService {

    BookTypeDTO save(BookTypeDTO bookType);

    List<BookTypeDTO> findAll();

    List<BookTypeDTO> findByName(String name);

}
