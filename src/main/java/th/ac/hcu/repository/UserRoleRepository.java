package th.ac.hcu.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import th.ac.hcu.entity.UserRole;

@Transactional
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {

}
