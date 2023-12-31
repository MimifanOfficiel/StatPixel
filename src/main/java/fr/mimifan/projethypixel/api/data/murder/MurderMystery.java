package fr.mimifan.projethypixel.api.data.murder;

import com.fasterxml.jackson.databind.JsonNode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Class MurderMystery
 * Contains all data for player's murder mystery stats.
 */
public class MurderMystery {

    /**
     * Global stats retrieved from the player's murder infos.
     */
    private final Integer detectiveChance, murderChance, coins, coinsPickedUp, deaths, gamesPlayed, wins, kills, knifeKills;

    /**
     * Default constructor
     * @param murderInfos the JsonNode to retrieve stats from.
     */
    public MurderMystery(JsonNode murderInfos) {
        this.detectiveChance = murderInfos.has("detective_chance") ? murderInfos.get("detective_chance").asInt() : 0;
        this.murderChance    = murderInfos.has("murderer_chance") ? murderInfos.get("murderer_chance").asInt() : 0;
        this.coins           = murderInfos.has("coins") ? murderInfos.get("coins").asInt() : 0;
        this.coinsPickedUp   = murderInfos.has("coins_pickedup") ? murderInfos.get("coins_pickedup").asInt() : 0;
        this.deaths          = murderInfos.has("deaths") ? murderInfos.get("deaths").asInt() : 0;
        this.gamesPlayed     = murderInfos.has("games") ? murderInfos.get("games").asInt() : 0;
        this.wins            = murderInfos.has("wins") ? murderInfos.get("wins").asInt() : 0;
        this.kills           = murderInfos.has("kills") ? murderInfos.get("kills").asInt() : 0;
        this.knifeKills      = murderInfos.has("knife_kills") ? murderInfos.get("knife_kills").asInt() : 0;
    }

    /**
     * @return {@link MurderMystery#coins}
     */
    public Integer getCoins() {
        return coins;
    }

    /**
     * @return {@link MurderMystery#coinsPickedUp}
     */
    public Integer getCoinsPickedUp() {
        return coinsPickedUp;
    }

    /**
     * @return {@link MurderMystery#murderChance}
     */
    public Integer getMurderChance() {
        return murderChance;
    }

    /**
     * @return {@link MurderMystery#detectiveChance}
     */
    public Integer getDetectiveChance() {
        return detectiveChance;
    }

    /**
     * Returns the row of data to put inside a JTable
     * @return A List of Objects representing the columns data.
     */
    public List<Object> getRow() {
        List<Object> data = new ArrayList<>();
        data.add(gamesPlayed);
        data.add(wins);
        data.add(deaths);
        data.add(kills);
        data.add(knifeKills);

        return data;
    }

    /**
     * Returns the JTable containing all murder mystery's stats.
     * @return JTable
     */
    public JTable getStatTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Games Played");
        model.addColumn("Wins");
        model.addColumn("Deaths");
        model.addColumn("Kills");
        model.addColumn("Knife Kills");

        model.addRow(getRow().toArray());

        JTable table = new JTable(model);
        table.setEnabled(false);

        return table;
    }

}