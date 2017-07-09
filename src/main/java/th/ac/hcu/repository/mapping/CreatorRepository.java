package th.ac.hcu.repository.mapping;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.mapping.Creator;

public interface CreatorRepository extends PagingAndSortingRepository<Creator, Long> {

}
