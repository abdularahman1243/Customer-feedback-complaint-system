package spring.developer.gsms.service.auth;

import spring.developer.gsms.dto.auth.AuthResponseDTO;
import spring.developer.gsms.dto.auth.LoginRequestDTO;
import spring.developer.gsms.dto.auth.RegisterRequestDTO;

public interface AuthService {

    AuthResponseDTO register(RegisterRequestDTO dto);

    AuthResponseDTO login(LoginRequestDTO dto);
}
