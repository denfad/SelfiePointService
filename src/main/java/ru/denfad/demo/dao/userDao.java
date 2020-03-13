package ru.denfad.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ru.denfad.demo.models.Post;
import ru.denfad.demo.models.Sight;
import ru.denfad.demo.models.User;
import ru.denfad.demo.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Service
public class userDao {

    public User findById(int id){
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User u = session.get(User.class, id);
        tx1.commit();
        session.close();
        return u ;
    }

    public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Post findPostBuId(int id){
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Post p = session.get(Post.class, id);
        tx1.commit();
        session.close();
        return p;
    }

    public Sight findSightBuId(int id){
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Sight s = session.get(Sight.class, id);
        tx1.commit();
        session.close();
        return s;
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    public boolean checkUser(User u) {
        List<User> users = findAll();
        if (users != null) {
            for (User fu : users) {
                if (u.getName().equals(fu.getName()))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
