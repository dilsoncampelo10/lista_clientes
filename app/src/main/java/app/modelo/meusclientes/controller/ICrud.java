package app.modelo.meusclientes.controller;

import java.util.List;

public interface ICrud<T> {

    public boolean create(T obj);

    public boolean update(T obj);

    public boolean delete(int id);

    public List<T> getAll();
}
