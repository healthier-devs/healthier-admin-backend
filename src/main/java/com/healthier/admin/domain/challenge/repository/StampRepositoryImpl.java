package com.healthier.admin.domain.challenge.repository;

import com.healthier.admin.domain.challenge.domain.QStamp;
import com.healthier.admin.domain.challenge.domain.Stamp;
import com.healthier.admin.domain.challenge.domain.StampStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class StampRepositoryImpl implements StampRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final QStamp stamp = QStamp.stamp;

    @Override
    public Page<Stamp> findStampsByFilter(StampStatus status, LocalDate date, Pageable pageable) {
        List<Stamp> stamps =  queryFactory.select(stamp)
                .from(stamp)
                .where(statusEq(status), dateEq(date))
                .fetch();
        return new PageImpl<>(stamps, pageable, stamps.size());
    }

    private BooleanExpression statusEq(StampStatus status) {
        return status != null ? stamp.status.eq(status) : null;
    }

    private BooleanExpression dateEq(LocalDate date) {
        return date != null ? stamp.submitTime.between(date.atStartOfDay(),
                date.plusDays(1).atStartOfDay()) : null;
    }
}
