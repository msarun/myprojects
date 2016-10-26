package com.home.hibernate;

import com.home.hibernate.Domain.Comment;
import com.home.hibernate.Domain.Post;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arun on 12/2/2015.
 */
public class MainPostComment {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Post post = new Post();
        post.setPostName("Hello");
        post.setPostDate(new Date(2015, 12,02));

        Comment comment = new Comment();
        comment.setCommentedByUser("satyaa");
        comment.setCommentDesc("Not a Nice Comment");
        comment.setCommentedTime(new Date(2015,12,02));
        post.setComments(Arrays.asList(comment));


        session.save(comment);
        session.save(post);
        session.getTransaction().commit();
        session.close();

        query(sessionFactory);
    }

    private static void query(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Post.class);
        List list = criteria.list();
        for(Object obj : list) {
            Post post = (Post)obj;
            System.out.println(post.getPostName());
            System.out.println(post.getPostDate());
            System.out.println(post.getComments().get(0).getCommentDesc());
        }

    }
}
