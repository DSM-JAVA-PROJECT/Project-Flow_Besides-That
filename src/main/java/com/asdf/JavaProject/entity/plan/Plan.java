package com.asdf.JavaProject.entity.plan;

import com.asdf.JavaProject.entity.CreatedAtEntity;
import com.asdf.JavaProject.entity.user.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Plan extends CreatedAtEntity {

    @MongoId
    private String id;

    @NonNull
    private String name;

    @NonNull
    @Field("end_date")
    private LocalDate endDate;

    @DBRef
    @Field("user_ids")
    private List<User> userIds;

}