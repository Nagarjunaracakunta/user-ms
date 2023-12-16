package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public UserDTO saveUser(UserDTO userDTO) {
        User user = userRepo.save(UserMapper.INSTANCE.mapUserDTOtoUser(userDTO));
        return UserMapper.INSTANCE.mapUsertoUserDTO(user);
    }

    public ResponseEntity<UserDTO> findUserByUserId(Integer id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUsertoUserDTO(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }
}
