package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        System.out.println("**All Users**");
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("*************");
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }

}
