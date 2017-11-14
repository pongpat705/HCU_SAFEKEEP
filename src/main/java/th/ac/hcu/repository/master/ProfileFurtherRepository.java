package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientProfileFurther;

@Repository
public interface ProfileFurtherRepository extends PagingAndSortingRepository<IpePatientProfileFurther, Long> {

}
