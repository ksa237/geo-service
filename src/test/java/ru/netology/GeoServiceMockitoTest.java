package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceMockitoTest {

    @Test
    void test_get_russianMessage_when_put_russianIp_MessageSenderImpl() {


        //классы-заглушки
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);

        // создаем экз. тестируемого класса
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);


        //messageSender в методе send используется geoService.byIp, и localizationService.locale
        //задаем с помощью when самостоятельно такое поведение, чтобы вернулось Location = Россия
        //этого достаточно для дальнейших вычислений в localizationService.locale и возврата строки на русском.
        Location russianLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(russianLocation);
        //Mockito.when(localizationService.)

        Location locRequest = geoService.byIp("172.0.32.11");

        //подготовительные данные , входящие параметры теста
        Map<String, String> headersRus = new HashMap<String, String>();
        headersRus.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11"); //96.44.183.149 или 172.0.32.11


        String testRequest = messageSender.send(headersRus);
        String testExpected = "Отправлено сообщение: Добро пожаловать";
        Assertions.assertEquals(testExpected, testRequest);


    }


//    @Test
//    void test


}
