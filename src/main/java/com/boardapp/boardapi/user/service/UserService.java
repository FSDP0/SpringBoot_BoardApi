package com.boardapp.boardapi.user.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.boardapp.boardapi.user.entity.UserInfo;
import com.boardapp.boardapi.user.model.UserInfoDto;
import com.boardapp.boardapi.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserInfoDto> getAllUserInfo() {
        List<UserInfo> userInfoList = this.userRepository.findAllUserInfo();

        if (userInfoList.isEmpty()) {
            log.error("Error occured : User list empty...");

            return null;
        }

        List<UserInfoDto> userInfoDtoList = new ArrayList<UserInfoDto>();

        for (UserInfo userInfo : userInfoList) {
            UserInfoDto userInfoDto = UserInfoDto.builder().id(userInfo.getUserId())
                    .name(userInfo.getUserName()).password(userInfo.getUserPassword())
                    .phoneNumber(userInfo.getUserPhoneNumber())
                    .address(userInfo.getUserAddress())
                    .zipCode(userInfo.getAddressZipCode())
                    .createdDate(userInfo.getCreatedDate())
                    .modifiedDate(userInfo.getModifiedDate()).build();

            userInfoDtoList.add(userInfoDto);
        }

        return userInfoDtoList;
    }

    public UserInfoDto getUserInfoById(String id) {
        UserInfo userInfo = this.userRepository.findUserInfoById(id);

        if (userInfo == null) {
            log.error("Error occured : User not exist...");

            return null;
        }

        UserInfoDto userInfoDto = UserInfoDto.builder().id(userInfo.getUserId())
                .name(userInfo.getUserName()).password(userInfo.getUserPassword())
                .phoneNumber(userInfo.getUserPhoneNumber())
                .address(userInfo.getUserAddress()).zipCode(userInfo.getAddressZipCode())
                .createdDate(userInfo.getCreatedDate())
                .modifiedDate(userInfo.getModifiedDate()).build();

        return userInfoDto;
    }

    public void saveUserInfo(UserInfoDto userInfoDto) {
        this.userRepository.saveUser(userInfoDto.toUserInfoEntity());
    }

    public void modifyUserInfo(String id, UserInfoDto userInfoDto) {
        this.userRepository.editUser(id, userInfoDto.toUserInfoEntity());
    }

    public void removeUserInfo(String id) {
        this.userRepository.deleteUser(id);
    }
}
