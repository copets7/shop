package by.yarosh.shop.service;

import by.yarosh.shop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);
}
