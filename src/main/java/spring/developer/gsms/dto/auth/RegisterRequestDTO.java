package spring.developer.gsms.dto.auth;


import spring.developer.gsms.entity.UserModel;

public record RegisterRequestDTO(
        String username,
        String email,
        String password,
        UserModel.UserType userType,
        String firstName,
        String lastName,
        String nationalId,   // برای CITIZEN
        String employeeCode, // برای OFFICER / ADMIN
        String department
) {}
