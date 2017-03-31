package com.myfirstweb.Service;

import com.myfirstweb.Repository.RoleRepository;
import com.myfirstweb.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void insertRole(Role role)
    {
       roleRepository.save(role);
    }
}
