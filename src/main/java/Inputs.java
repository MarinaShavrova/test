import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;


public class Inputs extends JPanel { //класс, которые наследует JPanel

    public static Statement statement;
    public static int input;
    private JLabel label = new JLabel("Заполните поля из которых состоит трансляция:");
    private JLabel labelTime = new JLabel("Введите начало трансляции (часы : минуты : секунды):");
    private JLabel labelTimeEnd = new JLabel("Введите окончание трансляции (часы : минуты : секунды):");
    private JTextField inputH = new JTextField("", 1);
    private JLabel labelH = new JLabel(":");
    private JTextField inputM = new JTextField("", 1);
    private JLabel labelM = new JLabel(":");
    private JTextField inputS = new JTextField("", 1);
    private JTextField inputHend = new JTextField("", 1);
    private JLabel labelHend = new JLabel(":");
    private JTextField inputMend = new JTextField("", 1);
    private JLabel labelMend = new JLabel(":");
    private JTextField inputSend = new JTextField("", 1);
    private JLabel labelCheck = new JLabel("Отметьте галками значения из чего состоит трансляция:");
    private JCheckBox checkSong = new JCheckBox("Песня:", false);
    private JLabel labelSong = new JLabel("Введите названия песен, которые будут в трансляции");
    private JLabel labelSongText1 = new JLabel("(данные вводите через точку с запятой -- ; --)");
    private JLabel labelSongText2 = new JLabel("(данные вводите через точку с запятой -- ; --)");
    private JTextField inputSong = new JTextField("", 1);
    private JLabel labelSongArtist = new JLabel("Введите исполнителя:");
    private JTextField inputSongArtist = new JTextField("", 1);
    private JLabel labelSongTime = new JLabel("Введите длительность песни в секундах:");
    private JTextField inputSongTime = new JTextField("", 1);
    private JLabel labelAdvertising = new JLabel("Интнервью:");
    private JTextField inputAdvertising = new JTextField("", 1);
    private JLabel labelAdvertisingTime = new JLabel("Введите длительность интервью в секундах:");
    private JTextField inputAdvertisingTime = new JTextField("", 1);
    private JCheckBox checkAdvertising = new JCheckBox("Трансляция состоит из интервью:", false);
    private Font font = new Font("SanSerif", Font.BOLD, 12);//стиль текста, жирность, и размер текста
    private Font fontLittle = new Font("SanSerif", Font.ITALIC, 10);//стиль текста, жирность, и размер текста
    private Font fontText = new Font("SanSerif", Font.BOLD, 18);//стиль текста, жирность, и размер текста
    private JButton button = new JButton("Далее");

    private int id;
    private int id_song;
    private int id_advertising;

