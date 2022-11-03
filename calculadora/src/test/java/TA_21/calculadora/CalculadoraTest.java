package TA_21.calculadora;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

public class CalculadoraTest {

	static Calculadora calc;
	
	@BeforeAll
	public static void before() {
		calc=new Calculadora();

	}
	
	@Test
	public void testExcepciones() {
		calc.btnCalcular.doClick();
		calc.btnNum1.doClick();
		calc.clear();
		calc.btnSumar.doClick();
		calc.btnRestar.doClick();
		calc.btnDividir.doClick();
		calc.btnMultiplicar.doClick();
		calc.btnCalcular.doClick();
		
	}
	
	@Test
	public void testSuma() {
		calc.btnNum1.doClick();
		calc.btnNum2.doClick();
		calc.btnNum3.doClick();
		calc.btnSumar.doClick();
		calc.btnNum4.doClick();
		calc.btnCalcular.doClick();
		double esper = 127;
		double resul = calc.getRes();
		assertEquals(esper,resul);
		calc.clear();
	}
	
	@Test
	public void testResta() {
		calc.btnNum5.doClick();
		calc.btnNum6.doClick();
		calc.btnNum7.doClick();
		calc.btnRestar.doClick();
		calc.btnNum8.doClick();
		calc.btnCalcular.doClick();
		double esper = 559;
		double resul = calc.getRes();
		assertEquals(esper,resul);
		calc.clear();
	}
	
	@Test
	public void testMultiplicacion() {
		calc.btnNum9.doClick();
		calc.btnMultiplicar.doClick();
		calc.btnNum2.doClick();
		calc.btnCalcular.doClick();
		double esper = 18;
		double resul = calc.getRes();
		assertEquals(esper,resul);
		calc.clear();
	}
	
	@Test
	public void testDivision1() {
		calc.btnNum9.doClick();
		calc.btnDividir.doClick();
		calc.btnNum0.doClick();
		calc.btnCalcular.doClick();
		double esper = 0;
		double resul = calc.getRes();
		assertEquals(esper,resul);
		calc.clear();
	}
	
	@Test
	public void testDivision2() {
		calc.btnNum8.doClick();
		calc.btnDividir.doClick();
		calc.btnNum2.doClick();
		calc.btnCalcular.doClick();
		double esper = 4;
		double resul = calc.getRes();
		assertEquals(esper,resul);
		calc.clear();
	}
	
	@Test
	public void testGetOperando() {
		calc.setOperando("+");
		String esper = "+";
		String resul = calc.getOperando();
		assertEquals(esper,resul);
	}
	
	@Test
	public void testClear() {
		calc.btnClear.doClick();
	}
	
	@Test
	public void testAsignarNum1() {
		calc.textField.setText("1");
		calc.asignarNum1();
		double esper = 1;
		double resul = calc.getNum1();
		assertEquals(esper,resul);
	}
	
	@Test
	public void testAsignarNum2() {
		calc.textField.setText("2");
		calc.asignarNum2();
		double esper = 2;
		double resul = calc.getNum2();
		assertEquals(esper,resul);
	}
	
	@Test
	public void testSetRes() {
		calc.setRes(3);
		double esper = 3;
		double resul = calc.getRes();
		assertEquals(esper,resul);
	}
	
	@Test
	public void testVisible() {
		calc.visible();
	}

	

}
