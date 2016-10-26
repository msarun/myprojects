package com.home.hibernate.Domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Arun on 12/2/2015.
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    @Column
    private String commentDesc;

    @Column
    private String commentedByUser;

    @Column
    private Date commentedTime;

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentedByUser() {
        return commentedByUser;
    }

    public void setCommentedByUser(String commentedByUser) {
        this.commentedByUser = commentedByUser;
    }

    public Date getCommentedTime() {
        return commentedTime;
    }

    public void setCommentedTime(Date commentedTime) {
        this.commentedTime = commentedTime;
    }
}