     public Inputs() {
       setLayout(null);//разрешает размещать элементы как необходимо
       //Основное название на форме
        label.setBounds(10, 10, 600, 20);
        label.setFont(fontText);
        add(label);
//Основное название для волей ввода начала трансляции
        labelTime.setBounds(10, 30, 480, 20);
        labelTime.setFont(font);
        add(labelTime);
//Поля ввода начала трансляции
        inputH.setBounds(10, 50, 50, 20);
        add(inputH);
        labelH.setBounds(65, 50, 50, 20);
        add(labelH);
        inputM.setBounds(70, 50, 50, 20);
        add(inputM);
        labelM.setBounds(125, 50, 50, 20);
        add(labelM);
        inputS.setBounds(130, 50, 50, 20);
        add(inputS);
//Основное название для волей ввода окончания трансляции
        labelTimeEnd.setBounds(10, 70, 480, 20);
        labelTimeEnd.setFont(font);
        add(labelTimeEnd);
//Поля ввода окончания трансляции
        inputHend.setBounds(10, 90, 50, 20);
        add(inputHend);
        labelH.setBounds(65, 90, 50, 20);
        add(labelHend);
        inputMend.setBounds(70, 90, 50, 20);
        add(inputMend);
        labelMend.setBounds(125, 90, 50, 20);
        add(labelMend);
        inputSend.setBounds(130, 90, 50, 20);
        add(inputSend);
//Отображение текста - инструкции
        labelCheck.setBounds(10, 110, 600, 20);
        labelCheck.setFont(fontText);
        add(labelCheck);
//Отображение блока для - Песни

        checkSong.setBounds(10, 130, 400, 20);
        add(checkSong);

        labelSong.setBounds(30, 150, 400, 20);
        add(labelSong);

        labelSongText1.setBounds(30, 170, 400, 20);
        labelSongText1.setFont(fontLittle);
        add(labelSongText1);

        inputSong.setBounds(30, 190, 400, 20);
        add(inputSong);

        labelSongArtist.setBounds(30, 210, 600, 20);
        add(labelSongArtist);

        labelSongText2.setBounds(30, 230, 400, 20);
        labelSongText2.setFont(fontLittle);
        add(labelSongText2);

        inputSongArtist.setBounds(30, 250, 400, 20);
        add(inputSongArtist);

        labelSongTime.setBounds(30, 270, 600, 20);
        add(labelSongTime);

        inputSongTime.setBounds(30, 290, 50, 20);
        add(inputSongTime);

//Отображение блока для - Интервью
        checkAdvertising.setBounds(10, 310, 400, 20);
        add(checkAdvertising);

        labelAdvertising.setBounds(30, 330, 400, 20);
        labelAdvertising.setFont(font);
        add(labelAdvertising);

        inputAdvertising.setBounds(30, 350, 400, 20);
        add(inputAdvertising);

        labelAdvertisingTime.setBounds(30, 370, 600, 20);
        add(labelAdvertisingTime);

        inputAdvertisingTime.setBounds(30, 390, 50, 20);
        add(inputAdvertisingTime);

//Проверки и отображение кнопки - Далее
        button.addActionListener(new Inputs.ButtonEventListener());
        button.setBounds(10, 430, 400, 30);
        add(button);
           }

    class ButtonEventListener implements ActionListener { //прослушиватель кода

