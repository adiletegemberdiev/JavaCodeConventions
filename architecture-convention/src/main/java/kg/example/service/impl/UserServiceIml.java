package kg.example.service.impl;

import kg.example.entity.Preference;
import kg.example.entity.User;
import kg.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    @Override
    public User getCurrentUser() {
        
        Preference preference = new Preference();
        preference.setId(1L);
        preference.setTimezone("Asia/Bishkek");
        
        User user = new User();
        user.setId(1L);
        user.setName("Aktan");
        user.setPreference(preference);
                
        return user;
    }
}