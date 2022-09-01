package dao;

import java.util.LinkedList;

public interface Dao {
    LinkedList<?> select_all();
    Object select(Object tar);
    int insert(Object tar);
    int delete(Object tar);
}
