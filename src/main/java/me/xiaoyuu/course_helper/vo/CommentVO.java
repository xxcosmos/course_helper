package me.xiaoyuu.course_helper.vo;

import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.model.User;

public class CommentVO {
    private Comment comment;
    private UserVO userVO;
    private boolean isLike;

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "comment=" + comment +
                ", userVO=" + userVO +
                ", isLike=" + isLike +
                '}';
    }
}
