package com.blankit.api.domain.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor
public class SprintPeriod {

    @Column(name = "start_at", nullable = false)
    LocalDateTime from;

    @Column(name = "end_at", nullable = false)
    LocalDateTime to;

    private SprintPeriod(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public static SprintPeriod of(LocalDateTime from, LocalDateTime to) {
        return new SprintPeriod(from, to);
    }
}
