package th.ac.hcu.repository.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.common.ParameterInfo;

@Repository
public interface ParameterInfoRepository extends PagingAndSortingRepository<ParameterInfo, Long> {
	
	Page<ParameterInfo> findByGroupCode(Pageable pageable, @Param(value = "groupCode") String groupCode);
}
