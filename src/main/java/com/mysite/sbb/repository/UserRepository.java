package com.mysite.sbb.repository;

import com.mysite.sbb.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

}
