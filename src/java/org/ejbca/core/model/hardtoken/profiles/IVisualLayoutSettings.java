/*************************************************************************
 *                                                                       *
 *  EJBCA: The OpenSource Certificate Authority                          *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
 
package org.ejbca.core.model.hardtoken.profiles;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.IOException;

import org.ejbca.core.model.ra.UserDataVO;






/**
 * Interface contating methods that need to be implementet in order 
 * to have a hard token profile contain Visual Layout, either as a label
 * or used with cardprinter.
 * 
 * @version $Id: IVisualLayoutSettings.java 8373 2009-11-30 14:07:00Z jeklund $
 */

public interface IVisualLayoutSettings {


	/**
	 * Constant indicating that no visual layout should be printed.
	 */    
	public static int VISUALLAYOUTTYPE_NONE               = 0;
    /**
     * Constants indicating what type of visual layout that should be
     * should be printed.
     */ 
    public static int VISUALLAYOUTTYPE_GENERALLABEL       = 1;
	public static int VISUALLAYOUTTYPE_GENERALCARDPRINTER = 2;

    /**      
     * @return the type of visual layout to print.
     */
    public abstract int getVisualLayoutType();    

	/**      
	 * sets the visual layout type.
	 */
	public abstract void setVisualLayoutType(int type);    
    
    /**
     * @return the filename of the current visual layout template.
     */
    public abstract String getVisualLayoutTemplateFilename();

	/**
	 * Sets the filename of the current visual layout template.
	 */    
	public abstract void setVisualLayoutTemplateFilename(String filename);
    
	/**
	 * Returns the image data of the visual layout, should be a SVG image.
	 */
	public abstract String getVisualLayoutData();		
	 

	/**
	 * Sets the imagedata of the visual layout.
	 */
	public abstract void setVisualLayoutData(String templatedata);
	

   /**
    * Method that parses the template, replaces the userdata
    * and returning a printable byte array 
    */	
	public abstract Printable printVisualValidity(UserDataVO userdata, 
	                                        String[] pincodes, String[] pukcodes,
	                                        String hardtokensn, String copyoftokensn)
	                                          throws IOException, PrinterException;
}

