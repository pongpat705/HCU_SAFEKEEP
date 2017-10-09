package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpeStudentEstimate;

@Repository
public interface StudentEstimateRepository extends PagingAndSortingRepository<IpeStudentEstimate, Long> {
	
	IpeStudentEstimate findByUserId(@Param(value="userId") String userId);

}
