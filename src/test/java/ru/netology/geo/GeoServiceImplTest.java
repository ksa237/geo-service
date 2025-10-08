package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {

    @Test
    void byIp_get_usaLocation_if_usaIP() {
        //создали класс заглушку, возвращает всегда локацию = США
        GeoServiceImplMockClassTest geoService = new GeoServiceImplMockClassTest();

        //инициализируем ожидаемое, испектируемое значение - локация США
        Location usaLocationExpected = new Location("New York", Country.USA, null, 0);

        //вычислим значение в классе заглушке
        Location usaLocationCompute = geoService.byIp("96.54.122.108");

        //проверка
        Assertions.assertEquals(usaLocationExpected.getCountry(), usaLocationCompute.getCountry());

    }
}