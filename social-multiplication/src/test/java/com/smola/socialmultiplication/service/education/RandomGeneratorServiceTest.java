package com.smola.socialmultiplication.service.education;

import com.smola.socialmultiplication.service.RandomGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
/*We don't need to load app context, This class exists only for educational purposes.
* The bebber approach is to testing implementantion, without SpringBootTest annotation.
* The better approach is shown in RandomGeneratorServiceImplTest*/
public class RandomGeneratorServiceTest {
    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Test
    public void generateRandomRactorIsBetweenExpectedLimits() {
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorService.generateRandomFactor())
                .boxed().collect(Collectors.toList());
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100).boxed().collect(Collectors.toList()));
    }
}