package com.blankit.api.domain.service;

import com.blankit.api.domain.entity.Member;
import com.blankit.api.domain.entity.Sprint;
import com.blankit.api.domain.entity.Task;
import com.blankit.api.domain.repository.sprint.SprintRepository;
import com.blankit.api.domain.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final SprintRepository sprintRepository;

    private final MemberService memberService;

    @Transactional
    public Long create(Long sprintId, String title, String contents,
                       LocalDateTime startDate, LocalDateTime endDate, int deposit,
                       Long approverId, Long drafterId)
            throws Exception {

        validateApproverId(approverId);
        validateDrafterId(drafterId);

        Member approver = memberService.get(approverId);
        Member drafter = memberService.get(drafterId);

        Task task = Task.builder()
                .title(title)
                .contents(contents)
                .createdDate(LocalDateTime.now())
                .startDate(startDate)
                .endDate(endDate)
                .isSuccess(false)
                .deposit(deposit)
                .approver(approver)
                .drafter(drafter)
                .build();

        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new Exception("Not Found"));
        task.updateSprint(sprint);

        return taskRepository.save(task).getId();
    }

    @Transactional(readOnly = true)
    public Task get(Long taskId) {
        return taskRepository.getById(taskId);
    }

    @Transactional(readOnly = true)
    public List<Task> getAllBySprintId(Long sprintId) {
        return taskRepository.findAllBySprintId(sprintId);
    }

    private void validateApproverId(Long approverId) throws Exception {
        if(Boolean.TRUE.equals(memberService.exists(approverId))) {
            throw new Exception("invalid ApproverId");
        }
    }

    private void validateDrafterId(Long drafterId) throws Exception {
        if(Boolean.TRUE.equals(memberService.exists(drafterId))) {
            throw new Exception("invalid drafterId");
        }
    }

}
