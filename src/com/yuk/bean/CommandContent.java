package com.yuk.bean;

/**
 * Created by 浴缸 on 2017/12/21.
 * 指令内容表
 */
public class CommandContent {
    private String id;
    private String contents;
    private String command_id;
    private Command command;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCommand_id() {
        return command_id;
    }

    public void setCommand_id(String command_id) {
        this.command_id = command_id;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
