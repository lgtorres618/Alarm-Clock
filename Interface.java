import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Interface extends JFrame implements ActionListener {
    JFrame MainFrame;
    JButton JPBotton;
    JButton timerButton;
    JButton confirmAlarm;
    JTextField textField;
    String AlarmTime;


    String Time;

    JLabel TimeLabel;
    public static JLabel AlarmClockLabel;
    JPanel AlarmPanel;
    JPanel AlarmPanelTwo;
    JPanel AlarmPanelThree;
    Calendar calendar;
    SimpleDateFormat timeFormat;

    Interface() {

        MainFrame = new JFrame("Clock");
        MainFrame.setSize(550, 500);
        MainFrame.setLayout(new BoxLayout(MainFrame.getContentPane(), BoxLayout.Y_AXIS));
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel DirectionLabel = new JLabel("Menu:");
        DirectionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        DirectionLabel.setBorder(new EmptyBorder(50, 0, 0, 0));
        DirectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel JPHolder = new JPanel();
        JPHolder.setBorder(new EmptyBorder(75, 0, 10, 0));

        JPBotton = new JButton("Alarm Clock");
        JPBotton.setPreferredSize(new Dimension(150, 75));
        JPBotton.setFont(new Font("Arial", Font.BOLD, 20));
        JPBotton.addActionListener(this);

        timerButton = new JButton("Timer");
        timerButton.setPreferredSize(new Dimension(150, 75));
        timerButton.setFont(new Font("Arial", Font.BOLD, 20));
        timerButton.addActionListener(this);


        MainFrame.add(DirectionLabel);
        MainFrame.add(JPHolder);
        JPHolder.add(JPBotton);
        JPHolder.add(timerButton);


        confirmAlarm = new JButton("Set Alarm");
        confirmAlarm.setPreferredSize(new Dimension(100, 20));
        confirmAlarm.setBackground(Color.white);
        confirmAlarm.setFont(new Font("Arial", Font.BOLD, 12));
        confirmAlarm.addActionListener(this);

        MainFrame.setVisible(true);
        timeFormat = new SimpleDateFormat("hh:mm:ss aa");
        TimeLabel = new JLabel();
        TimeLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        TimeLabel.setForeground(new Color(0xFFFFFF));
        UpdateTime();

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == JPBotton) {
            System.out.println("this");

            JFrame AlarmFrame = new JFrame();


            AlarmFrame.setSize(700, 600);
            AlarmFrame.getContentPane().setBackground(Color.black);
            AlarmFrame.setLayout(new BoxLayout(AlarmFrame.getContentPane(), BoxLayout.Y_AXIS));
            AlarmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MainFrame.dispose();


            AlarmPanel = new JPanel();
            AlarmPanel.setPreferredSize(new Dimension(100, 100));
            AlarmPanel.setBorder(new EmptyBorder(75, 0, 10, 0));
            AlarmPanel.setBackground(Color.black);


            AlarmPanelTwo = new JPanel();
            AlarmPanelTwo.setPreferredSize(new Dimension(100, 150));
            AlarmPanelTwo.setBorder(new EmptyBorder(75, 0, 10, 0));
            AlarmPanelTwo.setBackground(Color.black);
            AlarmPanelTwo.add(confirmAlarm);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(100, 25));


            AlarmPanelTwo.add(textField);


            AlarmPanel.add(TimeLabel);
            AlarmPanel.setVisible(true);
            AlarmPanelThree = new JPanel();
            AlarmPanelThree.setPreferredSize(new Dimension(100, 150));
            AlarmPanelThree.setBorder(new EmptyBorder(75, 0, 10, 0));
            AlarmPanelThree.setBackground(Color.black);
            AlarmFrame.add(AlarmPanel);
            AlarmFrame.add(AlarmPanelTwo);
            AlarmFrame.add(AlarmPanelThree);
            AlarmFrame.setVisible(true);


        }
        if (e.getSource() == timerButton) {
            System.out.println("that");


        }
        if (e.getSource() == confirmAlarm) {
            AddClockAlarm();
            AlarmPanelThree.add(AlarmClockLabel);


        }

    }
    public void timeMethod(){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

            }
        };

    }


    public void AddClockAlarm() {

        AlarmTime = textField.getText();
        System.out.println(AlarmTime);
        //  System.out.println(Time);
        //  System.out.println("confirmAlarm");

        AlarmClockLabel = new JLabel();
        ImageIcon image = new ImageIcon("C:\\Users\\Luis\\Downloads\\clockanimation.jpg");
        AlarmClockLabel.setIcon(image);
        AlarmClockLabel.setText(AlarmTime);
        AlarmClockLabel.setHorizontalTextPosition(JLabel.CENTER);
        AlarmClockLabel.setVerticalTextPosition(JLabel.TOP);
        AlarmClockLabel.setForeground(Color.white);
        AlarmClockLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        AlarmClockLabel.setPreferredSize(new Dimension(100, 100));

    }


    public void UpdateTime() {
        while (true) {

            Time = timeFormat.format(calendar.getInstance().getTime());
            TimeLabel.setText(Time);

            if (AlarmTime == Time) {
                System.out.println("RING");
            }

            try {

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }



    }
}


