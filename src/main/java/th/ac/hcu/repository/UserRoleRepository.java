package th.ac.hcu.repository; 
 
import org.springframework.data.repository.PagingAndSortingRepository; 
import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional; 
 
import th.ac.hcu.entity.UserRole; 
 
@Transactional 
@Repository 
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
 
} 