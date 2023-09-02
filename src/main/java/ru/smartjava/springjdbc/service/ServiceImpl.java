package ru.smartjava.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smartjava.springjdbc.repository.JDBCRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements JDBCService {

    private final JDBCRepository repository;

    @Override
    public List<String> getProductByName(String Name) {
        return repository.getProductByName(Name);
    }
}
