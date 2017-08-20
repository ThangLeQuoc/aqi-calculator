package com.thanglequoc.aqicalculator;

/**
 * Object to map to json file, contain an index and it corresponding category and message
 * 
 * @author ThangLeQuoc
 * */


public class GeneralAQIMessage {
    
    /**
     * The index
     * */
    private Index index;
    
    /**
     * The category
     * */
    private String category;
    
    /**
     * The message
     * */
    private String message;
    

    /**
     * @param index
     * @param category
     * @param message
     */
    GeneralAQIMessage(Index index, String category, String message) {
	this.index = index;
	this.category = category;
	this.message = message;
    }


    /**
     * @return the index
     */
    Index getIndex() {
        return index;
    }


    /**
     * @return the category
     */
    String getCategory() {
        return category;
    }


    /**
     * @return the message
     */
    String getMessage() {
        return message;
    }


}
