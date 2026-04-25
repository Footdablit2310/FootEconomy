package com.footdablit2310.footeconomy;

import com.footdablit2310.footlib.api.FootLibServices;

public class FootEconomyEntrypoint {

    public static void init() {
        FootLibServices.ECONOMY = new FootEconomyAPIImpl();
    }
}