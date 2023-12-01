package fr.mimifan.projethypixel.events;

import com.fasterxml.jackson.databind.JsonNode;
import fr.mimifan.projethypixel.Main;
import fr.mimifan.projethypixel.api.API;
import fr.mimifan.projethypixel.api.Player;
import fr.mimifan.projethypixel.frames.MainFrame;
import fr.mimifan.projethypixel.manager.PlayerManager;
import fr.mimifan.projethypixel.panels.PlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrameActionListener implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(MainFrame.getInstance().getRefreshButton())){
            MainFrame.getInstance().getRefreshButton().setSelected(false);
            int index = MainFrame.getInstance().getPlayersPane().getSelectedIndex();
            if(index < 0) return;

            String playerName = MainFrame.getInstance().getPlayersPane().getTitleAt(index);
            String uuid = API.getInstance().getUUID(playerName);

            PlayerPanel playerPanel = PlayerManager.getInstance().getPlayerPanel(uuid);
            int gameIndex = playerPanel.getTabbedPane().getSelectedIndex();

            JsonNode playerStats = API.getInstance().getPlayerStatsFromUUID(uuid);
            Player player = new Player(playerStats.get("player"), API.getInstance().getSession(uuid));

            PlayerManager.getInstance().removePlayer(uuid);

            PlayerManager.getInstance().addPlayer(player, playerPanel);
            playerPanel.load(player);
            playerPanel.getTabbedPane().setSelectedIndex(gameIndex);

            playerPanel.revalidate();
            playerPanel.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
