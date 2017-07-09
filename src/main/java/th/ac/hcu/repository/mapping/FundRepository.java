package th.ac.hcu.repository.mapping;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.mapping.Fund;

public interface FundRepository extends PagingAndSortingRepository<Fund, Long> {

}
