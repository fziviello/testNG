package com.academy.unit.enumerative;

public enum Months {

    GENNAIO( "gennaio", 1 ),
    FEBBRAIO ( "febbraio", 2 ),
    MARZO ("marzo", 3 ),
    APRILE ("aprile", 4 ),
    MAGGIO ("maggio", 5 ),
    GIUGNO ("giugno", 6 ),
    LUGLIO ("luglio", 7 ),
    AGOSTO ( "agosto", 8 ),
    SETTEMBRE ("settembre", 9 ),
    OTTOBRE ("ottobre", 10 ),
    NOVEMBRE ("novembre", 11 ),
    DICEMBRE ("dicembre", 12 );

    private final String key;
    private final Integer value;

    Months(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public static String getSeason(int value){
        if(value == DICEMBRE.getValue() || value == GENNAIO.getValue() || value == FEBBRAIO.getValue()){
            return Seasons.INVERNO.name();
        } else if(value == MARZO.getValue() || value == APRILE.getValue() || value == MAGGIO.getValue()){
            return Seasons.PRIMAVERA.name();
        } else if(value == GIUGNO.getValue() || value == LUGLIO.getValue() || value == AGOSTO.getValue()){
            return Seasons.ESTATE.name();
        }
        else if(value == SETTEMBRE.getValue() ||value == OTTOBRE.getValue() || value == NOVEMBRE.getValue()){
            return Seasons.AUTUNNO.name();
        }
        else{
            return "InvalidValue";
        }
    }

    public static String getMonth(int value){

        if(value == DICEMBRE.getValue()){
            return DICEMBRE.getKey();
        }
        else if(value == GENNAIO.getValue())
        {
            return GENNAIO.getKey();
        }
        return "ERRORE";
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }

}




