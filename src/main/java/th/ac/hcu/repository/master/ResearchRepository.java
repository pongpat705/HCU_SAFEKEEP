package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.master.Research;

public interface ResearchRepository extends PagingAndSortingRepository<Research, String> {

}
