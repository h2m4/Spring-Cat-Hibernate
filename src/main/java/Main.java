import entity.Cat;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Cat cat = new Cat();
//            cat.setName("Bob222444");
//            cat.setFur("darkgrey");
//            cat.setGender("male");
//            cat.setCityId(1L);
//            entityManager.persist(cat);

//            TypedQuery<Cat> catByCityQuery = entityManager.createNamedQuery("Cat.byCity", Cat.class);
//            catByCityQuery.setParameter(1, "Montreal");
//            for (Cat cat: catByCityQuery.getResultList()) {
//               System.out.println(cat);
//            }

            Query countCatByCity = entityManager.createNativeQuery("SELECT COUNT(*) FROM cat INNER JOIN city C on cat.cityId = C.id WHERE C.name=:cityName");
            countCatByCity.setParameter("cityName", "Montreal");
            System.out.println("There are "+countCatByCity.getSingleResult()+" cats in Montreal.");


            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

