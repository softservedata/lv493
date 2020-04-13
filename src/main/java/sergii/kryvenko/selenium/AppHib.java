package sergii.kryvenko.selenium;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppHib {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProductDescriprion.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // start transaction
            session.beginTransaction();

            // get product with name
            String name = "MacBook";
            int id = 43;
            ProductDescriprion tmpProduct = (ProductDescriprion) session
                    .get(ProductDescriprion.class, name);

            // print detail
            System.out.println("tmpProduct: " + tmpProduct);

        } finally {
            factory.close();
        }

    }

}
