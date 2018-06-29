package ru.tilman.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Chamber;
import ru.tilman.entity.security.User;

import java.util.List;

@Repository(value = "userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByLogin(String login);
}
