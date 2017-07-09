package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.master.Portfolio;

public interface PortfolioRepository extends PagingAndSortingRepository<Portfolio, String> {

}
