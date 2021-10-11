package com.mobiquity_task.services;

import com.mobiquity_task.model.Comment;

import java.io.IOException;
import java.util.List;

public interface ICommentService {
    public List<Comment> getComments(List<Integer> postsidslist) throws IOException;

    void isJsonKeyEmpty(List<Comment> list) throws IOException;
}
