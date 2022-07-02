package by.yarosh.shop.service;

import by.yarosh.shop.dao.UserRepository;
import by.yarosh.shop.domain.Role;
import by.yarosh.shop.domain.User;
import by.yarosh.shop.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(UserDTO userDTO) {
        if(!Objects.equals(userDTO.getPassword(),userDTO.getMatchingPassword())){
            throw new RuntimeException("Password is not equals");
        }
        User user = User.builder()
                .name(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .role(Role.CLIENT)
                .build();

        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findFirstByName(username);
       if( user == null){
           throw new UsernameNotFoundException("User not found with name :  " + username);
       }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

       return new  org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),roles);
    }
}
