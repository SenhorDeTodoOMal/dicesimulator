/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.fts.enear.jprog.dice;

/**
 * Interface to represent generic dice
 * @author Francisco Tiago Soares
 * @param <T> T represents the type of result this die has on its faces
 */
public interface Die<T> {
    
    /**
     * 
     * 
     * @return array of face values of dice in order
     */
    public T[] getFaces();
}
