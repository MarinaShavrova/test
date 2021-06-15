// Создание меню в Swing примере с клавиатурными комбинациями и мнемониками 

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.*;

public class Test{
    JFrame window = new JFrame();

    Test(){
        JMenuBar menuBar = new JMenuBar();
        MatteBorder matteBorder = new MatteBorder(1, 0, 0, 0, Color.BLACK);
        menuBar.setBorder(matteBorder);
        menuBar.add(createSubmenus());
        menuBar.add(Box.createHorizontalGlue());

        window = new JFrame("Broadcast"); // инициализация окна, название фрейма
        window.setSize(600,500); //размер фрейма
        window.setLocationRelativeTo(null);//для того чтобы окошко было внутри экрана
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//по нажатию на крестик закрывается полностью программа
        window.setJMenuBar(menuBar);
        window.setVisible(true);
    }
    private JMenu createSubmenus()
    {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(new GridLayout(1, 1));
        JMenu options = new JMenu("Опции");
        JMenu style2 = new JMenu("Данные в базе");
        JMenuItem broadcast = new JMenuItem("Трансляции");
        JMenuItem italic = new JMenuItem("Ведущие");

        Action menuAction = new AbstractAction("Connect") {
            private boolean connected = false;

            @Override

            public void actionPerformed(ActionEvent e) {

                if (!connected) {
                    //  JOptionPane.showMessageDialog(null, "Connected");
                    putValue(NAME, "Disonnect");
                    connected = true;
                    //  panel.add(new Test());
                } else {
                    //  JOptionPane.showMessageDialog(null, "Disconnected");
                    putValue(NAME, "Connect");
                    connected = false;
                    panel.add(new Inputs());
                }
            }
        };
                Action menuActionBroadcast = new AbstractAction("Добавить трансляцию") {
                    private boolean add = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!add) {
                            window.dispose();
                            new Start();
                        }
                    }
                };
                Action menuActionRadioHost = new AbstractAction("Добавить радиоведущего") {
                    private boolean add = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!add) {
                            window.dispose();
                            new AddRadioHost();
                        }
                    }
                };


                options.add(menuActionBroadcast);
                options.add(menuActionRadioHost);
                options.add(menuAction);
                options.addSeparator();
                options.add(style2);

                style2.add(broadcast);
                style2.addSeparator();
                style2.add(italic);


                return options;
            }

}