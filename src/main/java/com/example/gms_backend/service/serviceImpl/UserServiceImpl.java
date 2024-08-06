package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.CreateUserReq;
import com.example.gms_backend.dto.request.EditProfileReq;
import com.example.gms_backend.dto.request.EditUserReq;
import com.example.gms_backend.dto.request.GetListUserReq;
import com.example.gms_backend.dto.response.GetListArticleRes;
import com.example.gms_backend.dto.response.GetListUserRes;
import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Gym;
import com.example.gms_backend.entity.User;
import com.example.gms_backend.repository.GymRepository;
import com.example.gms_backend.repository.UserRepository;
import com.example.gms_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GymRepository gymRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public User getUserInfo(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void createUser(CreateUserReq request) throws ParseException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("You have already registered with this email. Please use another email!");
        }
        User newUser = new User();
        newUser.setFullName(request.getFullName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        newUser.setPhone(request.getPhone());
        newUser.setDob(dateFormat.parse(request.getDob()));
        newUser.setAddress(request.getAddress());
        newUser.setRole("GYM_MANAGER");
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        newUser.setGym(gym);
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        userRepository.save(newUser);
    }

    @Override
    public GetListUserRes getListGymManagers(GetListUserReq request) {
        Pageable pageable = PageRequest.of(request.getPage(), 10);
        List<User> listGymManagers = userRepository.getListGymManagers(request.getKeyword(), pageable);
        int numGymManagers = userRepository.countListGymManagers(request.getKeyword());
        return GetListUserRes.builder()
                .listUsers(listGymManagers)
                .numUsers(numGymManagers)
                .build();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void editUser(String id, EditUserReq request) throws ParseException {
        User user = userRepository.findById(id).orElseThrow();
        user.setFullName(request.getName());
        user.setPhone(request.getPhone());
        user.setDob(dateFormat.parse(request.getDob()));
        user.setAddress(request.getAddress());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        user.setGym(gym);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public List<User> exportListGymManagers() {
        return userRepository.findByRole("GYM_MANAGER");
    }

    @Override
    public User editProfile(String id, EditProfileReq request) throws ParseException {
        User user = userRepository.findById(id).orElseThrow();
        user.setFullName(request.getName());
        user.setPhone(request.getPhone());
        user.setDob(dateFormat.parse(request.getDob()));
        user.setAddress(request.getAddress());
        user.setAvatar(request.getAvatar());
        userRepository.save(user);
        return user;
    }
}
