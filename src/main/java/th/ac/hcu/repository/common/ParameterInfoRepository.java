package th.ac.hcu.repository.common;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.common.ParameterInfo;

@Repository
public interface ParameterInfoRepository extends PagingAndSortingRepository<ParameterInfo, Long> {

}
