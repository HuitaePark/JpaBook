package com.baki.jpaproject.domain;


import com.baki.jpaproject.domain.Order;
import jakarta.persistence.criteria.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

import org.springframework.util.StringUtils;


public class OrderSpec {

    public static SpecialAction<Order> memberNameLike(final String memberName){
        return new SpecialAction<Order>(){
            public Predicate toPredicate(Root<Order> root,
                                         CriteriaQuery<?> query, CriteriaBuilder builder){
                if(StringUtils.isEmpty(memberName)) return null;

                Join<Order,Member> m =
                        root.join("member", JoinType.INNER);
                return builder.like(m.<String>get("name"),"%"+memberName+"%");
            }
        };
    }
}
