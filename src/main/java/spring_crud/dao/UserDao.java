package spring_crud.dao;

import spring_crud.model.User;

import java.util.List;

public interface UserDao {

   User show(int id);
   List<User> index();
   void create(User user);
   void update(int id, User user);
   void delete(int id);

//   void deleteUser(int id);
//   User updateUser(User user);
//   User getUsersWithCar(String name, int series);
}
