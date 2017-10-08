package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientProfile;

@Repository
public interface PatientProfileRepository extends PagingAndSortingRepository<IpePatientProfile, Long> {
	
	IpePatientProfile findByIndexName(@Param(value="indexName") String indexName);

}
