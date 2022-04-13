package ru.alon.dao;

import ru.alon.model.Jedi;

import java.util.List;

public interface JediDao extends CrudDao<Jedi> {

    List<Jedi> findAllByJediName(String firstName);

}
