package com.yuk.bean;

import java.util.List;

/**
 * Created by 浴缸 on 2017/12/21.
 * 指令表
 */
public class Command {
    private String id;
    private String name;
    private String description;
    private List<CommandContent> contentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
