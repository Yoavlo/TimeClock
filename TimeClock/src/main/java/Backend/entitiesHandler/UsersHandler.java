package Backend.entitiesHandler;

import Backend.connection.DbSessionManager;
import Backend.entities.History;
import Backend.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public  class UsersHandler {
    private  static DbSessionManager sessionManager;
    private  static SessionFactory sessionFactory;
    private static Session session;
    private static Users currentUser;
    private static History currentHistory;

    public UsersHandler() {
         this.sessionManager = new DbSessionManager();
         this.sessionFactory = DbSessionManager.getSessionFactoryInstance();
         this.session = sessionFactory.openSession();
    }
    public static void initialize()
    {
        sessionManager = new DbSessionManager();
        sessionFactory = DbSessionManager.getSessionFactoryInstance();
        session = sessionFactory.openSession();
    }


    /*
    public boolean createNewUser(Users user)
    {
        try {
            if(isUserNameExistInDB()==false) {

                session.save(user);
            }

            return true;
        }catch (Exception e)
        {
            System.out.println("Error in createNewUser: "+e);
            return false;
        }

    }
    */

    public static List<History> getPersonalHistroy(Users user)
    {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(History.class);
        Root<History> root = criteria.from(History.class);
        criteria.where(builder.equal(root.get("userId"), user.getIdUser()));//where user id = user.getIdUser()
        Query query = session.createQuery(criteria);

        List<History> histroyOfUser = query.getResultList();
        return  histroyOfUser;
    }

    public static boolean checkPassword(String userName, String password) {
      //  DbSessionManager sessionManager = new DbSessionManager();
      //  Session session = sessionManager.getSessionFactoryInstance().openSession();

        if(setCurrentUser( userName,  password)==false) //means fail initialize  currentUser. User doesn't exist in db.
        {
            return  false;
        }



        if(getCurrentUser().getPassword().equals(password))
        {
            return  true;
        }
        else
        {
            return false;
        }


    }

//    public List getPersnoalHistory(Users user)
//    {
//
//    }

    public static List getHistoryOfAllUsers(Users user)
    {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery criteria = builder.createQuery(History.class);
            Root<History> root = criteria.from(History.class);
            Query query = session.createQuery(criteria);

            List<History> histroyOfAllUsers = query.getResultList();
            return  histroyOfAllUsers;

    }

    public static List getAllUsers(Users user)
    {
        if(user.getIsAdmin())
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery criteria = builder.createQuery(Users.class);
            Root<Users> root = criteria.from(Users.class);


            Query query = session.createQuery(criteria);
            List<Users> allUsers = query.getResultList();
            return  allUsers;

        }
        else
        {
            System.out.println("User is not admin");
            return null;
        }
    }

    public static boolean saveLogIn(  String login, String date)
    {

        History history= new History();
        history.setLogin(login);
        history.setUserId(getCurrentUser().getIdUser());
        history.setDate(date);


        setCurrentHistory(history);

        try {
            session.save(history);
          //  session.flush();
            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    public static boolean saveLogout(  String logout)
    {
        getCurrentHistory().setLogout(logout);

        try {
            if(!session.isOpen())
            {
                session = session.getSessionFactory().openSession();
            }
              session.beginTransaction();
            session.update(getCurrentHistory());
             session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }


    public boolean closeSession()
    {
        try {
            session.close();
            return true;
        }catch (Exception e)
        {
            System.out.println("closeSession error: "+e);
            return false;
        }


    }

    public  static boolean setCurrentUser(String userName, String password) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);

        criteria.where(builder.equal(root.get("user"), userName));

        Query query = session.createQuery(criteria);
        List<Users> user = query.getResultList();
        //  session.close();
        if (user.size() > 1) {
            try {
                throw new Exception("Error Allusers.size()>1");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(user.size()==0) //there is now user with this name
        {
            return false;
        }

        currentUser= user.get(0);
        return true;
    }//getCurrentUser

    public  static Users getCurrentUser() {
        return currentUser;
    }

    public static History getCurrentHistory() {
        return currentHistory;
    }

    public static void setCurrentHistory(History history) {
        currentHistory = history;
    }

//    public static boolean isUserAlreadyLogIn()
//    {
//       // getCurrentUser();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(History.class);
//        Root<Users> root = criteria.from(History.class);
//        builder.desc(root.get("id"));
//      //  criteria.add(Order.desc("id"));
//      //  criteria.where(builder.equal(root.get("user"), userName));
//        Query query = session.createQuery(criteria);
//
//        List<Users> user = query.getResultList();
//        //  session.close();
//        if (user.size() > 1) {
//            try {
//                throw new Exception("Error Allusers.size()>1");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        currentUser= user.get(0);
//
//    }


    //check if user exist
}
