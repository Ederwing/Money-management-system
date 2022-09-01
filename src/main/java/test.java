import config.SpringConfig;
import dao.Dao;
import dao.impl.UserDao;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        ApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao ud = (Dao) acc.getBean(Dao.class);
        User tem1 = new User();
//        tem1.setID("admin");
//        tem1 = (User) ud.select(tem);
        User tem2 = new User();
        tem2.setID("newuser"); tem2.setPassword("anotherpw"); tem2.setSuper(false);
//        ud.insert(tem2);
        ud.delete(tem2);
        LinkedList<User> users = (LinkedList<User>) ud.select_all();
        for(User u : users) {
            System.out.println("ID:" + u.getID() + ", PW:" + u.getPassword() + ", isSuper:" + u.isSuper());
        }
    }
}
