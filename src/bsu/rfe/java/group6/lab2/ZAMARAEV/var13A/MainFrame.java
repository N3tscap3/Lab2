package bsu.rfe.java.group6.lab2.ZAMARAEV.var13A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;
import static java.lang.Math.sin;

// Главный класс приложения, он же класс фрейма
public class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    //Результаты вычислений
    private Double result;
    //Сумма результатов
    private Double Sum = 0.;
    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    // Текстовое поле для отображения результата,
    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    //текстовое поле для вывода суммы результатов(M+)
    private JTextField textFieldM;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {
        return pow(cos(pow(E,x))+log(pow(1+y,2))+sqrt(pow(E,cos(x))+pow(sin(PI*z),2))+sqrt(1/x)+pow(cos(y),2),sin(z));
    }

    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        return (pow(1+pow(x,2),1/y))/(pow(E,sin(z)+x));
    }
    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
// Создать область с полями ввода для X и Y и Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 5);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 5);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 5);
        textFieldZ.setMaximumSize((textFieldZ.getPreferredSize()));
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        JLabel labelForM = new JLabel("Sum:");
        textFieldM = new JTextField("0", 10);
        textFieldM.setMaximumSize(textFieldM.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalStrut(20));
        hboxResult.add(labelForM);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldM);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        // Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

    }
}
