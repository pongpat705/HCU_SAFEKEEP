package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePhCompliance;
@Repository
public interface PhComplianceRepository extends PagingAndSortingRepository<IpePhCompliance, Long> {

}
