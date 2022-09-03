import config.SpringConfig;
import dao.RecordDao;
import dao.UserDao;
import model.Record;
import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;

public class RecordTest {
    @Test
    public void RecordDaoTest() {
        ApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        Record record = new Record();
        RecordDao recordDao = (RecordDao) acc.getBean("recordDao");
        LinkedList<Record> records = new LinkedList<Record>();

        records = recordDao.select_all();
        for(Record r : records) {
            System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        }
        System.out.println();
        //²åÈë
        record.setID("lh"); record.setIncome(false); record.setType("shop"); record.setValue(103.2);
        recordDao.insert(record);
        records = recordDao.select_all();
        for(Record r : records) {
            System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        }
        System.out.println();
        //É¾³ý
        recordDao.delete(record);
        records = recordDao.select_all();
        for(Record r : records) {
            System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        }
    }
    @Test
    public void deleteById() {
        ApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = new User();
        Record record = new Record();
        UserDao userDao = (UserDao) acc.getBean("userDao");
        RecordDao recordDao = (RecordDao) acc.getBean("recordDao");
        LinkedList<Record> records;

        user.setID("delById"); user.setSuper(false); user.setPassword("dbi");
        userDao.insert(user);

        record.setID("delById");
        recordDao.insert(record);
        records = recordDao.select_all();
        for(Record r : records) {
            System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        }
        System.out.println();
        recordDao.deleteById(record.getID());
        records = recordDao.select_all();
        for(Record r : records) {
            System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        }
        userDao.deleteById(user.getID());
    }
    @Test
    public void date() {
        ApplicationContext acc = new AnnotationConfigApplicationContext(SpringConfig.class);
        RecordDao recordDao = (RecordDao) acc.getBean("recordDao");
        Record r = new Record();
//        r.setTime("2022-9-1");
        System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+r.getTime());
        LinkedList<Record> records = recordDao.select_all();
        r = records.get(0);
        System.out.println("ID:"+r.getID()+", IsIncome:"+r.isIncome()+", value:"+r.getValue()+", type:"+r.getType()+", time:"+(String)r.getTime());
    }
}
