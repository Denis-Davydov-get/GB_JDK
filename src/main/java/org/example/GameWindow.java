package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;


    // виджеты приложения
    private JButton btnStart, btnExit;
    private SettingWindow settingWindow;
    private Map map;

    GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие по нажатию на крестик
        setSize(WIDTH, HEIGHT); // размеры окна
        setLocationRelativeTo(null); // чтобы экран появлялся по центру

        setTitle("TicTacToe"); // заголовок приложения
        setResizable(false); // возможность изменения размера (запрет)
        btnStart = new JButton("New Game"); // инициализация кнопки Старт игры
        btnExit = new JButton("Exit"); // инициализация кнопки выход
        // создаем экземпляр класса настроек со ссылкой на текущий класс
        settingWindow = new SettingWindow(this);
        map = new Map(); // создаем приложение

        // обработчик нажатий с анонимным классом с переопределением метода в данном случае для закрытия
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // нажатие кнопки старт делает видимым окно
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });
        // панели для размещения кнопок по горизонтали
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        // добавляем панель с кнопками вниз
        add(panBottom, BorderLayout.SOUTH);
        add(map); // располагаем по центру приложение

        setVisible(true); // чтобы появился экран после настроек
    }
    // инициализирует запуск игры с настройками
    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX, sizeY, winLen);
    }
}
