package me.xiaoyuu.course_helper.vo;

import me.xiaoyuu.course_helper.model.Comment;

import java.util.List;

public class CommentVO {
    private Comment comment;
    private List<Comment> childComment;

    public CommentVO(Comment comment, List<Comment> childComment) {
        this.comment = comment;
        this.childComment = childComment;
    }

    public CommentVO() {
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getChildComment() {
        return childComment;
    }

    public void setChildComment(List<Comment> childComment) {
        this.childComment = childComment;
    }
}
