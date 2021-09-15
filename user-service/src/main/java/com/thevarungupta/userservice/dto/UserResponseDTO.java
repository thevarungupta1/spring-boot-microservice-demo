package com.thevarungupta.userservice.dto;

import com.thevarungupta.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private User user;
    private Department department;
}
