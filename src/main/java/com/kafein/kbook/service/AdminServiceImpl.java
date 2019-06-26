package com.kafein.kbook.service;

import com.kafein.kbook.dto.AdminDTO;
import com.kafein.kbook.mapper.AdminMapper;
import com.kafein.kbook.repository.AdminRepository;
import com.kafein.kbook.service.base.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminDTO save(AdminDTO admin) {
        return adminMapper.toAdminDTO(adminRepository.save(adminMapper.toAdmin(admin)));
    }

    @Override
    public List<AdminDTO> findAll() {
        return adminMapper.toAdminDTOList(adminRepository.findAll());
    }

    @Override
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }


}
