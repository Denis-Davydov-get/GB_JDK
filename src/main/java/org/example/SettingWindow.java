package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** Класс игры с кнопкой Start new game**/
public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    private JButton btnStart; // инициализация переменной для кнопки

    SettingWindow(GameWindow gameWindow){
        btnStart = new JButton("Start new game"); // присвоение названия кнопке начала игры

        setLocationRelativeTo(gameWindow); // расположение относительно стартового окна
        setSize(WIDTH, HEIGHT); // установка размеров окна

        // слушатель нажатий кнопки Start new game
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /** Размеры игрового поля
                 *  winLan - количество в ряд, чтобы победить -  **/
                setVisible(false); // скрывает окно настроек после нажатия старт игры
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });

        add(btnStart); // Добавляем кнопку на панель
    }
}
