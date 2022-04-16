package ru.alon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alon.entity.Jedi;

public interface JediRepository extends JpaRepository<Jedi,Long> {
}
