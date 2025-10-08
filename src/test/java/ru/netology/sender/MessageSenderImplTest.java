package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void send_rusIP_receive_rusAnswerTest() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        //geoService.byIp возвращает Location, создадим нужный объект этого вида.
        Location russianLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        //зададим поведение для методов mock-классов
        Mockito.when(geoService.byIp(Mockito.any())).thenReturn(russianLocation);
        Mockito.when(localizationService.locale(Mockito.any())).thenReturn("Добро пожаловать");

        //вспомогательные входящие параметры
        Map<String, String> headersRus = new HashMap<>();
        headersRus.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String answer = messageSender.send(headersRus);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, answer);

    }



    @Test
    void send_usaIP_receive_enAnswerTest() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        //geoService.byIp возвращает Location, создадим нужный объект этого вида.
        Location usaLocation = new Location("New York", Country.USA, " 10th Avenue", 32);

        //зададим поведение для методов mock-классов
        Mockito.when(geoService.byIp(Mockito.any())).thenReturn(usaLocation);
        Mockito.when(localizationService.locale(Mockito.any())).thenReturn("Welcome");

        //вспомогательные входящие параметры
        Map<String, String> headersUSA = new HashMap<>();
        headersUSA.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String answer = messageSender.send(headersUSA);
        String expected = "Welcome";
        Assertions.assertEquals(expected, answer);

    }










}