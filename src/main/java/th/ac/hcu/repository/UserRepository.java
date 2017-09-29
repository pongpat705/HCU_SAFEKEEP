package th.ac.hcu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.ac.hcu.entity.User;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findByUserName(@Param(value = "userName") String userName);
	
	User findByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);
	
	Page<List<User>> findByUserNameContaining(@Param(value = "userName") String userName, Pageable pageable);
	
}
