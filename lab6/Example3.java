package lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example3 extends JFrame{
    JTextArea jta = new JTextArea("");
    public Example3()
    {
        super("Font and color");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFontMenu());
        menuBar.add(createColorMenu());
        add(jta);
        setJMenuBar(menuBar);
        setSize(400, 200);
        setVisible(true);
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(operation);
    }

    private JMenu createFontMenu()
    {
        JMenu font = new JMenu("Шрифт");
        JRadioButtonMenuItem timesNewRoman = new JRadioButtonMenuItem("Times New Roman");
        JRadioButtonMenuItem msSansSerif = new JRadioButtonMenuItem("MS Sans Serif");
        JRadioButtonMenuItem courierNew = new JRadioButtonMenuItem("Courier New");
        ButtonGroup but = new ButtonGroup();
        but.add(timesNewRoman);
        but.add(msSansSerif);
        but.add(courierNew);
        font.add(timesNewRoman);
        font.add(msSansSerif);
        font.add(courierNew);
        timesNewRoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setFont(new Font("Times New Roman", Font.BOLD,18));
            }
        });
        msSansSerif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setFont(new Font("MS Sans Serif", Font.BOLD,18));
            }
        });
        courierNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setFont(new Font("Courier New", Font.BOLD,18));
            }
        });
        return font;
    }
    private JMenu createColorMenu() {
        JMenu color = new JMenu("Цвет");
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Черный");
        ButtonGroup but = new ButtonGroup();
        but.add(blue);
        but.add(red);
        but.add(black);
        color.add(blue);
        color.add(red);
        color.add(black);
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setForeground(Color.BLUE);
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setForeground(Color.RED);
            }
        });
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                jta.setForeground(Color.BLACK);
            }
        });
        return color;
    }

    public static void main(String[] args) {
        new Example3();
    }
}
