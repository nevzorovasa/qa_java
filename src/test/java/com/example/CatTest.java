package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Predator predator;  // Теперь можно мокать Predator напрямую

    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(predator);  // Передаём мок Predator
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodCallsEatMeat() throws Exception {
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(predator);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        verify(predator, times(1)).eatMeat();
    }
}
