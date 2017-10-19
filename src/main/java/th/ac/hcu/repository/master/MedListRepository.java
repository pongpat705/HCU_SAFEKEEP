package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpeMedList;
@Repository
public interface MedListRepository extends PagingAndSortingRepository<IpeMedList, Long> {

}
