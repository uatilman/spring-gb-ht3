package ru.tilman.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.security.Role;

@Repository(value = "roleRepository")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByName(String name);
}
