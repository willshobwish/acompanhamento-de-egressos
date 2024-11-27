/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.CustomComponents;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author Karol
 */
public class RoundedButton {

    public static void roundedButton(JButton button, int radius) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        button.setBorder(new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(button.getBackground());
                g2.fillRoundRect(0, 0, width, height, radius, radius);

                g2.setColor(button.getForeground());
                g2.drawRoundRect(0, 0, width - 1, height - 1, radius, radius);

                g2.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius / 2, radius / 2, radius / 2, radius / 2);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
    }
}
