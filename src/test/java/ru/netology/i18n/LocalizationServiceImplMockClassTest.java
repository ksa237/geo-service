package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceImplMockClassTest implements LocalizationService{

    @Override
    public String locale(Country country) {
        return "Добро пожаловать";
    }
}
