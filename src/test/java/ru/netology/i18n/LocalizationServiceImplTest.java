package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    void locale_get_rusHello_if_rusCountry() {

        //создали класс заглушку, возвращает всегда русский текст приветствия
        LocalizationServiceImplMockClassTest localizationService = new LocalizationServiceImplMockClassTest();

        //инициализируем ожидаемое, испектируемое значение
        String rusHelloExpected = "Добро пожаловать";

        //вычислим значение в классе заглушке
        String rusHelloCompute = localizationService.locale(Country.RUSSIA);

        //проверка
        Assertions.assertEquals(rusHelloExpected, rusHelloCompute);

    }
}