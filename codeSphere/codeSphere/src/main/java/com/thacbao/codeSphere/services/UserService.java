package com.thacbao.codeSphere.services;

import com.thacbao.codeSphere.dto.request.user.UserLoginReq;
import com.thacbao.codeSphere.dto.request.user.UserReq;
import com.thacbao.codeSphere.dto.request.user.UserUdReq;
import com.thacbao.codeSphere.dto.response.ApiResponse;
import com.thacbao.codeSphere.dto.response.user.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<ApiResponse> signup(UserReq userReq) throws SQLDataException;
    String verifyAccount(Map<String, String> request);

    String regenerateOtp(Map<String, String> request);


    ResponseEntity<?> login(UserLoginReq request);

    ResponseEntity<ApiResponse> getProfile();

    ResponseEntity<ApiResponse> uploadAvatarProfile(MultipartFile file);

    ResponseEntity<ApiResponse> viewAvatar();

    ResponseEntity<ApiResponse> getAllUser();

    ResponseEntity<?> forgotPassword(Map<String, String> request);

    ResponseEntity<?> setPassword(String email, String otp, Map<String, String> request);

    ResponseEntity<ApiResponse> changePassword(Map<String, String> request);

    ResponseEntity<ApiResponse> updateProfile(UserUdReq request);

    ResponseEntity<?> checkToken();
}
