package spring.developer.gsms.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.developer.gsms.dto.auth.AuthResponseDTO;
import spring.developer.gsms.dto.auth.LoginRequestDTO;
import spring.developer.gsms.dto.auth.RegisterRequestDTO;
import spring.developer.gsms.entity.UserModel;
import spring.developer.gsms.exception.ApiErrorCode;
import spring.developer.gsms.exception.BusinessException;
import spring.developer.gsms.exception.UnauthorizedException;
import spring.developer.gsms.mapper.AuthMapper;
import spring.developer.gsms.repository.UserRepository;
import spring.developer.gsms.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthMapper mapper;

    @Override
    public AuthResponseDTO register(RegisterRequestDTO dto) {

        if (userRepository.existsByUsername(dto.username())) {
            throw new BusinessException("Username already exists", ApiErrorCode.BUSINESS_ERROR);
        }

        if (userRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Email already exists", ApiErrorCode.BUSINESS_ERROR);
        }

        UserModel user = mapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(
                token,
                user.getUsername(),
                user.getUserType().name()
        );
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {

        UserModel user = userRepository.findByUsernameAndEnabledTrue(dto.username())
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(
                token,
                user.getUsername(),
                user.getUserType().name()
        );
    }
}
