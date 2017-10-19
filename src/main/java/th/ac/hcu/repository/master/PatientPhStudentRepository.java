package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientPhStudent;
@Repository
public interface PatientPhStudentRepository extends PagingAndSortingRepository<IpePatientPhStudent, Long> {

}
