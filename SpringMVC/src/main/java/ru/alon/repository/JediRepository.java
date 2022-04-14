package ru.alon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alon.model.Jedi;

import java.util.List;

public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findAllByFirstName(String firstName);
}
