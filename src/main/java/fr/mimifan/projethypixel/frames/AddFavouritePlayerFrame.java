package fr.mimifan.projethypixel.frames;

import fr.mimifan.projethypixel.api.Ressources;

import javax.swing.*;
import java.awt.*;

/**
 * Class AddFavouritePlayerFrame
 * Dialog frame to add a player to user's favorites.
 */
public class AddFavouritePlayerFrame extends JFrame {

    /**
     * The field to enter the player's name.
     */
    private JTextField valueField;

        /**
         * Constructs a JFrame to add a player in the favourites.
         */
        public AddFavouritePlayerFrame() {
            super("Add favourite player");

            setResizable(false);
            setSize(new Dimension(300, 200));
            setIconImage(Ressources.getInstance().getHypixelIcon());
            setContentPane(buildContentPane());
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }

        /**
         * Builds the content pane for this JFrame.
         * @return a Container (JPanel here) containing every component of the JFrame.
         */
        private Container buildContentPane() {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel displayLabel = new JLabel("Enter the player's name to add");
            displayLabel.setHorizontalAlignment(SwingConstants.CENTER);

            valueField = new JTextField();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1.0;
            panel.add(valueField, gbc);

            JButton okButton = new JButton("OK");
            okButton.setPreferredSize(new Dimension(100, 30));
            okButton.addActionListener(e -> handleOkButton());

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setPreferredSize(new Dimension(100, 30));
            cancelButton.addActionListener(e -> dispose());

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            panel.add(displayLabel, gbc);

            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(okButton, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(cancelButton, gbc);

            return panel;
        }

        /**
         * Handles what should happen once we clicked the confirmation button.
         */
        private void handleOkButton() {
            if(!MainFrame.getInstance().getFavoritesPlayers().contains(valueField.getText())) {
                MainFrame.getInstance().addPlayerToList(valueField.getText());
                MainFrame.getInstance().savePlayerListToPreferences();
                dispose();
            } else dispose();
        }
}
