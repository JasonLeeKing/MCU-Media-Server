/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.murillo.sdp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class SSRCGroupAttribute implements Attribute {

    private String semantics;
    private ArrayList<String> SSRCIds;

    public SSRCGroupAttribute() {
	SSRCIds = new ArrayList<String>();
    }

    public SSRCGroupAttribute(String semantics) {
        this.semantics = semantics;
	SSRCIds = new ArrayList<String>();
    }
    
    public SSRCGroupAttribute(String semantics, List<String> ssrcs) {
        this.semantics = semantics;
	this.SSRCIds = new ArrayList<String>(ssrcs);
    }
    
    @Override
    public SSRCGroupAttribute clone() {
	    return new SSRCGroupAttribute(semantics, SSRCIds);
    }
  

    @Override
    public String toString() {
        //Get value
        String value = getValue();
        //Generic attr
        return "a="+ getField() + (value!=null ? ":" + value : "") + "\r\n";
    }

    @Override
    public String getField() {
        return "ssrc-group";
    }

    @Override
    public String getValue() {
        String value = semantics;
        for (String id : SSRCIds)
            value += " " + id;
        return value;
    }

    public ArrayList<String> getSSRCIds() {
        return SSRCIds;
    }

    public void setSSRCIds(ArrayList<String> SSRCIds) {
        this.SSRCIds = SSRCIds;
    }
    
   public void addSSRCId(String ssrcId) {
       SSRCIds.add(ssrcId);
   }

    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }


}
