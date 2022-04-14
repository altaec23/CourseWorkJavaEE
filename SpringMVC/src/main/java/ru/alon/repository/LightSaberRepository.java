package ru.alon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.alon.model.LightSaber;

public interface LightSaberRepository extends CrudRepository<LightSaber,Long> {

}
