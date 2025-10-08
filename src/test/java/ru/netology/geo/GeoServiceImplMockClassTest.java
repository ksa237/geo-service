package ru.netology.geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplMockClassTest implements GeoService {

    @Override
    public Location byIp(String ip) {
        if (ip.startsWith("96.")) {
            return new Location("New York", Country.USA, null, 0);
        }
        return null;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
