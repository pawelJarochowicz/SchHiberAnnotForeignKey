package example.annot.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Application {

    private static SessionFactory factory;

    public static void main(String[] args) {

        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();

            Capital capital_1=new Capital();
            capital_1.setName("Tokyo");
            session.save(capital_1);

            Capital capital_2=new Capital();
            capital_2.setName("Washington DC");
            session.save(capital_2);

            Capital capital_3=new Capital();
            capital_3.setName("Paris");
            session.save(capital_3);

            Country country_1=new Country();
            country_1.setName("Japan");
            country_1.setContinent("Asia");
            country_1.setCapital(capital_1);
            session.save(country_1);

            Country country_2=new Country();
            country_2.setName("USA");
            country_2.setContinent("North America");
            country_2.setCapital(capital_2);
            session.save(country_2);

            Country country_3=new Country();
            country_3.setName("France");
            country_3.setContinent("Europe");
            country_3.setCapital(capital_3);
            session.save(country_3);


            transaction.commit();
        }catch(Exception e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            System.out.println("ERROR"+e.getMessage());
        }finally {
            session.close();
        }
        factory.close();
    }
}
