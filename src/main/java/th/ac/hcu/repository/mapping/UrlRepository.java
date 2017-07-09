package th.ac.hcu.repository.mapping;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.mapping.Url;

public interface UrlRepository extends PagingAndSortingRepository<Url, Long> {

}
