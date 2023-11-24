package fr.mimifan.projethypixel.api.data;

import fr.mimifan.projethypixel.api.Player;

import java.awt.*;
import java.util.HashMap;

public class HypixelData {

    private static final HypixelData instance = new HypixelData();

    private HashMap<String, String> rankPrefixes = new HashMap<>();


    public void init(){
        rankPrefixes.put(null,        "<html><font color=#9c9d97>");
        rankPrefixes.put("VIP",       "<html><font color=#80c71f>[VIP]");
        rankPrefixes.put("VIP_PLUS",  "<html><font color=#80c71f>[VIP</font><font color=red>+</font><font color=80c71f>]");
        rankPrefixes.put("MVP",       "<html><font color=#3ab3da>[MVP]");
        rankPrefixes.put("MVP_PLUS",  "<html><font color=#3ab3da>[MVP</font><font color=red>+</font><font color=#3ab3da>]");
        rankPrefixes.put("SUPERSTAR", "<html><font color=#f9801d>[MVP");
    }


    public HashMap<String, String> getRankPrefixes() {
        return rankPrefixes;
    }

    public String getFormattedName(Player player){
        if(player.isSuperstar()) return "<html><font color=#f9801d>[MVP</font><font color=red>++</font><font color=#f9801d>] " + player.getName();
        return player.getRank() + " " + player.getName() + "</font></html>";


        /*if(rankPrefixes.containsKey(player.getRank())){
            if(!rankPrefixes.get(player.getRank()).contains("PLUS")){
                return rankPrefixes.get(player.getRank()) + " " + player.getName() + "</font></html>";
            } else {
                return rankPrefixes.get(player.getRank()) + " ";
            }
        } else {
            return "<html><font color=#9c9d97>" + player.getName() + "</font></html>";
        }*/
    }

    public static HypixelData getInstance() {
        return instance;
    }
}