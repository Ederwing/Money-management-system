package dao;

import model.User;

import java.util.LinkedList;

public interface UserDao {
    LinkedList<User> select_all();
    User selectById(String id);
    int insert(User tar);
    int deleteById(String tar);
}
