package Beans;

import entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CRUDBean {

    @PersistenceContext
    private EntityManager em;

    public void createUser(User user){
        em.persist(user);
    }

    public List<User> FindAll(){
        Query query= em.createNativeQuery("SELECT * FROM Users" , User.class);
        List<User> Users = query.getResultList();
        return Users;
    }

    public User FindById(Long name){

            Query query = em.createNativeQuery("SELECT * FROM Users WHERE ID = '" + name + "'", User.class);
            User user = (User) query.getSingleResult();
            return user;

    }

    public User UpdateUser(User user){
        User usr =  em.merge(user);
        return usr;
    }
    public void delete(User user){
        em.remove(user);
    }
}
