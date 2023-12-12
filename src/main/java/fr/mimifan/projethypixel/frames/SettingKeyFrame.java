package fr.mimifan.projethypixel.frames;

import fr.mimifan.projethypixel.api.API;
import javax.swing.*;
import java.awt.*;

public class SettingKeyFrame extends JFrame {

    private JTextField valueField;

    public SettingKeyFrame() {
        super("Change API key");

        setResizable(false);
        setSize(new Dimension(300, 200));
        setContentPane(buildContentPane());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private Container buildContentPane() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel displayLabel = new JLabel("Enter the new API key");
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
    private void handleOkButton() {
        API.getInstance().saveAPIKey(valueField.getText());
        dispose();
        if(!MainFrame.getInstance().getFrame().isVisible()) MainFrame.getInstance().getFrame().setVisible(true);
    }

}