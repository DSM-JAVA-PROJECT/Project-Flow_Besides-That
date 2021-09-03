package com.asdf.JavaProject.entity.project;

import com.asdf.JavaProject.entity.CreatedAtEntity;
import com.asdf.JavaProject.entity.chatRoom.ChatRoom;
import com.asdf.JavaProject.entity.user.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Document
public class Project extends CreatedAtEntity {

    @MongoId
    private String id;

    @Field("project_name")
    private String projectName;

    @DBRef(lazy = true)
    @Field("user_ids")
    private List<User> userIds;

    private List<ChatRoom> chatRooms;

    private String subject;

    private String explanation;

    @NonNull
    @Field("start_at")
    private LocalDate startAt;

    @NonNull
    @Field("end_at")
    private LocalDate endAt;

    @Field("logo_image")
    private String logoImage;
}