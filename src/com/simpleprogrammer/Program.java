package com.simpleprogrammer;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        System.out.println("hello world");
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setName("Joe");
        user.addHistory(new UserHistory(new Date(), "Set name to Joe"));
        user.getProteinData().setGoal(250);
        user.addHistory(new UserHistory(new Date(), "Set the goal to 250"));
        session.save(user);

        session.getTransaction().commit();


        session.beginTransaction();
        User loadedUser = (User) session.get(User.class, 1);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getProteinData().getGoal());

        for(UserHistory history: loadedUser.getHistory()) {
            System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
        }

        loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
        loadedUser.addHistory(new UserHistory(new Date(), "Added 50 protein"));



        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();

    }
}
