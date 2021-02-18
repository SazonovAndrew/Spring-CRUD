package spring_crud.service;

import spring_crud.dao.UserDao;
import spring_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void create(User user) {
      userDao.create(user);
   }

   @Override
   public User show(int id) {
      return userDao.show(id);
   }

   @Override
   public List<User> index() {
      return userDao.index();
   }

   @Override
   public void update(int id, User user) {
      userDao.update(id, user);
   }

   @Override
   public void delete(int id) {
      userDao.delete(id);
   }
}

