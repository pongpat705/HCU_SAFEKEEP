package th.ac.hcu.repository.master;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import th.ac.hcu.entity.master.IpeGoalPlan;

@Repository
public interface GoalPlanRepository extends PagingAndSortingRepository<IpeGoalPlan, Long> {

}
