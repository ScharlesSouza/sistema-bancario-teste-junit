package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    
    @Test
    void testAddMovimentacao() {
        //TODO: Você precisa implementar este teste
    }
    
    @Test
    void testSetNumeroValido(){
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);     
    }
    
    @Test
    void testSetNumeroInvalidoExcecao(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, ()->instance.setNumero(invalido));
    }
    
    @Test
    void testSetNumeroInvalidoNaoArmazena(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, ()->instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotEquals(invalido, obtido);
    }
    @Test
    void testNumeroNull(){
        final Conta instance = new Conta();
        assertThrows(NullPointerException.class, ()->instance.setNumero(null));
    }
    
    @Test
    void testInstancePadraoPoupanca(){
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    @Test
    void testSetLimiteContaEspecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    @Test
    void testSetLimiteContaNaoEspecial(){
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, ()->instance.setLimite(limite));   
    }
    
    @Test
    void historicoNotNull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
    
    @Test
    void testGetSaldoTotal(){
        final double limite = 500;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getLimite();
        assertEquals(obtido, esperado);
    }
    
    @Test
    void testDepositoDinheiro(){
        final double limite = 500.6, deposito=500.8, esperado =1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        
        final double obtido = instance.getSaldoTotal();
        assertEquals(obtido, esperado, 0.001);
        
    }
    
    @Test
    void testDepositoDinheiroNegativo(){
        final double limite = 500, depositoNegativo=-200, esperado =500;//se o deposito for negativo cancela a operação e mantem o saldo e saldoTotal
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        
        
        assertThrows(IllegalArgumentException.class, ()->instance.depositoDinheiro(depositoNegativo));
        final double obtido = instance.getSaldoTotal();
        assertEquals(obtido, esperado, 0.001);
        
    }
    
}
