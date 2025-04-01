package com.baki.jpaproject.repository;

import com.baki.jpaproject.domain.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByName(String name);
}
