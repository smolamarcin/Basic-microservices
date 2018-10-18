package microservices.book.gamification.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent  implements Serializable {

    public MultiplicationSolvedEvent() {
        useId = null;
        multiplicationResultAttemptId = null;
        correct = false;
    }

    private final Long multiplicationResultAttemptId;
    private final Long useId;
    private final boolean correct;
}
