package th.ac.hcu.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import th.ac.hcu.entity.master.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, String>{

}