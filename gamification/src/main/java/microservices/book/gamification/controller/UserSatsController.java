package microservices.book.gamification.controller;

import microservices.book.gamification.domain.GameStats;
import microservices.book.gamification.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class UserSatsController {
    private final GameService gameService;

    @Autowired
    public UserSatsController(GameService gameService) {
        this.gameService = gameService;
    }

    public GameStats getStatsForuser(@RequestParam("userId") final Long userId){
        return gameService.retrieveStatsForUser(userId);
    }
}
