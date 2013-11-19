/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.util.Map;

/**
 *
 * @author john.woodhouse
 */
public class RelationType 
{
    private int id;
    private String type;
    private String maleName;
    private String femaleName;
    private String inverseMaleName;
    private String inverseFemaleName;
    private String neutralName;
    private Map<Integer, String> relationNumber;
}
