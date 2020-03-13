package ru.denfad.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ru.denfad.demo.models.Post;
import ru.denfad.demo.models.Sight;
import ru.denfad.demo.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Service
public class sightDao {

    public Sight findSightById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Sight.class, id);
    }

    public void save(Sight sight) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(sight);
        tx1.commit();
        session.close();
    }

    public void update(Sight sight) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(sight);
        tx1.commit();
        session.close();
    }

    public void delete(Sight sight) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(sight);
        tx1.commit();
        session.close();
    }

    public Post findPostById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Post.class, id);
    }

    public List<Sight> findAll() {
        List<Sight> users = (List<Sight>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Sight").list();
        return users;
    }
}
