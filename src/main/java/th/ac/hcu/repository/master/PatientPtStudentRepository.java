package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientPtStudent;
@Repository
public interface PatientPtStudentRepository extends PagingAndSortingRepository<IpePatientPtStudent, Long> {

	IpePatientPtStudent findByStudentId(@Param(value="studentId") String studentId);
	
}
