package com.thanglequoc.aqicalculator;


/**
 * 
 * */
public class GeneralAQIMessage {
    
    
    private Index index;
    private String category;
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
