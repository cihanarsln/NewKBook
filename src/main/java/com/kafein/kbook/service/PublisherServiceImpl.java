package com.kafein.kbook.service;

import com.kafein.kbook.dto.PublisherDTO;
import com.kafein.kbook.mapper.PublisherMapper;
import com.kafein.kbook.service.base.PublisherService;
import com.kafein.kbook.model.Publisher;
import com.kafein.kbook.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public Publisher save(PublisherDTO publisherDTO) {
        return publisherRepository.save(publisherMapper.toPublisher(publisherDTO));
    }

    @Override
    public List<PublisherDTO> findAll() {
        return publisherMapper.toPublisherDTOList(publisherRepository.findAll());
    }
}
