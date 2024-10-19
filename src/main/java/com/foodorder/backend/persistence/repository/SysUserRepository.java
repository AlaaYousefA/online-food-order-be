package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository {
    SysUser getUserById(Long id);

    SysUser save(SysUser sysUser);
}
