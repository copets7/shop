package by.yarosh.shop.dao;

import by.yarosh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByName(String name);
}

