/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

/**
 *
 * @author sc
 */
public enum CourseType {
    Basic("Perusopinnot"), 
    Advanced("Syventävät opinnot"), 
    Subject("Aineopinnot");
    
    private final String name;
    
    private CourseType(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
