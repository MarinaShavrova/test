import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.awt.*;
import java.awt.event.ActionListener;

public class Start {
    JFrame window;//создание пустого окна
    JPanel panel = new JPanel();
    JMenuItem connect = new JMenuItem("Connect");

    public Start() {
        //JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(new GridLayout(1, 1));

        JMenuBar menuBar = new JMenuBar();
        MatteBorder matteBorder = new MatteBorder(1, 0, 0, 0, Color.BLACK);
        menuBar.setBorder(matteBorder);
        menuBar.add(createSubmenus());
        menuBar.add(Box.createHorizontalGlue());

        panel.add(new Inputs());
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setViewportView(panel);
        scroll.getVerticalScrollBar().setUnitIncrement(50);


        window = new JFrame("Broadcast"); // инициализация окна, название фрейма
        window.setSize(600,500); //размер фрейма
        window.setLocationRelativeTo(null);//для того чтобы окошко было внутри экрана
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//по нажатию на крестик закрывается полностью программа
        window.add(scroll);
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


        Action menuActionRadioHost = new AbstractAction("Добавить радиоведущего") {
            private boolean add = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!add) {
                    window.dispose();
                    new Start();
                }
            }
        };


        options.add(menuActionRadioHost);
        options.addSeparator();
        options.add(style2);

        style2.add(broadcast);
        style2.addSeparator();
        style2.add(italic);


        return options;
    }


    }



