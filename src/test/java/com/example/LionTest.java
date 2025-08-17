package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private FelineActions felineActions;


    @Test
    void constructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Неизвестно", felineActions));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }


    @Test
    void getKittensReturnsValueFromFelineActions() throws Exception {
        when(felineActions.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", felineActions);
        assertEquals(5, lion.getKittens());
        verify(felineActions, times(1)).getKittens();
    }


    @Test
    void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", felineActions);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", felineActions);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFoodReturnsMeatIfPredator() throws Exception {
        // Используем реальный Feline, который реализует Predator
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    void getFoodThrowsExceptionIfNotPredator() throws Exception {
        FelineActions nonPredator = mock(FelineActions.class);
        Lion lion = new Lion("Самец", nonPredator);

        assertThrows(UnsupportedOperationException.class, lion::getFood);
    }
}