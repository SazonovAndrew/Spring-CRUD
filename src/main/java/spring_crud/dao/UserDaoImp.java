package spring_crud.dao;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import spring_crud.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

@Repository
public class UserDaoImp implements spring_crud.dao.UserDao {



   private EntityManagerFactory emf;

   @Autowired
   public void setEmf(EntityManagerFactory emf) {
      this.emf = emf;
   }


   @Override
   public List<User> index() {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      List<User> userList = em.createQuery("SELECT c from User c").getResultList();
      em.close();
      return userList;
   }

   @Override
   public User show(int id) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      User user = em.find(User.class, id);
      em.getTransaction().commit();
      em.close();
      return user;
   }

   @Override
   public void create(User user) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();
      em.close();
   }

   @Override
   public void update(int id, User user) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(user);
      em.getTransaction().commit();
      em.close();
   }

   @Override
   public void delete(int id) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.remove(em.find(User.class,id));
      em.getTransaction().commit();
      em.close();
   }
   //   @Override
//   public User getUsersWithCar(String name, int series) {
//      Query  query = sessionFactory.getCurrentSession()
//              .createQuery("from User where  car.name = :paramName and  car.series =: paramSeries");
//      query.setParameter("paramName", name);
//      query.setParameter("paramSeries", series);
//      return (User) query.getSingleResult();
//   }
}
