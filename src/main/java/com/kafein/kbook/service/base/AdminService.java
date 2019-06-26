package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.AdminDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {

    AdminDTO save(AdminDTO admin);

    List<AdminDTO> findAll();

}
