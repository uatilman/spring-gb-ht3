package ru.tilman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Category;

@Repository(value = "categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, String> {
}
