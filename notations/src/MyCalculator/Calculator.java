package MyCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb0, point, add, sub, mult, div, equals, ce, c,
            deleteLastDigit, plus_min;
    private JTextField jt, expr;
    private double num, number1, number2, result;
    private String operation, expression;
    private boolean real, real_first;


    public Calculator() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Calc");
        this.setLayout(new GroupLayout(getContentPane()));

        this.setBounds(0, 0, 256, 389);

        expr = new JTextField();
        add(expr);
        expr.setBounds(0, 0, 241, 50);

        jt = new JTextField();
        add(jt);
        jt.setBounds(0, 50, 241, 50);

        ce = new JButton("CE");
        c = new JButton("C");
        deleteLastDigit = new JButton("< =");
        jb1 = new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jb4 = new JButton("4");
        jb5 = new JButton("5");
        jb6 = new JButton("6");
        jb7 = new JButton("7");
        jb8 = new JButton("8");
        jb9 = new JButton("9");
        jb0 = new JButton("0");
        point = new JButton(".");
        plus_min = new JButton("±");
        add = new JButton("+");
        sub = new JButton("-");
        mult = new JButton("*");
        div = new JButton("/");
        equals = new JButton("=");

        this.add(ce);
        this.add(c);
        this.add(deleteLastDigit);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);
        this.add(jb7);
        this.add(jb8);
        this.add(jb9);
        this.add(jb0);
        this.add(point);
        this.add(plus_min);
        this.add(add);
        this.add(sub);
        this.add(mult);
        this.add(div);
        this.add(equals);

        ce.setBounds(0, 100, 60, 50);
        c.setBounds(60, 100, 60, 50);
        deleteLastDigit.setBounds(120, 100, 60, 50);
        jb1.setBounds(0, 150, 60, 50);
        jb2.setBounds(60, 150, 60, 50);
        jb3.setBounds(120, 150, 60, 50);
        jb4.setBounds(0, 200, 60, 50);
        jb5.setBounds(60, 200, 60, 50);
        jb6.setBounds(120, 200, 60, 50);
        jb7.setBounds(0, 250, 60, 50);
        jb8.setBounds(60, 250, 60, 50);
        jb9.setBounds(120, 250, 60, 50);
        jb0.setBounds(60, 300, 60, 50);
        plus_min.setBounds(0, 300, 60, 50);
        point.setBounds(120, 300, 60, 50);
        add.setBounds(180, 100, 60, 50);
        sub.setBounds(180, 150, 60, 50);
        mult.setBounds(180, 200, 60, 50);
        div.setBounds(180, 250, 60, 50);
        equals.setBounds(180, 300, 60, 50);

        num = 0;
        number1 = 0;
        number2 = 0;
        real = false;
        real_first = true;
        operation = "";
        expression = "";

        this.setVisible(true);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 1;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "1";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибочка");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 2;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "2";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 3;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "3";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 4;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "4";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 5;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "5";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 6;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "6";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 7;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "7";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 8;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "8";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10 + 9;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "9";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        jb0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    if (!real) {
                        num = num * 10;
                        jt.setText((int) num + "");
                    } else {
                        String n = Double.toString(num);
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "0";
                        System.out.println(n);
                        num = new Double(n);
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!real) {
                        real = true;
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        plus_min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;
                    if (!real) {
                        num = -1 * num;
                        jt.setText((int) num + "");
                    } else {
                        num = -1 * num;
                        jt.setText(num + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        ce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    num = 0;
                    real = false;
                    real_first = true;
                    jt.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    num = 0;
                    number1 = 0;
                    number2 = 0;
                    real = false;
                    real_first = true;
                    operation = "";
                    expression = "";
                    expr.setText("");
                    jt.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        deleteLastDigit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals("")) {
                        num = Double.parseDouble(jt.getText());

                        if (!real) {
                            num = num / 10;
                            jt.setText((int) num + "");
                        } else {
                            if (real_first) {
                                jt.setText((int) num + "");
                                real = false;
                                real_first = true;
                            } else {
                                String n = Double.toString(num);
                                n = n.substring(0, n.length() - 1);
                                System.out.println(n);
                                num = new Double(n);
                                jt.setText(num + "");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;
                    operation = "+";
                    number1 = num;
                    jt.setText("0");
                    if (real_first) {
                        expression = Integer.toString((int) num) + " " + operation;
                    } else {
                        expression = Double.toString(num) + " " + operation;
                    }
                    expr.setText(expression);
                    real = false;
                    real_first = true;
                    num = 0;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;
                    operation = "-";
                    number1 = num;
                    jt.setText("0");
                    if (real_first) {
                        expression = Integer.toString((int) num) + " " + operation;
                    } else {
                        expression = Double.toString(num) + " " + operation;
                    }
                    expr.setText(expression);
                    real = false;
                    real_first = true;
                    num = 0;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;
                    operation = "*";
                    number1 = num;
                    jt.setText("0");
                    if (real_first) {
                        expression = Integer.toString((int) num) + " " + operation;
                    } else {
                        expression = Double.toString(num) + " " + operation;
                    }
                    expr.setText(expression);
                    real = false;
                    real_first = true;
                    num = 0;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;
                    operation = "/";
                    number1 = num;
                    jt.setText("0");
                    if (real_first) {
                        expression = Integer.toString((int) num) + " " + operation;
                    } else {
                        expression = Double.toString(num) + " " + operation;
                    }
                    expr.setText(expression);
                    real = false;
                    real_first = true;
                    num = 0;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        num = Double.parseDouble(jt.getText());
                    else
                        num = 0;

                    number2 = num;

                    if (operation.equals("+")) {
                        result = number1 + number2;
                    } else if (operation.equals("-")) {
                        result = number1 - number2;
                    } else if (operation.equals("*")) {
                        result = number1 * number2;
                    }
                    else if (operation.equals("/")) {
                        result = number1 / number2;
                    }
                    if (real_first) {
                        expression = expression + " " + Integer.toString((int) num) + " = ";
                    } else {
                        expression = expression + " " + Double.toString(num) + " = ";
                    }
                    expr.setText(expression);
                    num = 0;
                    if (!real && !operation.equals("/"))
                        jt.setText((int) result + "");
                    else
                        jt.setText(result + "");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();
    }
}