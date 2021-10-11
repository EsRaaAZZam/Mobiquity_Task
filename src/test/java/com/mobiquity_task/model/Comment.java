package com.mobiquity_task.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
