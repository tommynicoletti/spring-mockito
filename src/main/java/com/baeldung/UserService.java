package com.baeldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NameService nameService;

    @Autowired
    public UserService(NameService nameService) {
        this.nameService = nameService;
    }

    public String getUserName(String id) {
        return nameService.getUserName(id);
    }

    public String getUserSurname(String id) {
        return nameService.getSurname(id);
    }

    public int getUserAge(String id) {
        return 33;
    }
}
