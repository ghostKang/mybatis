package com.yuk.dao;

import com.yuk.bean.Message;
import com.yuk.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 浴缸 on 2017/12/19.
 */
public class MessageDao {
    /**
     * 查询所有
     * @param name 名字
     * @param id id
     * @return 查询结果集
     */
    public List<Message> query(String name,int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<Message>();
        try {
            Message message = new Message();
            message.setName(name);
            message.setId(id);
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sql语句
            messageList = sqlSession.selectList("Message.queryAll",message);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return messageList;
    }

    /**
     * 删除单条数据
     * @param id 数据id
     */
    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sql语句
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 批量删除
     * @param integerList 数据id集合
     */
    public void deleteBatch(List<Integer> integerList){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sql语句
            sqlSession.delete("Message.deleteBatch", integerList);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 新增单条数据
     * @param name 姓名
     * @param money 余额
     */
    public void insert(String name,double money){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            Message message = new Message();
            message.setName(name);
            message.setMoney(money);
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sql语句
            sqlSession.insert("Message.insertOne", message);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 批量新增
     * @param messageList 数据集合
     */
    public void insertBatch(List<Message> messageList){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行sql语句
            sqlSession.insert("Message.insertBatch", messageList);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        /*List<Message> messageList = messageDao.query("yuk",1);
        for (int i=0;i<messageList.size();i++){
            Message message = messageList.get(i);
            System.out.println(message.getId()+"  "+message.getName()+"  "+message.getMoney());
        }*/

        // 删除单条
        //messageDao.deleteOne(3);
        // 批量删除
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(11);
        integerList.add(12);
        integerList.add(13);
        integerList.add(14);
        messageDao.deleteBatch(integerList);

        // 新增单条
        //messageDao.insert("基佬伟",1000.00);
        // 批量新增
       /* List<Message> messageList =  new ArrayList<Message>();
        messageList.add(new Message("yiyi",1000.00));
        //messageList.add(new Message("erer",1000.00));
        messageDao.insertBatch(messageList);*/
    }
}
