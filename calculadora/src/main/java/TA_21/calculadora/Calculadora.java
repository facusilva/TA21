package TA_21.calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Calculadora extends JFrame {

	// Declaro los atributos de la clase
	private JPanel contentPane;
	double num1;
	double num2;
	double res;
	String operando;
	JTextField textField;
	JButton btnSumar;
	JButton btnRestar;
	JButton btnMultiplicar;
	JButton btnDividir;
	JButton btnCalcular;
	JButton btnClear;
	JButton btnNum1;
	JButton btnNum2;
	JButton btnNum3;
	JButton btnNum4;
	JButton btnNum5;
	JButton btnNum6;
	JButton btnNum7;
	JButton btnNum8;
	JButton btnNum9;
	JButton btnNum0;

	// Declaro el constructor de la clase
	public Calculadora() {
		//pongo nombre a la ventana
		setTitle("Calculadora");
		//defino la operación al darle al botón de cerrar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//defino el tamaño de la ventana
		setBounds(100, 100, 450, 300);
		//creo un contentPane donde meteré los elementos que conformarán la calculadora
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//añado y posiciono todos los elementos que estarán dentro del contentPane
		btnSumar = new JButton("+");
		btnSumar.setBounds(335, 73, 89, 23);
		contentPane.add(btnSumar);

		btnRestar = new JButton("-");
		btnRestar.setBounds(335, 107, 89, 23);
		contentPane.add(btnRestar);

		btnMultiplicar = new JButton("*");
		btnMultiplicar.setBounds(335, 141, 89, 23);
		contentPane.add(btnMultiplicar);

		btnDividir = new JButton("/");
		btnDividir.setBounds(335, 175, 89, 23);
		contentPane.add(btnDividir);

		btnCalcular = new JButton("=");
		btnCalcular.setBounds(335, 209, 89, 23);
		contentPane.add(btnCalcular);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(10, 11, 414, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		btnNum7 = new JButton("7");
		btnNum7.setBounds(10, 73, 89, 23);
		contentPane.add(btnNum7);

		btnNum8 = new JButton("8");
		btnNum8.setBounds(109, 73, 89, 23);
		contentPane.add(btnNum8);

		btnNum9 = new JButton("9");
		btnNum9.setBounds(208, 73, 89, 23);
		contentPane.add(btnNum9);

		btnNum4 = new JButton("4");
		btnNum4.setBounds(10, 107, 89, 23);
		contentPane.add(btnNum4);

		btnNum5 = new JButton("5");
		btnNum5.setBounds(109, 107, 89, 23);
		contentPane.add(btnNum5);

		btnNum6 = new JButton("6");
		btnNum6.setBounds(208, 107, 89, 23);
		contentPane.add(btnNum6);

		btnNum1 = new JButton("1");
		btnNum1.setBounds(10, 141, 89, 23);
		contentPane.add(btnNum1);

		btnNum2 = new JButton("2");
		btnNum2.setBounds(109, 141, 89, 23);
		contentPane.add(btnNum2);

		btnNum3 = new JButton("3");
		btnNum3.setBounds(208, 141, 89, 23);
		contentPane.add(btnNum3);

		btnNum0 = new JButton("0");
		btnNum0.setBounds(109, 175, 89, 23);
		contentPane.add(btnNum0);

		btnClear = new JButton("Clear");
		btnClear.setBounds(208, 209, 89, 23);
		contentPane.add(btnClear);

		// evento al apretar el botón "+"
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonOperando("+");
				}catch(NumberFormatException ex) {//capturo la excepción al intentar asignar un número cuando el usuario no ha introducido ningún valor
					JOptionPane.showMessageDialog(null, "Debes introducir un número!!");
				}
			}
		});

		// evento al apretar el botón "-"
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonOperando("-");
				}catch(NumberFormatException ex) {//capturo la excepción al intentar asignar un número cuando el usuario no ha introducido ningún valor
					JOptionPane.showMessageDialog(null, "Debes introducir un número!!");
				}
			}
		});

		// evento al apretar el botón "*"
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonOperando("*");
				}catch(NumberFormatException ex) {//capturo la excepción al intentar asignar un número cuando el usuario no ha introducido ningún valor
					JOptionPane.showMessageDialog(null, "Debes introducir un número!!");
				}
			}
		});

		// evento al apretar el botón "/"
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonOperando("/");
				}catch(NumberFormatException ex) {//capturo la excepción al intentar asignar un número cuando el usuario no ha introducido ningún valor
					JOptionPane.showMessageDialog(null, "Debes introducir un número!!");
				}
			}
		});

		// evento al apretar el botón "="
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mostrar resultado en pantalla
				try {
					asignarNum2();
					if(num2 == 0 && operando.equals("/")) {
						throw new ArithmeticException();
					}
					setRes(calcular());
					textField.setText("" + res);
				}catch(ArithmeticException ex) {//capturo la excepción que se lanza la intentar dividir entre 0 y se lo informo al usuario
					JOptionPane.showMessageDialog(null, "No se puede dividir entre 0!!");
				}catch(NumberFormatException ex) {//capturo la excepción al intentar asignar un número cuando el usuario no ha introducido ningún valor
					JOptionPane.showMessageDialog(null, "Debes introducir un número!!");
				}catch(NullPointerException ex) {//capturo la excepción que se da cuando el usuario intenta obtener el resultado sin haber elegido un operando
					JOptionPane.showMessageDialog(null, "Tienes que elegir el operando!!");
				}

			}
		});

		// evento al pulsar el botón "clear"
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});

		// evento al pulsar el botón "1"
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "1");
			}
		});

		// evento al pulsar el botón "2"
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "2");
			}
		});

		// evento al pulsar el botón "3"
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "3");
			}
		});

		// evento al pulsar el botón "4"
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "4");
			}
		});

		// evento al pulsar el botón "5"
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "5");
			}
		});

		// evento al pulsar el botón "6"
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "6");
			}
		});

		// evento al pulsar el botón "7"
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "7");
			}
		});

		// evento al pulsar el botón "8"
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "8");
			}
		});

		// evento al pulsar el botón "9"
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "9");
			}
		});

		// evento al pulsar el botón "0"
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();
				textField.setText(texto + "0");
			}
		});
		setVisible(true);
	}

	//asigna el operando correspondiente al botón apretado y asigna el número en el JTextField al atributo num1
	public void botonOperando(String operando) {
		setOperando(operando);
		asignarNum1();
	}
	
	//hago que el JFrame sea visible
	public void visible() {
		setVisible(true);
	}
	
	//seteo todos los valores a 0 y vacío el campo de texto
	public void clear() {
		setNum1(0);
		setNum2(0);
		setRes(0);
		textField.setText("");
	}

	//calcula el resultado de la operación a partir de los atributos num1, num2 y operando
	public double calcular() {
		double r = 0;
		switch (operando) {
		case "+":
			r = num1 + num2;
			break;
		case "-":
			r = num1 - num2;
			break;
		case "*":
			r = num1 * num2;
			break;
		case "/":
			r = num1 / num2;
			break;
		}
		return r;
	}

	//recoge el texto del campo de texto y lo asigna al atributo num1
	public void asignarNum1() {
		double numero = Double.parseDouble(textField.getText());
		setNum1(numero);
		textField.setText("");
	}

	//recoge el texto del campo de texto y lo asigna al atributo num2
	public void asignarNum2() {
		double numero = Double.parseDouble(textField.getText());
		setNum2(numero);
		textField.setText("");
	}

	// Getters y Setters
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}
}