        public void actionPerformed(ActionEvent e) {

            //Проверка на заполнение полей начала трансляции
            if (isNullOrEmpty(inputS.getText()) || isNullOrEmpty(inputH.getText()) || isNullOrEmpty(inputM.getText())) {
                JOptionPane.showMessageDialog(null, "Заполните начало трансляции");
                return;
            } else {
                //Проверка на соответствие регулярным выражениям, ввода часов от 0 до 24
                if (validatePattern(inputH.getText(), Pattern.compile("^([0-1]?[0-9]|2[0-3])"))) {
                    JOptionPane.showMessageDialog(null, "Некорректно заполнено поле часы, в начале трансляции, не может превышать 24 часа");
                    return;
                }//Проверка на соответствие регулярным выражениям, ввода минус /секунд от 0 до 59
                if (validatePattern(inputM.getText(), Pattern.compile("[0-5][0-9]")) || validatePattern(inputS.getText(), Pattern.compile("[0-5][0-9]"))) {
                    JOptionPane.showMessageDialog(null, "Некорректно заполнено поле минуты или секунды, в начале трансляции, не может превышать 60");
                    return;
                }
            }
            //Проверка на заполнение полей окончания трансляции
            if (isNullOrEmpty(inputSend.getText()) || isNullOrEmpty(inputHend.getText()) || isNullOrEmpty(inputMend.getText())) {
                JOptionPane.showMessageDialog(null, "Заполните окончание трансляции");
                return;
            } else {//Проверка на соответствие регулярным выражениям, ввода часов от 0 до 24
                if (validatePattern(inputHend.getText(), Pattern.compile("^([0-1]?[0-9]|2[0-3])"))) {
                    JOptionPane.showMessageDialog(null, "Некорректно заполнено поле часы, в окончании трансляции, не может превышать 24 часа");
                    return;
                }//Проверка на соответствие регулярным выражениям, ввода минус /секунд от 0 до 59
                if (validatePattern(inputMend.getText(), Pattern.compile("[0-5][0-9]")) || validatePattern(inputSend.getText(), Pattern.compile("[0-5][0-9]"))) {
                    JOptionPane.showMessageDialog(null, "Некорректно заполнено поле минуты / секунды, в окончании трансляции, не может превышать 60");
                    return;
                }
            }
//Проверка на заполнение полей в форме
            if (checkSong.isSelected() == false && checkAdvertising.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Заполните хотя бы один из блоков: песня / интервью / реклама");
            } else { //Проверка на нажатие чек-бокса, а после заполнения полей в этом блоке
                if (checkSong.isSelected()) {
                    if (isNullOrEmpty(inputSong.getText()) || isNullOrEmpty(inputSongArtist.getText()) || isNullOrEmpty(inputSongTime.getText())) {
                        JOptionPane.showMessageDialog(null, "Не заполнены обязательные поля в блоке - Песни");
                        return;
                    } else if (validatePattern(inputSongTime.getText(), Pattern.compile("[+-]?([0-9]*[.])?[0-9]+"))) {
                        JOptionPane.showMessageDialog(null, "Введите время в секундах");
                        return;
                    }
                }

                if (checkAdvertising.isSelected()) {
                    if (isNullOrEmpty(inputAdvertising.getText())) {
                        JOptionPane.showMessageDialog(null, "Не заполнены обязательные поля в блоке - Интервью");
                        return;
                    }else if (validatePattern(inputAdvertisingTime.getText(), Pattern.compile("[+-]?([0-9]*[.])?[0-9]+"))) {
                        JOptionPane.showMessageDialog(null, "Введите время в секундах");
                        return;
                    }
                   }

                math();
                if (input == 1){
                String message = "";
                message += "Выбраны данные в трансляции\n";
                if (checkSong.isSelected()) {
                    message += "Данные заполненные в поле песня: \n Название исполнителя:" + inputSong.getText() + "\n";
                    message += "Название песни: " + inputSongArtist.getText() + "\n";
                    message += "Длительность: " + inputSongTime.getText() + "\n";
                }
                if (checkAdvertising.isSelected()) {
                    message += "Данные заполненные в поле интервью: " + inputAdvertising.getText() + "\n";
                    message += "Длительность: " + inputAdvertisingTime.getText() + "\n";
                }

                int result = JOptionPane.showConfirmDialog(null,
                        message,
                        "Введенная информация",
                        JOptionPane.PLAIN_MESSAGE);
//Проверка на нажатие кнопки - ОК - во фрейме, очистка полей ввода

                if (result == JOptionPane.YES_OPTION) {
                    connectionDB();
                    if (checkSong.isSelected()) {
                        addBDsong(inputSong.getText(), inputSongArtist.getText(), Integer.parseInt(inputSongTime.getText()));
                    };
                    if (checkAdvertising.isSelected()) {
                    addBDAdvertising(inputAdvertising.getText());
                    };

                    System.out.println(id_advertising);
                    System.out.println(id_song);

                    inputH.setText("");
                    inputM.setText("");
                    inputS.setText("");
                    inputHend.setText("");
                    inputMend.setText("");
                    inputSend.setText("");
                    checkSong.setSelected(false);
                    inputSong.setText("");
                    inputSongArtist.setText("");
                    inputSongTime.setText("");
                    checkAdvertising.setSelected(false);
                    inputAdvertising.setText("");
                    inputAdvertisingTime.setText("");

                }
            }
        }
        }

