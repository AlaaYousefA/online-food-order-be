package com.foodorder.backend.persistence.jpa;

import com.foodorder.backend.domain.model.SysUser;
import com.foodorder.backend.persistence.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserJpaRepository extends JpaRepository<SysUserEntity, Long> {
    Optional<SysUserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
