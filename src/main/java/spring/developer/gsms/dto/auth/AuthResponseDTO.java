package spring.developer.gsms.dto.auth;

public record AuthResponseDTO(
        String token,
        String username,
        String role
) {}
