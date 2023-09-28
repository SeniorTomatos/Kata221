package hiber.dao;

import hiber.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User user where user.userCar.model = :model and user.userCar.series = :series");
        query.setParameter("model", model).setParameter("series", series);
        return query.setMaxResults(1).getSingleResult();
    }

}
