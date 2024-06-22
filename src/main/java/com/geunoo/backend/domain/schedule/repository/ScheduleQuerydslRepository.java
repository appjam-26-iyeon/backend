package com.geunoo.backend.domain.schedule.repository;

import com.geunoo.backend.domain.schedule.entity.Schedule;
import com.geunoo.backend.domain.schedule.repository.vo.QQueryScheduleVO;
import com.geunoo.backend.domain.schedule.repository.vo.QueryScheduleVO;
import com.geunoo.backend.domain.user.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.geunoo.backend.domain.schedule.entity.QSchedule.schedule;
import static com.geunoo.backend.domain.user.entity.QUser.user;

@RequiredArgsConstructor
@Repository
public class ScheduleQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    public List<QueryScheduleVO> queryMonthSchedule(Long userId) {
        return queryFactory
            .select(
                new QQueryScheduleVO(
                    schedule.id,
                    schedule.name,
                    schedule.isTogether,
                    schedule.startDate,
                    schedule.endDate,
                    schedule.user.name
                )
            )
            .from(schedule)
            .join(schedule.user, user)
            .where(
                user.id.eq(userId)
            )
            .orderBy(schedule.startDate.desc())
            .fetch();
    }
}
