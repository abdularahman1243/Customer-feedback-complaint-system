package spring.developer.gsms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.developer.gsms.model.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    boolean existsByName(String name);
}
