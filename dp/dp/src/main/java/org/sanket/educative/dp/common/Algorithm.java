package org.sanket.educative.dp.common;

/**
 * Defines a common interhace for any Algorithm
 */
public interface Algorithm{
    /**
     *  Gets the name of the Algorithm
     * @return
     */ 
    public String getName();

    /**
     * Executes the Algorithm
     */
    public void execute();

}