        //метод подсчета секунд
        public int math() {
            int inputHour = Integer.parseInt(inputH.getText());
            int inputHourEnd = Integer.parseInt(inputHend.getText());
            int inputMin = Integer.parseInt(inputM.getText());
            int inputMinEnd = Integer.parseInt(inputMend.getText());
            int inputSec = Integer.parseInt(inputS.getText());
            int inputSecEnd = Integer.parseInt(inputSend.getText());
            int inputSongTimeEnd;
            int inputAdvertisingTimeEnd;
            if (checkSong.isSelected()) {
                inputSongTimeEnd = Integer.parseInt(inputSongTime.getText());
            } else {
                inputSongTimeEnd = 0;
            }

            if (checkAdvertising.isSelected()) {
                inputAdvertisingTimeEnd = Integer.parseInt(inputAdvertisingTime.getText());
            } else {
                inputAdvertisingTimeEnd = 0;
            }

            int SS = 0;
            int SSend = 0;
            int result = 0;
            int sumRes = 0;
            int sumPaidContent = 0;

            SS = inputHour * 3600 + inputMin * 60 + inputSec;
            SSend = inputHourEnd * 3600 + inputMinEnd * 60 + inputSecEnd;
            result = SSend - SS;
            sumRes = inputSongTimeEnd +inputAdvertisingTimeEnd;
            sumPaidContent = inputAdvertisingTimeEnd;

            System.out.println("Время в секундах - начало " + SS);
            System.out.println("Время в секундах - конец " + SSend);
            System.out.println("ИТОГО: " + result);

    if (isMathResult(sumRes,result) == false){
        input = JOptionPane.showConfirmDialog(null,
                "Сумма введенных данных по составляющей трансляции, больше чем сама трансляция",
                "Введенная информация",
                JOptionPane.PLAIN_MESSAGE);
        return input;
    }
    if (isMathPercent(sumPaidContent,result,inputSongTimeEnd) == false){
        input = JOptionPane.showConfirmDialog(null,
                        "Платный контент составляет больше 50% от общего кол-ва введенной длительности трансляции",
                        "Введенная информация",
                        JOptionPane.PLAIN_MESSAGE);
       return input;
    }

    return input = 1;
}
        //Метод сравнения длительности трансляции и введенной длительности других компонентов
        private boolean isMathResult(int sumRes, int result) {
             return (sumRes > result) == false;
        }

        //Метод сравнения длительности трансляции и введенной длительности других компонентов
        private boolean isMathPercent(int sumPaidContent, int result, int inputSongTimeEnd) {
              return ((100 - sumPaidContent*100/result) < 50) == false;
        }

        //Метод проверки заполнения полей. Проверка на пустоту
        private boolean isNullOrEmpty(String str) {
            return str == null || str.trim().length() == 0;
        }

        //Метод проверки заполненных полей - заданному регулярному выражению
        public boolean validatePattern(String str, Pattern pattern) {
             return !pattern.matcher(str).matches();
        }

        //вызов БД - песни
        public int addBDsong(String inputSong, String inputSongArtist, int inputSongTime){
            try {
                statement.execute("insert into song( inputSong, inputSongArtist, inputSongTime) VALUES ('" + inputSong + "','" + inputSongArtist + "','" + inputSongTime + "')");
                String query = "select * from song where inputSong =" + inputSong+ " and inputSongArtist ="+inputSongArtist + " and inputSongTime = "+inputSongTime;
                System.out.println(query);
                id_song = queryBD(query);
            }catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            }

            return id_song;
        }

        public int addBDAdvertising(String inputAdvertising){
            try {
                statement.execute("insert into advertising(inputAdvertising) VALUES ('" + inputAdvertising + "')");
                String query = "select * from advertising where inputAdvertising = '" + inputAdvertising+"'";
                id_advertising = queryBD(query);

            }catch (SQLException e) {
                System.out.println("Can't get connection. Incorrect URL");
                e.printStackTrace();
            }
            return id_advertising;
        }

        public int queryBD(String query) throws SQLException {
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id =  resultSet.getInt(1);
               System.out.println(" "+id);
               return id;
            }
            return id;
        }
        public Object connectionDB(){
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.out.println("Can't get class. No driver found");
                e.printStackTrace();
                return null;
            }
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:sqlite://C://Users//Marinka//IdeaProjects//Broadcast//users.db");
                statement = connection.createStatement();//для работы с SQL
                return statement;

            } catch (SQLException e) {
                System.out.println("Can't get connection. Incorrect URL");
                e.printStackTrace();
                return null;
            }

        }
    }


}
