package com.mobiquity_task.model;

import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    public int userId;
    public int id;
    public String title;
    public String body;
}

