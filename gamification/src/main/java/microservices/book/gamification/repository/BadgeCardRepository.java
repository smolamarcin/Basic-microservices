package microservices.book.gamification.repository;

import microservices.book.gamification.domain.BadgeCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {
    /*Retrieves all BadgeCards for a given user.*/
    List<BadgeCard> findByUserId(Long userId);

    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(Long userId);
}
