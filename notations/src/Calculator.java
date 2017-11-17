import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Long.*;


public class Calculator extends JFrame {
    private JButton jb1, jb2, jb3, jb4, jb5, jb6;
    private JButton jbN1, jbN2, jbN3, jbN4, jbN5, jbN6, jbN7, jbN8, jbN9,jbN0, jbNA, jbNB, jbNC, jbND, jbNE, jbNF, jb10;
    private JTextField jt;
    private JButton  deleteLastDigit, c, ce;
    private String numC;
    private String operation, expression;
    private boolean real, real_first;

    public Calculator() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setLayout(new GroupLayout(getContentPane()));

        this.setBounds(0, 0, 240, 510);

        jt = new JTextField();
        add(jt);
        jt.setBounds(0, 0, 241, 75);

        jb1 = new JButton("в 2");
        jb2 = new JButton("из 2");
        jb3 = new JButton("в 8");
        jb4 = new JButton("из 8");
        jb5 = new JButton("в 16");
        jb6 = new JButton("из 16");



        jbN1 = new JButton("1");
        jbN2 = new JButton("2");
        jbN3 = new JButton("3");
        jbN4 = new JButton("4");
        jbN5 = new JButton("5");
        jbN6 = new JButton("6");
        jbN7 = new JButton("7");
        jbN8 = new JButton("8");
        jbN9 = new JButton("9");
        jbN0 = new JButton("0");
        jbNA = new JButton("A");
        jbNB = new JButton("B");
        jbNC = new JButton("C");
        jbND = new JButton("D");
        jbNE = new JButton("E");
        jbNF = new JButton("F");

        deleteLastDigit = new JButton("<");
        c = new JButton("c");
        ce = new JButton("ce");

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);



        this.add(jbN1);
        this.add(jbN2);
        this.add(jbN3);
        this.add(jbN4);
        this.add(jbN5);
        this.add(jbN6);
        this.add(jbN7);
        this.add(jbN8);
        this.add(jbN9);
        this.add(jbN0);
        this.add(jbNA);
        this.add(jbNB);
        this.add(jbNC);
        this.add(jbND);
        this.add(jbNE);
        this.add(jbNF);

        this.add(deleteLastDigit);
        this.add(c);
        this.add(ce);


        jb1.setBounds(0, 75, 60, 50);
        jb2.setBounds(60, 75, 60, 50);
        jb3.setBounds(120, 75, 60, 50);
        jb4.setBounds(0, 125, 60, 50);
        jb5.setBounds(60, 125, 60, 50);
        jb6.setBounds(120, 125, 60, 50);
        jbN1.setBounds(0, 185, 60, 50);
        jbN2.setBounds(60, 185, 60, 50);
        jbN3.setBounds(120, 185, 60, 50);
        jbN4.setBounds(0, 235, 60, 50);
        jbN5.setBounds(60, 235, 60, 50);
        jbN6.setBounds(120, 235, 60, 50);
        jbN7.setBounds(0, 285, 60, 50);
        jbN8.setBounds(60, 285, 60, 50);
        jbN9.setBounds(120, 285, 60, 50);
        jbNA.setBounds(0, 335, 60, 50);
        jbNB.setBounds(60, 335, 60, 50);
        jbNC.setBounds(120, 335, 60, 50);
        jbND.setBounds(0, 385, 60, 50);
        jbNE.setBounds(60, 385, 60, 50);
        jbNF.setBounds(120, 385, 60, 50);
        jbN0.setBounds(60, 435, 60, 50);

        deleteLastDigit.setBounds(180, 185, 60,50);
        c.setBounds(180, 235, 60,50);
        ce.setBounds(180, 285, 60,50);

        this.setVisible(true);

        numC = "";
        real = false;
        real_first = true;
        operation = "";
        expression = "";


        jbN1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="1";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "1";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="2";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "2";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="3";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "3";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="4";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "4";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="5";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "5";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="6";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "6";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="7";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "7";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="8";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "8";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="9";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "9";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbN0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="0";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "0";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });

        jbNA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="A";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "A";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbNB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="B";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "B";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbNC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="C";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "C";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbND.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="D";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "D";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbNE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="E";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "E";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        jbNF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals(""))
                        numC =(jt.getText());
                    if (!real) {
                        numC +="F";
                        jt.setText(numC + "");
                    } else {
                        String n = numC;
                        if (real_first) {
                            n = n.substring(0, n.length() - 1);
                            real_first = false;
                        }
                        n = n + "F";
                        System.out.println(n);
                        numC = n;
                        jt.setText(numC + "");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });

        /**
         * перевод в 2
         */
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (numC.contains("A")||numC.contains("B")||numC.contains("C")||numC.contains("D")||
                            numC.contains("E")||numC.contains("F")){

                        numC = String.valueOf(Integer.parseInt(numC,16));
                        System.out.println(numC + "num C"); //в 10

                    }
                    int result = Integer.parseInt(numC);
                    numC = toBinaryString(result);
                    jt.setText(numC);



                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }

            }
        });
        /**
         * перевод в 10 из 2
         */
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numC = (valueOf(numC, 2)).toString();
                    jt.setText(numC);
                }catch ( NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }

            }
        });
        /**
         * перевод в 8
         */
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (numC.contains("A")||numC.contains("B")||numC.contains("C")||numC.contains("D")||
                            numC.contains("E")||numC.contains("F")){

                        numC = String.valueOf(Integer.parseInt(numC,16));
                        System.out.println(numC + "num C"); //в 10

                    }
                    int result = Integer.parseInt(numC);
                    numC = toOctalString(result);
                    jt.setText(numC);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        /**
         * перевод в 10 из 8
         */
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Before:  " + valueOf(numC));
                    numC = (valueOf(numC, 8)).toString();
                    jt.setText(numC);
                    System.out.println(numC + "num C");
                }catch ( NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }

            }
        });
        /**
         * перевод в 16
         */

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = Integer.parseInt(numC);
                    numC = toHexString(result);
                    jt.setText(numC);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        /**
         * перевод в 10 из 16
         */
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     numC = String.valueOf(Integer.parseInt(numC, 16));
                     System.out.println(numC + "num C");
                     jt.setText(numC);
                 }catch (NumberFormatException ex){
                     JOptionPane.showMessageDialog(null, "Number Format Exception");
                 }

            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numC = "";
                    real = false;
                    real_first = true;
                    operation = "";
                    expression = "";
                    jt.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
        ce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numC = "";
                    real = false;
                    real_first = true;
                    jt.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });

        deleteLastDigit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!jt.getText().equals("")) {
                        numC = (jt.getText());

                        if (!real) {
                            numC = numC.substring(0,numC.length()-1);
                            jt.setText(numC + "");
                        } else {
                            if (real_first) {
                                jt.setText( numC + "");
                                real = false;
                                real_first = true;
                            } else {
                                String n = numC;
                                n = n.substring(0, n.length() - 1);
                                System.out.println(n);
                                numC = n;
                                jt.setText(numC + "");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Exception");
                }
            }
        });
    }
    public static void main(String[] args) {
        new Calculator();
    }
}