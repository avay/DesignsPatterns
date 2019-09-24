package DesignPatterns.StructuralDesignPatterns;

import java.util.EnumMap;
import java.util.Map;

public class FlyWeightPattern {

    public static void main(String[] args) {
            PlayerFactory pf = new PlayerFactory();

            Player ct1 = pf.createAndGetPlayer(PlayerType.COUNTER_TERRORIST);
            ct1.assignWeapon("DEAGLE");
            ct1.mission();
            Player ct2 = pf.createAndGetPlayer(PlayerType.COUNTER_TERRORIST);
            ct2.assignWeapon("MAVERICKS");
            ct2.mission( );

            Player t1 = pf.createAndGetPlayer(PlayerType.TERRORIST);
            t1.assignWeapon("AK-47");
            Player t2 = pf.createAndGetPlayer(PlayerType.TERRORIST);
            t2.assignWeapon("MAGNUM-SNIPER");

    }
}

interface Player{
    public void assignWeapon(String weapon);
    public void mission();
}

class CounterTerrorist implements Player{

    // intrinsic property as it the common behaviour for all CounterTerrorist
    private final String TASK;

    // extrinsic property as it is changed as per requirement
    private String weapon;

    CounterTerrorist() {
        TASK = "DIFFUSE A BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("the mission is to "+TASK+" and the weapon is "+weapon);
    }
}

class Terrorist implements Player{

    // intrinsic property as it the common behaviour for all Terrorist
    private final String TASK;

    // extrinsic property as it changed as per user requirement
    private String weapon;



    Terrorist() {
        TASK = "PLANT A BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("the mission is to "+TASK+" and the weapon is "+weapon);
    }
}

enum PlayerType{
    COUNTER_TERRORIST, TERRORIST;
}

class PlayerFactory{

    private static Map<PlayerType, Player> players = new EnumMap<>(PlayerType.class);

    public Player createAndGetPlayer(PlayerType type){
        Player p = null;
        if(players.get(type)!=null)
            p = players.get(type);
        else{
            switch(type){
                case TERRORIST:
                    System.out.println("Terrorist Created");
                    p = new Terrorist();
                    break;
                case COUNTER_TERRORIST:;
                    System.out.println("Counter Terrorist Created");
                    p = new CounterTerrorist();
                    break;
                default:
                    System.out.println("unreachable code");
            }
            players.put(type, p);
        }
        return  p;
    }
}



