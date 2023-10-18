package com.hnu.dongwon.repository;

import com.hnu.dongwon.entity.WorkManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkManageRepository extends JpaRepository<WorkManage, Long> {
    @Query("SELECT n FROM WorkManage n ORDER BY n.category ASC, n.orderCost ASC")
    List<WorkManage> findAllAsc();

    // 업무별(국방자료 업데이트, 자원관리 점검 등) 분류(편성카드, 전투편성 등), 우선순위 기준 오름차순 정렬
    @Query("SELECT w FROM WorkManage w WHERE w.work = :work ORDER BY w.category ASC, w.orderCost ASC")
    List<WorkManage> findByWorkASC(@Param("work") String work);

    List<WorkManage> findByWorkIs(String work);

    // 해당 분류(편성카드, 전투편성 등) 우선순위 기준 오름차순 정렬
    @Query("SELECT w FROM WorkManage w WHERE w.category = :category ORDER BY w.orderCost ASC")
    List<WorkManage> findByCategoryCostAsc(@Param("category") String category);

    WorkManage findByCategory(String category);

    WorkManage findByName(String name);
}
