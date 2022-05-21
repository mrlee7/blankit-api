package com.blankit.api.domain.repository.task;

import com.blankit.api.domain.entity.Task;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.blankit.api.domain.entity.QSprint.sprint;
import static com.blankit.api.domain.entity.QTask.task;

public class TaskRepositoryImpl implements TaskRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public TaskRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Task> findAllBySprintId(Long sprintId) {
        return queryFactory.select(task)
                .from(task)
                .innerJoin(sprint).fetchJoin()
                .where(sprint.id.eq(sprintId))
                .fetch();
    }

}
