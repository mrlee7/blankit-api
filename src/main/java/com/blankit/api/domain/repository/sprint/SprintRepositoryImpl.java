package com.blankit.api.domain.repository.sprint;

import com.blankit.api.domain.entity.Sprint;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.blankit.api.domain.entity.QSprint.sprint;
import static com.blankit.api.domain.entity.QStudyGroup.studyGroup;

public class SprintRepositoryImpl implements SprintRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public SprintRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Sprint> findBySprintIdAndStudyGroupId(Long sprintId, Long studyGroupId) {
        return Optional.ofNullable(queryFactory.select(sprint)
                .from(sprint)
                .innerJoin(studyGroup).fetchJoin()
                .where(sprint.id.eq(sprintId), studyGroup.id.eq(studyGroupId))
                .fetchFirst());
    }

    @Override
    public List<Sprint> findAllByStudyGroupId(Long studyGroupId) {
        return queryFactory.select(sprint)
                .from(sprint)
                .innerJoin(studyGroup).fetchJoin()
                .where(studyGroup.id.eq(studyGroupId))
                .fetch();
    }
}
