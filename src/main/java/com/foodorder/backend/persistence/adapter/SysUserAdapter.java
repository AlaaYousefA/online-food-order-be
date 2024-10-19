package com.foodorder.backend.persistence.adapter;

import com.foodorder.backend.application.exception.ResourceNotFoundException;
import com.foodorder.backend.domain.mappers.SysUserMapper;
import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.jpa.SysUserJpaRepository;
import com.foodorder.backend.persistence.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SysUserAdapter implements SysUserRepository {
    private final SysUserJpaRepository sysUserJpaRepository;
    private final SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserById(Long id) {
        return sysUserMapper.entityToModel(sysUserJpaRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("id not found : " + id)
        ));
    }

    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserMapper.entityToModel(sysUserJpaRepository.save(sysUserMapper.modelToEntity(sysUser)));
    }
}
