package com.krishn157.mobileappws.io.repositories;

import com.krishn157.mobileappws.io.entity.UserEntity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    // Query Methods - follow the naming conventions strictly

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);
}
