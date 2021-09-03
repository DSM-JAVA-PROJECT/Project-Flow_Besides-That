package com.asdf.JavaProject.entity.chat;

import com.asdf.JavaProject.entity.CreatedAtEntity;
import com.asdf.JavaProject.entity.chatRoom.ChatRoom;
import com.asdf.JavaProject.entity.user.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Document
public class Chat extends CreatedAtEntity {

    @MongoId
    private String id;

    private String message;

    @DBRef(lazy = true)             // MongoDB 특성상 Cascade와 같은 작업은 지원하지 않는다.
    @Field("chatroom_id")
    private ChatRoom chatRoom;

    @DBRef(lazy = true)
    private User sender;

    @DBRef(lazy = true)
    private List<User> readers;

}