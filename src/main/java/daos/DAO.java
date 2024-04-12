package daos;

import java.util.List;

public abstract class DAO<T extends DTO> {
//  These classes should include:
//  A DAO abstract class or interface for the following methods
//  * public T findById(int id);
//  * public List<T> findAll();
//  * public T update(T dto);
//  * public T create(T dto);
//  * public  void delete(int id);
    public abstract T findById(int id);
    public abstract List<T> findAll();

    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(int id);
}
