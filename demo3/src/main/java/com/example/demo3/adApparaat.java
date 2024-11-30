package com.example.demo3;

public class adApparaat {
    //int adID;
    public String installD, locatie, beschrijving;
    public int adID, gpsId;
    public double stofWaarde;
    public boolean gps;
    //boolean gps;

    public adApparaat(int adID, String installD, String locatie, String beschrijving, double stofWaarde, boolean gps, int gpsId) {
        this.adID = adID;
        this.installD = installD;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.stofWaarde = stofWaarde;
        this.gps = gps;
        this.gpsId = gpsId;
    }

    public int getAdID() {
        return adID;
    }

    public String getInstallD() {
        return installD;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public boolean getGps() {
        return gps;
    }

    public double getStofWaarde() {
        return stofWaarde;
    }

    public int getGpsId() {
        return gpsId;
    }
}
