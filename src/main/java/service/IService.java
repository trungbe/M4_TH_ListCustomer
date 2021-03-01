package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    void create(T t);
}
