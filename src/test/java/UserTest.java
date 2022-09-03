import config.SpringConfig;
import dao.UserDao;
import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;

public class UserTest {
    @Test
    public void UserDaotest(){
        ApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = (UserDao) acc.getBean("userDao");
        User user = new User();
        LinkedList<User> users = new LinkedList<User>();
        user.setID("newuser"); user.setPassword("anotherpw"); user.setSuper(false);
        userDao.insert(user);
        users = userDao.select_all();
        for(User tem : users) {
            System.out.println("ID:" + tem.getID() + ", PW:" + tem.getPassword() + ", isSuper:" + tem.isSuper());
        }
        System.out.println();
        userDao.deleteById(user.getID());
        users = userDao.select_all();
        for(User tem : users) {
            System.out.println("ID:" + tem.getID() + ", PW:" + tem.getPassword() + ", isSuper:" + tem.isSuper());
        }
    }

}
