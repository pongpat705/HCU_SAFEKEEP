package th.ac.hcu.repository.master;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpePatientTransaction;

@Repository
public interface PatientTransactionRepository extends PagingAndSortingRepository<IpePatientTransaction, Long> {

	@Query(value=" SELECT * FROM IPE_PATIENT_TRANSACTION WHERE date(CREATED_DATE) = date(:createdDate) and INDEX_NAME = :indexName ORDER BY ?#{#pageable} ",
			countQuery = " SELECT count(*) FROM IPE_PATIENT_TRANSACTION WHERE date(CREATED_DATE) = date(:createdDate) and INDEX_NAME = :indexName ",
			nativeQuery = true)
	Page<IpePatientTransaction> findByCreatedDate(Pageable pageable, @Param(value="createdDate") Date createdDate, @Param(value="indexName") String indexName);
}
