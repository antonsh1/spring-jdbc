package ru.smartjava.springjdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements JDBCRepository {

    private final DataSource dataSource;

    private final String queryTemplate;

    private final NamedParameterJdbcTemplate template;

    public RepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.queryTemplate = read("sql/getProductByName.sql");
    }

    @Override
    public List<String> getProductByName(String name) {
        Map<String, String> map = new HashMap<>(){{put("name", name);}};
        return template.queryForList(queryTemplate, map, String.class);
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
