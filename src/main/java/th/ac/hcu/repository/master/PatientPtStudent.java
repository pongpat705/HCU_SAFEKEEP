package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientPtStudent;
@Repository
public interface PatientPtStudent extends PagingAndSortingRepository<IpePatientPtStudent, Long> {

}
