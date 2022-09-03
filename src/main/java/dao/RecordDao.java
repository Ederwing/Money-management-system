package dao;

import model.Record;

import java.util.LinkedList;

public interface RecordDao {
    public LinkedList<Record> select_all();
    public LinkedList<Record> selectById(String id);
    public LinkedList<Record> selectByIsIncome(String id, Boolean isIncome);
    public int insert(Record tar);
    public int delete(Record tar);
    public int deleteById(String id);
}
