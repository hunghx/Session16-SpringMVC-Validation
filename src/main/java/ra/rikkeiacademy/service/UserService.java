package ra.rikkeiacademy.service;

import org.springframework.stereotype.Service;
import ra.rikkeiacademy.dto.SignInForm;
import ra.rikkeiacademy.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    public UserService() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users.add(new User(1L,"hunghx","123456","Hồ Xuân Hùng",sf.parse("1999-6-18"),true));
            users.add(new User(2L,"sontx","123456","Trần Xuân Sơn",sf.parse("1998-12-1"),false));
            users.add(new User(3L,"ngondm","123456","Đỗ Minh Ngọc",sf.parse("2000-5-5"),true));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(SignInForm signInForm){
//        final User[] userLogin = {null};
//        users.forEach(u->{
//            if (u.getUsername().equals(signInForm.getUsername())&& u.getPassword().equals(signInForm.getPassword())){
//                userLogin[0] = new User(u.getId(), u.getUsername(),null,u.getAvatar(),u.getBirthday(),u.isStatus());
//            }
//        });
//        return userLogin[0];
        User userLogin = null;
        for (User u:users) {
            if (u.getUsername().equals(signInForm.getUsername())&& u.getPassword().equals(signInForm.getPassword())){
                userLogin = new User(u.getId(), u.getUsername(),u.getFullName(),null,u.getAvatar(),u.getBirthday(),u.isStatus());
            }
        }
        return userLogin;
    }
}
