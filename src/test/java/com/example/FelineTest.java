package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    private Feline feline;

    @Test
    void getFamilyReturnsCorrectValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutCountCallsWithDefaultValue() {
        assertEquals(1, feline.getKittens());
        verify(feline, times(1)).getKittens(1);
    }

    @Test
    void eatMeatCallsGetFoodWithPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(feline).getFood("Хищник");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).getFood("Хищник");
    }
}