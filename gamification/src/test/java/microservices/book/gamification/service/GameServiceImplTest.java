package microservices.book.gamification.service;

import microservices.book.gamification.client.MultiplicationResultAttemptClient;
import microservices.book.gamification.client.dto.MultiplicationResultAttempt;
import microservices.book.gamification.domain.Badge;
import microservices.book.gamification.domain.GameStats;
import microservices.book.gamification.repository.BadgeCardRepository;
import microservices.book.gamification.repository.ScoreCardRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;


public class GameServiceImplTest {

    private GameServiceImpl gameService;

    @Mock
    private ScoreCardRepository scoreCardRepository;

    @Mock
    private BadgeCardRepository badgeCardRepository;

    @Mock
    private MultiplicationResultAttemptClient client;

    @Before
    public void setUp() {
        initMocks(this);
        this.gameService = new GameServiceImpl(scoreCardRepository, badgeCardRepository, client);
    }

    @Test
    public void shouldGiveLuckyNumberBadge_when42IsOneOfTheMultiplicationFactor() {
        //given
        MultiplicationResultAttempt attempt = mock(MultiplicationResultAttempt.class);
        given(attempt.getMultiplicationFactorA()).willReturn(42);
        given(client.retrieveMultiplicationResultAttemptById(1L)).willReturn(attempt);

        //when
        GameStats gameStats = gameService.newAttemptForUser(1L, 1L, true);

        //then
        assertThat(gameStats.getBadges()).contains(Badge.LUCKY_NUMBER);
    }

    @Test
    public void shouldNotGiveLuckyNumberBadge_when_no42InFactors() {
        //given
        MultiplicationResultAttempt attempt = mock(MultiplicationResultAttempt.class);
        given(attempt.getMultiplicationFactorA()).willReturn(52);
        given(client.retrieveMultiplicationResultAttemptById(1L)).willReturn(attempt);

        //when
        GameStats gameStats = gameService.newAttemptForUser(1L, 1L, true);

        //then
        assertThat(gameStats.getBadges()).doesNotContain(Badge.LUCKY_NUMBER);
    }
}