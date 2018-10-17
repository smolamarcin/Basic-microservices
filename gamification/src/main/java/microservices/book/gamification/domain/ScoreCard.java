package microservices.book.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class ScoreCard {
    private static final int DEFAULT_SCORE = 10;
    @Id
    @GeneratedValue
    @Column(name = "CARD_ID")
    private final Long cardId;
    @Column(name = "USER_ID")
    private final Long userId;
    @Column(name = "ATTEMPT_ID")
    private final Long attemtId;
    @Column(name = "SCORE_TS")
    private final long scoreTimestamp;
    @Column(name = "SCORE")
    private final int score;

    public ScoreCard() {
        this(null, null, null, 0, 0);
    }

    public ScoreCard(Long userId, Long attemtId) {
        this(null, userId, attemtId,System.currentTimeMillis(), DEFAULT_SCORE);
    }
}
