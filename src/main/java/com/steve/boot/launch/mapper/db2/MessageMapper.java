package com.steve.boot.launch.mapper.db2;

import com.steve.boot.launch.mapper.db1.Article;

import java.util.List;

public interface MessageMapper {
    public void saveMessage(Message Message);
    void deleteMessage(Long id);
    void updateMessage(Message Message);
    Article getMessage(Long id);
    List<Message> getAll();
}
