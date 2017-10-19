package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpeMedReconcil;

@Repository
public interface MedReconcilRepository extends PagingAndSortingRepository<IpeMedReconcil, Long> {

}
