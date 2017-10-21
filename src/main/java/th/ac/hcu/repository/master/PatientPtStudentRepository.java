package th.ac.hcu.repository.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientPtStudent;
@Repository
public interface PatientPtStudentRepository extends PagingAndSortingRepository<IpePatientPtStudent, Long> {

	IpePatientPtStudent findByStudentId(@Param(value="studentId") String studentId);
	
	@Query(value=" select ipt.* from ipe_patient_pt_student ipt where patient_patient_id = :patient ORDER BY ?#{#pageable} ",
			countQuery = " select count(*) from ipe_patient_pt_student where patient_patient_id = :patient ",
			nativeQuery = true)
	Page<IpePatientPtStudent> getByPatient(Pageable pageable,  @Param(value="patient") Long patient);
	
}
