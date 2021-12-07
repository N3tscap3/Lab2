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
}
