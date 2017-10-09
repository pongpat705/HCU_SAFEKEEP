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

	@Query(value=" SELECT * FROM ipe_patient_transaction WHERE date(CREATED_DATE) = date(:createdDate) and INDEX_NAME = :indexName ORDER BY ?#{#pageable} ",
			countQuery = " SELECT count(*) FROM ipe_patient_transaction WHERE date(CREATED_DATE) = date(:createdDate) and INDEX_NAME = :indexName ",
			nativeQuery = true)
	Page<IpePatientTransaction> findByCreatedDate(Pageable pageable, @Param(value="createdDate") Date createdDate, @Param(value="indexName") String indexName);
	
	@Query(value=" select ipt.* from  ipe_patient_transaction ipt inner join ipe_patient_profile_transactions ippt on ipt.transaction_id = ippt.transactions_transaction_id inner join ipe_patient_profile ipp on ippt.ipe_patient_profile_patient_id = ipp.patient_id where ipp.patient_id = :profileId ORDER BY ?#{#pageable} ",
			countQuery = " select count(*) from  ipe_patient_transaction ipt inner join ipe_patient_profile_transactions ippt on ipt.transaction_id = ippt.transactions_transaction_id inner join ipe_patient_profile ipp on ippt.ipe_patient_profile_patient_id = ipp.patient_id where ipp.patient_id = :profileId ",
			nativeQuery = true)
	Page<IpePatientTransaction> findByPatientId(Pageable pageable, @Param(value="profileId") Long profileId);
}
