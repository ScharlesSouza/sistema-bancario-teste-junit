package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste base para implementação dos testes
 * unitários para a classe {@link Movimentacao}.
 * Os testes foram gerados pelo IDE apenas como modelo
 * (fiz apenas algumas melhorias de boas práticas 
 * como tirar visibilidade public e definir variáveis como final).
 * 
 * Assim, NENHUM DELES FUNCIONA E O CÓDIGO PRECISA SER ALTERADO
 * de acordo com as regras de negócio dos métodos da classe {@link Movimentacao}.
 * Ao iniciar a alteração de um teste aqui,
 * a primeira coisa a fazer é remover a chamada de fail(),
 * que indica que o teste é apenas um protótipo.
 * 
 * @author Manoel Campos da Silva Filho
 */
class MovimentacaoTest {
    @Test
    void testGetId() {
        final Movimentacao instance = new Movimentacao(new Conta());
        final long esperado = 1;
        instance.setId(esperado);
        final long obtido = instance.getId();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testTipoMovimentacaoR01(){
        final Agencia agencia = new Agencia();
        agencia.setNumero("1234-5");
        final Conta conta = new Conta(agencia,true, 500);
        final Movimentacao instance = new Movimentacao(conta);
        char esperado = 'C';
        instance.setTipo(esperado);
        char obtido = instance.getTipo();
        assertEquals(esperado, obtido);
        
    }
    
    @Test
    void testValorR02(){
        final Agencia agencia = new Agencia();
        agencia.setNumero("1234-5");
        final Conta conta = new Conta(agencia,true, 500);
        final Movimentacao instance = new Movimentacao(conta);
        double esperado = 0;//para qualquer valor igual ou menor que zero o retorno sempre será zero.
        double valorMovimentacao = -2;//valor a ser inserido na movimentação        
        if(valorMovimentacao >0)//se o valor da movimentação for maior que zero , o valor do retorno esperado será o valor da movimentação
            esperado = valorMovimentacao;
        instance.setValor(esperado);
        double obtido = instance.getValor();
        assertEquals(esperado, obtido);
        
    }
    
    @Test
    void testValorDebitoR03(){
        final Agencia agencia = new Agencia();
        agencia.setNumero("1234-5");
        final Conta conta = new Conta(agencia,true, 500);
        final Movimentacao instance = new Movimentacao(conta);
        double esperado=0;//se o valor da movimentacao Debito for maior que o saldo total, o valor de retorno esperado é zero
        double valorMovimentacao = 5001;//valor a ser inserido na movimentação        
        if(valorMovimentacao < conta.getSaldoTotal())//se o valor da movimentação for menos que o saldo total, o valor do retorno esperado seráo valor da movimentação
            esperado = valorMovimentacao;
        
        instance.setValor(valorMovimentacao);
        double obtido = instance.getValor();
        assertEquals(esperado, obtido);
        
    }
    
    @Test
    void testConfirmadaR04(){
        final Agencia agencia = new Agencia();
        agencia.setNumero("1234-5");
        final Conta conta = new Conta(agencia,true, 500);
        final Movimentacao instance = new Movimentacao(conta);
        Boolean esperado = true;
        boolean obtido = instance.isConfirmada();
        assertEquals(obtido, esperado);
        
    }
    
    @Test
    void testContaR05(){
        final Agencia agencia = new Agencia();
        agencia.setNumero("1234-5");
        final Conta conta = new Conta(agencia,true, 500);        
        final Movimentacao instance = new Movimentacao(conta);
        Conta esperado=conta;
        Conta obtido = instance.getConta();
        assertEquals(obtido, esperado);
        
    }

}
