package com.food.delivery.user_info.service;

import com.food.delivery.user_info.dto.UserDTO;
import com.food.delivery.user_info.entity.User;
import com.food.delivery.user_info.mapper.UserMapper;
import com.food.delivery.user_info.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        return user
                .map(UserMapper.INSTANCE::mapUserToUserDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
