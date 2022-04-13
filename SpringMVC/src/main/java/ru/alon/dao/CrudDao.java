package ru.alon.dao;
import java.util.Optional;

/**
 * Интерфейс для работы классов DAO с основными CRUD функциями DB
 * @param <T>
 */
public interface CrudDao<T> {
    /**
     * Поиск по id
     * @param id jedi
     * @return возвращает
     */
    Optional<T> find(Long id);

    /**
     * Сохранить введенные данные в базу
     * @param model
     */
    void save(T model);


}
