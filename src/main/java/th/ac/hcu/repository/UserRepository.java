package th.ac.hcu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import th.ac.hcu.entity.User;

@Transactional(rollbackFor = Exception.class)
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUserName(@Param(value = "userName") String userName);
	
	User findByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);
	
}
