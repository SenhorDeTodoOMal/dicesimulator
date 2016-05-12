/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.fts.enear.jprog.dice;

/**
 * This class is an implementation of @link Dice
 * @author Francisco Tiago Soares
 */
public class D6 implements Die<Integer>{
    
    @Override
    public Integer[] getFaces() {
        return new Integer[]{1,2,3,4,5,6};
    }
    
}
