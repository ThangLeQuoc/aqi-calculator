package com.thanglequoc.aqicalculator;

/**
 * Object to map to json file, contain an index and it corresponding category
 * and message
 * 
 * @author ThangLeQuoc
 */

class GeneralAQIMessage {

    private Index index;
    private String category;
    private String message;

    GeneralAQIMessage(Index index, String category, String message) {
	this.index = index;
	this.category = category;
	this.message = message;
    }

    Index getIndex() {
	return index;
    }

    String getCategory() {
	return category;
    }

    String getMessage() {
	return message;
    }

}
