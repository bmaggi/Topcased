/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tristan Faure (Atos Origin) tristan.faure@atosorigin.com,
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/

package org.topcased.modeler.createtemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An utility class
 */
public class Utils {

	 /**
     * Perform directory.
     * recursive method to copy folder
     * 
     * @param inputFile the input file
     * @param outputFile the output file
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void copyFolder(File inputFile, File outputFile) throws IOException
    {
        String[] children = inputFile.list();
        for (int p = 0; p < children.length; p++)
        {
            File f = new File(inputFile + File.separator + children[p]);
            File f1 = new File(outputFile + File.separator + children[p]);
            copyFile(f, f1);
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException 
    {
        if (sourceFile.isDirectory())
        {
            destFile.mkdir();
            copyFolder(sourceFile,destFile);
        }
        else
        {
            if(!destFile.exists()) {
                destFile.createNewFile();
            }
            
            FileChannel source = null;
            FileChannel destination = null;
            try {
                source = new FileInputStream(sourceFile).getChannel();
                destination = new FileOutputStream(destFile).getChannel();
                destination.transferFrom(source, 0, source.size());
            }
            finally {
                if(source != null) {
                    source.close();
                }
                if(destination != null) {
                    destination.close();
                }
            }
        }
    }
    
    /**
     * Replace the given oldvalue by the newvalue in the given file.
     * Note that oldValue and NewValue must be a complete line.
     * 
     * @param oldValue the old value
     * @param newValue the new value
     * @param file the file
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
	public static void fileReplaceCharSequence(String oldValue, String newValue, File file) throws IOException
	{
		// Create a pattern to match the oldValue
		Pattern p = Pattern.compile(oldValue);
		
		File tmpFile = new File(file.getPath() + ".tmp");
        OutputStream os = new FileOutputStream(tmpFile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));

        // Create an inputstream on the channel
        InputStream is = new FileInputStream(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        String aLine = null;
        
        Matcher matcher = null;
        while((aLine = in.readLine()) != null) 
        {
        	matcher = p.matcher(aLine);
          	if(matcher.find())
          	{
          		aLine = aLine.replaceAll(oldValue, newValue);	
          	}
          	out.write(aLine);
      		out.newLine();
        }
        in.close();
        out.close();
        file.delete();
        tmpFile.renameTo(file);
	}
	
	/**
     * Same has fileReplaceCharSequence(String oldValue, String newValue, File file) throws IOException 
     * but with a map of values
     * Note that oldValue and NewValue must be a complete line.
     * 
     * @param values a map of values. The keys are the oldValues. 
     * @param file the file
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
	public static void fileReplaceCharSequence(Map<String, String> values, File file) throws IOException
	{
		File tmpFile = new File(file.getPath() + ".tmp");
        OutputStream os = new FileOutputStream(tmpFile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));

        // Create an inputstream on the channel
        InputStream is = new FileInputStream(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));   

        String aLine = null;
        
        while((aLine = in.readLine()) != null) 
        {
        	for(String key : values.keySet())
        	{
        		if(aLine.contains(key))
        		{
        			aLine = aLine.replaceAll(key, values.get(key));
        			break;
        		}
        	}
        	out.write(aLine);
      		out.newLine();
        }
        in.close();
        out.close();
        file.delete();
        tmpFile.renameTo(file);
	}

}
