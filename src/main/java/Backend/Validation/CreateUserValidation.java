package Backend.Validation;

import Backend.connection.DbSessionManager;
import Backend.entities.History;
import Backend.entities.Users;
import Backend.entitiesHandler.UsersHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CreateUserValidation {


    public boolean isUserNameExistInDB(String userName)
    {
          DbSessionManager sessionManager;
          SessionFactory sessionFactory;
          Session session;
          sessionManager = new DbSessionManager();
          sessionFactory = DbSessionManager.getSessionFactoryInstance();
          session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Users.class);
        Root<History> root = criteria.from(Users.class);
        criteria.where(builder.equal(root.get("user"), userName));//where user id = user.getIdUser()
        Query query = session.createQuery(criteria);

        List<History> users = query.getResultList();
        session.close();

        if(users.size()==0)
        {
            return false; //userName does not Exist in Db
        }
        {
            return true;
        }





    }

//    public String checkUser(Users user)
//    {
//
//        user.getPassword();
//        if(checkEmail(user.getEmail())!=null)
//        {
//            return  checkEmail(user.getEmail();
//        }
//
//        if()
//        user.getUser();
//
//
//
//        return null;
//
//    }


    public String checkEmail(String email)
    {
        if(email.length()<5)
        {
            return  "Email is too short";
        }
        if(email.indexOf("@")==-1)
        {
            return "@ must be in you Email";
        }
        return null;
    }

    public String checkName(String name)
    {
        if(name.length()<3)
        {
            return  "name too short";
        }
        return null;
    }

}
