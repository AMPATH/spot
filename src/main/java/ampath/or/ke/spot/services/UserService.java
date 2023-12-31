package ampath.or.ke.spot.services;

import ampath.or.ke.spot.models.Role;
import ampath.or.ke.spot.models.User;
import ampath.or.ke.spot.repositories.RoleRepository;
import ampath.or.ke.spot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    Date nowDate = new Date();


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User findByUsernameAndPass(String Username, String Password){
        return userRepository.findByUsernameAndPassword(Username, Password);
    }
    public List<User> getAllUsers(){return  userRepository.findAll();}
    public User findUserByEmail(String email){return userRepository.findByEmail(email);}
    public User findUserByUserEmail(String email){return userRepository.findByEmail(email);}
    public User findUserByUuid(String uuid){return userRepository.findByUuid(uuid);}
    public User findUserById(int id){return userRepository.findById(id);}
    public User findUserByEmailORUsername(String email,String username){return userRepository.findByEmailOrUsername(email,username);}
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setActive(1);
        user.setCreated_by(1);
        // user.setModified_by(1);
        //user.setModified_on(nowDate);
        user.setCreated_on(nowDate);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
