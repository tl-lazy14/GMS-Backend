package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.CreateUserReq;
import com.example.gms_backend.dto.request.EditProfileReq;
import com.example.gms_backend.dto.request.EditUserReq;
import com.example.gms_backend.dto.request.GetListUserReq;
import com.example.gms_backend.dto.response.GetListUserRes;
import com.example.gms_backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    User getUserInfo(String email);
    GetListUserRes getListGymManagers(GetListUserReq request);
    User getUserById(String id);
    void createUser(CreateUserReq request) throws ParseException;
    void editUser(String id, EditUserReq request) throws ParseException;
    void deleteUser(String id);
    List<User> exportListGymManagers();
    User editProfile(String id, EditProfileReq request) throws ParseException;
}
