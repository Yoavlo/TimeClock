import Backend.connection.DbSessionManager;
import Backend.entities.History;
import Backend.entities.Users;
import Swing.HomePage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;



public class Main {

    public static void main(String [] args) {


        //UsersHandler.saveLogIn(localDateTime.toLocalTime(),localDateTime.toLocalDate());
        //save user into db
//        DbSessionManager sessionManager = new DbSessionManager();
//        SessionFactory sessionFactory =   DbSessionManager.getSessionFactoryInstance();
//        Session session = sessionFactory.openSession();
//        Users user= new Users();
//        user.setIsAdmin(false);
//        user.setUser("asds");
//        user.setEmail("bad");
//        user.setPassword("asdas");
//        session.save(user);
//        session.close();
///////////


        //check password

//        System.out.println("line 44");
//        DbSessionManager sessionManager = new DbSessionManager();
//        System.out.println("line 46");
//        Session session = sessionManager.getSessionFactoryInstance().openSession();
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery criteria= builder.createQuery(Users.class);
//        Root<Users> root= criteria.from(Users.class);
//
//        criteria.where(builder.equal(root.get("user"), "abc"));
//        Query query = session.createQuery(criteria);
//        List<Users> Allusers = query.getResultList();
//        for(Users user: Allusers)
//        {
//            System.out.println("password: " +user.getPassword());
//        }
//        session.close();


        //save history
//       DbSessionManager sessionManager = new DbSessionManager();
//        SessionFactory sessionFactory =   DbSessionManager.getSessionFactoryInstance();
//        Session session = sessionFactory.openSession();
//        History history= new History();
//        history.setLogin("5");
//       history.setLogout("56");
//        history.setUserId(5);
//
//        session.save(history);
//        session.close();

        //////////////////


//        String login= "2018-01-01 20:00";
//        String logout= "2018-01-01 21:06";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTimeLogin = LocalDateTime.parse(login, formatter);
//        LocalDateTime dateTimelogout = LocalDateTime.parse(logout, formatter);
//
//        String hours=String.valueOf(ChronoUnit.MINUTES.between(dateTimeLogin, dateTimelogout) / 60 );
//        String minutes=  String.valueOf(ChronoUnit.MINUTES.between(dateTimeLogin, dateTimelogout) % 60);
//
//        System.out.println(hours+":"+minutes);
//        hours= ( (hours.length()==1) ? "0"+hours: hours );
//        minutes= ( (minutes.length()==1) ? "0"+minutes: minutes );
//        System.out.println(hours+":"+minutes);
    }




}






