package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.PublisherDTO;
import com.kafein.kbook.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PublisherService {

    Publisher save(PublisherDTO publisherDTO);

    List<PublisherDTO> findAll();

}
