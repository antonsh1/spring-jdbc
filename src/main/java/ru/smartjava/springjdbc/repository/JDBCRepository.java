package ru.smartjava.springjdbc.repository;

import java.util.List;

public interface JDBCRepository {

    List<String> getProductByName(String Name);
}
