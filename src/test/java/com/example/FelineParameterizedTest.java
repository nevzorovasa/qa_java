package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class FelineParameterizedTest {

    @Spy
    private Feline feline;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void getKittensWithCountReturnsCorrectValue(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void getKittensCallsWithCorrectCount(int kittensCount) throws Exception {
        feline.getKittens(kittensCount);
        verify(feline, times(1)).getKittens(kittensCount);
    }
}