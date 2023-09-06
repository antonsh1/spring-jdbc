package ru.smartjava.springjdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.smartjava.springjdbc.entity.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements JDBCRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final String queryProductTemplate;
//    private final String queryCustomerTemplate;

    public RepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryProductTemplate = read("sql/getProductsByName.sql");
//        this.queryCustomerTemplate = read("sql/getCustomerByName.sql");
    }


    @Override
    public Optional<List<Order>> getProductByName(String name) {
//        List<Customer> customerList = (List<Customer>) entityManager.createNativeQuery(queryCustomerTemplate,
//                Customer.class).setParameter("name", name).getResultList();
//        System.out.println(customerList);

        List<Order> orderList = (List<Order>) entityManager.createNativeQuery(queryProductTemplate,
                Order.class).setParameter("name", name).getResultList();
        if (orderList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(orderList);
        }
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
