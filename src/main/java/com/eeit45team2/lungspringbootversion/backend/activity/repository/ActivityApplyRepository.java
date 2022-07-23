package com.eeit45team2.lungspringbootversion.backend.activity.repository;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityApply;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityApplyRepository extends JpaRepository<ActivityApply, Integer> {
//    Optional<ActivityApply> findByOrderNo(String orderNo);

    Page<ActivityApply> findAllByMemberBean(MemberBean memberBean, Pageable pageable);

//    Page<ActivityApply> findAllByOrderStatusAndMemberBean(ApplyStatus status, MemberBean memberBean, Pageable pageable);
}
