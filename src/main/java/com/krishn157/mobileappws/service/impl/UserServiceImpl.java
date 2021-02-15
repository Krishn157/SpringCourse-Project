package com.krishn157.mobileappws.service.impl;

import com.krishn157.mobileappws.UserRepository;
import com.krishn157.mobileappws.io.entity.UserEntity;
import com.krishn157.mobileappws.service.UserService;
import com.krishn157.mobileappws.shared.Utils;
import com.krishn157.mobileappws.shared.dto.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

	@Override
	public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exits");
		
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        //temporary dummy
        userEntity.setEncryptedPassword("test");
        

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}
    
}
