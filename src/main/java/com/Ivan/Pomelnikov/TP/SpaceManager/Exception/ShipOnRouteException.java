package com.Ivan.Pomelnikov.TP.SpaceManager.Exception;

public class ShipOnRouteException extends Exception{

    public ShipOnRouteException(){
        super("Can't set ship on this route");
    }
}
