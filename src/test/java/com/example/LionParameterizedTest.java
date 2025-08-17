package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {

    @Mock
    private FelineActions felineActions;

    private static Stream<Arguments> provideSexAndManeStatus() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSexAndManeStatus")
    void constructorSetsManeCorrectly(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineActions);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}