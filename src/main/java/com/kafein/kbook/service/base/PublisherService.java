package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.PublisherDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PublisherService {

    PublisherDTO save(PublisherDTO publisherDTO);

    List<PublisherDTO> findAll();

}
