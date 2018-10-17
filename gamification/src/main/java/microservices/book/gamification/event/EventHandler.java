package microservices.book.gamification.event;

import lombok.extern.slf4j.Slf4j;
import microservices.book.gamification.service.GameService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventHandler {
    private GameService gameService;

    @Autowired
    public EventHandler(GameService gameService) {
        this.gameService = gameService;
    }

    @RabbitListener(queues = "${multiplication.queue}")
    void handleMultiplicationSolved(final MultiplicationSolvedEvent multiplicationSolvedEvent) {
        log.info("Multipication solved event received: {}", multiplicationSolvedEvent.getMultiplicationResultAttemptId());
        try {
            gameService.newAttemptForUser(multiplicationSolvedEvent.getUseId(),
                    multiplicationSolvedEvent.getMultiplicationResultAttemptId(),
                    multiplicationSolvedEvent.isCorrect());
        } catch (Exception e) {
            log.error("Error when trying to process MultiplicationSolved Event", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
