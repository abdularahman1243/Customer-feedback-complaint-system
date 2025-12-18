package spring.developer.gsms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.developer.gsms.dto.auth.AuthResponseDTO;
import spring.developer.gsms.dto.auth.LoginRequestDTO;
import spring.developer.gsms.dto.auth.RegisterRequestDTO;
import spring.developer.gsms.service.auth.AuthService;
import spring.developer.gsms.utils.ApiResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO dto
    ) {
        return ApiResponse.success(
                "User registered successfully",
                authService.register(dto)
        );
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO dto
    ) {
        return ApiResponse.success(
                "Login successful",
                authService.login(dto)
        );
    }
}
