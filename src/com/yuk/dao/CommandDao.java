package com.yuk.dao;

import com.yuk.bean.Command;
import com.yuk.bean.CommandContent;
import com.yuk.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 浴缸 on 2017/12/21.
 * 查询指令内容
 */
public class CommandDao {
    public List<Command> queryCommandLis(String name,String description){
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<Command>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);
            commandList = sqlSession.selectList("Command.queryCommandList",command);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return commandList;
    }

    public static void main(String[] args) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList = commandDao.queryCommandLis("段子", "段子");
        if(commandList.size()>0){
            List<CommandContent> contentList = commandList.get(0).getContentList();
            System.out.println(contentList.size());
            int i = new Random().nextInt(contentList.size());
            System.out.println(i);
            System.out.println(contentList.get(i).getContents());
        }
    }
}
