package com.thanglequoc.aqicalculator;


/**
 * 
 * */
public class GeneralAQIMessage {
    
    
    private Index index;
    private String category;
    private String message;
    
    GeneralAQIMessage() {
	// TODO Auto-generated constructor stub
    }

    
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


    /**
     * @param index the index to set
     */
    void setIndex(Index index) {
        this.index = index;
    }


    /**
     * @param category the category to set
     */
    void setCategory(String category) {
        this.category = category;
    }


    /**
     * @param message the message to set
     */
    void setMessage(String message) {
        this.message = message;
    }
    
    
    
   
    
    
    
    
}
