package th.ac.hcu.repository.mapping;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.mapping.File;

public interface FileRepository extends PagingAndSortingRepository<File, Long> {

}
