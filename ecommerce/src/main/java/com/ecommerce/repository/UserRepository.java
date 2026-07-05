package com.ecommerce.repository;
import java.util.Optional;
import com.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Optional<User> findById(Long id);

}
