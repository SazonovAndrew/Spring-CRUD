package spring_crud.service;

import spring_crud.model.User;

import java.util.List;

public interface UserService {
    User show(int id);
    List<User> index();
    void create(User user);
    void update(int id, User user);
    void delete(int id);

}
