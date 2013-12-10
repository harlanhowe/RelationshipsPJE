/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author harlan.howe
 * Eric Yu
 */
public class PersonalMapPane extends JPanel 
{
    // you'll want a link to your controller here.
    // TODO: add a variable to the class that holds your Controller.
    // private RelationshipData data;
    
    
    private PeopleClass currentPerson; //create variable to store currentperson
    private Controller controller; //create variable to store reference of controller
   
    private Font myFont = new Font("Times New Roman",Font.PLAIN, 10);
    // colors for the center circle, outer circles, and connecting lines.
    private Color subjectColor, objectColor, lineColor; 
    // how big the circles should be, based on the size of the window....
    private int circleDiam;

    private Relationship selectedRelationship; //stores the currently selected relationship
    
    public PersonalMapPane()
    {
        super();
        subjectColor = new Color(128,128,255);
        objectColor = new Color(128,255,128);
        lineColor = new Color(255,128,128);
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new PanelListener()); // activates the panelListener, 
                                               // so you can collect mouse clicks.
        selectedRelationship = null;// no relationship is selected...
        currentPerson = null; //set currentPerson to nobody
    }

    
    /**
     * Receives a link to the Controller - in the example case, the controller
     * class is called RelationshipData.
     * I've deactivated this method to allow compiling, but you'll need to fix
     * it up.
     * @param inData - a link to my controller class. 
     */
    // TODO: you do this! (write the setData method.)
    
    public void setData(Controller controller)
    {
        this.controller = controller; //take reference of data handler and store it in variable controller
    }

    public Relationship getSelectedRelationship() {
        return selectedRelationship;
    }

    /*
    Accesors for currentPerson
    */
    public PeopleClass getCurrentPerson(){
        return this.currentPerson;
    }
    public void setCurrentPerson(PeopleClass person){
        this.currentPerson = person;
        repaint(); //refresh the graphics
    }
    /**
     * gets the location of where you should draw the center of the circle for
     * the person at the end of a particular relationship, based on which number
     * relationship this is in the current person's list of relations. The circle
     * is divided into even wedges, defined by how many current relationships there are.
     * @param index - which position on the list of current relationships we 
     *                  are talking about
     * @param numRelationships - how many relationships there are for the current
     *                              person.
     * @return the x-coordinate of the center of the circle to be drawn, or -1 
     *          if there is a problem.
     */
    int getCenterXForObject(int index, int numRelationships)
    {
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);
        if (numRelationships>0)
            return (int)(width/2-circleDiam*4*Math.sin(2*index*Math.PI/numRelationships));
        return -1;
    }
    /**
     * gets the location of where you should draw the center of the circle for
     * the person at the end of a particular relationship, based on which number
     * relationship this is in the current person's list of relations. The circle
     * is divided into even wedges, defined by how many current relationships there are.
     * @param index - which position on the list of current relationships we 
     *                  are talking about
     * @param numRelationships - how many relationships there are for the current
     *                              person. This should be >0.
     * @return the x-coordinate of the center of the circle to be drawn, or -1 
     *          if there is a problem.
     */
    int getCenterYForObject(int index, int numRelationships)
    {
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);        
        if (numRelationships>0)
            return (int)(height/2-circleDiam*4*Math.cos(2*index*Math.PI/numRelationships));
        return -1;
    }
    /*
    Does exact same as top two methods but returns values that would be true for a panel zoomed in by two times relative to the actual one and is also centered
    Mainly for the Middle parts in the lines
    */
    
    int getCenterXForObjectHalfDistance(int index, int numRelationships)
    {
        int width = this.getBounds().width/2;//half screen size
        int height = this.getBounds().height/2;
        circleDiam = Math.min(width/10, height/10);
        if (numRelationships>0)
            return (int)(width/2-circleDiam*4*Math.sin(2*index*Math.PI/numRelationships))+width/2; //add half the screen so it is centered
        return -1;
    }

    int getCenterYForObjectHalfDistance(int index, int numRelationships)
    {
        int width = this.getBounds().width/2; //half screen size
        int height = this.getBounds().height/2;
        circleDiam = Math.min(width/10, height/10);        
        if (numRelationships>0)
            return (int)(height/2-circleDiam*4*Math.cos(2*index*Math.PI/numRelationships))+height/2; //add half the screen so it is centered
        return -1;
    }
    
    /**
     * Respond to the user clicking at (x,y) - if there is a relationship circle
     * nearby, select it.
     * @param x
     * @param y 
     */
    public void handleMouseClick(int x, int y)
    {
        ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson);
        int numRelationships = relationships.size();
        if (numRelationships ==0)
            return;
        // define the number of relationships for the current person.
        // TODO: you do this (handleMouseClick countRels)
        int numRels = numRelationships;
        
        // loop over all the relationships for the current person...
        // TODO: you do this! (handleMouseClick loop) - just write the "for"
        //       or "while" statement.
        for (int i = 0;i<numRels;i++){
            if (Math.pow(x-getCenterXForObject(i,numRels),2)+Math.pow(y-getCenterYForObject(i,numRels),2)<Math.pow(circleDiam,2))
            {
                // TODO: you do this! (handleMouseClick selectedID) - set the selectedObjectID to the id of the
                //          target of this iteration's relationship.
                //selectedObjectId = ?????
                selectedRelationship = relationships.get(i);
                
                
                
                repaint();
                return;
            }
        }
        selectedRelationship = null;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // bail out if data is null, or if nobody is selected.....
        // TODO: you do this! (paintComponent - bail)
        if (currentPerson == null)
            return;
        
        
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);
        int nameWidth;
        g.setFont(myFont);
        // loop through each of the relationships - you'll need to draw:
        //   1) the line for the relationship
        //   2) a string with a relationshipType for the line
        //   3) a circle for the related person
        //     3b) an outline for the related person, if this one is selected.
        //   4) the name of the related person
        //  You'll want to make use of getCenterXForObject(), getCenterYForObject(),
        //  lineColor, objectColor, 
        // TODO: you do this! (paintComponent - loop through relations)
        
        ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson); //get all relationships
        for (int i = 0;i<relationships.size();i++){ //iterate through each relationshisp and draw a line, an oval, text in the oval, and text betewen the line for each one
            Relationship currentRel = relationships.get(i); //store current relationship
            PeopleClass secondaryPerson = currentRel.getSecondaryPerson(); //get the secondary person
            RelationType relType = currentRel.getRelationType(); //get the relation type of the relationship
            String secondaryPersonName = secondaryPerson.getFullName(); //get name of the secodnary person
            String relationTypeName;
            if (secondaryPerson.getIsMale())//depending on whether secondary person is male or female give the person a fwdMaleName or a fwdFemaleName
                relationTypeName = relType.getFwdMaleName();
            else
                relationTypeName = relType.getFwdFemaleName();
            //create variables to store information about width/height of string that will be printed
            int stringWidth;
            int stringHeight; //I realize that hte stringHeight is 10 pixels, but I will use Java's built in methods to calculate it
            
            //draw the lines that branch off the center circle
            g.setColor(lineColor);
            g.drawLine(width/2, height/2, getCenterXForObject(i,relationships.size()), getCenterYForObject(i,relationships.size()));
            
            
            //CHECK IF THE RELATIONSHIP IS THE CURRENTLY SELECTED ONE, IF SO MAKE SMALL OUTLINE ON OVAL
            if (selectedRelationship != null){
                if (currentRel.getId() == selectedRelationship.getId()){
                    g.setColor(Color.BLACK);
                    //draw oval a little bigger than the usual circleDiam (4 pixels bigger)
                    g.fillOval(getCenterXForObject(i,relationships.size())-(circleDiam+4)/2, getCenterYForObject(i,relationships.size())-(circleDiam+4)/2, circleDiam+4, circleDiam+4);
                    
                    
                }
            }
            
            
            //draw oval
            g.setColor(objectColor);
            //center the oval by subtracting half of its diameter from x and y values
            g.fillOval(getCenterXForObject(i,relationships.size())-circleDiam/2, getCenterYForObject(i,relationships.size())-circleDiam/2, circleDiam, circleDiam);
            
            //draw the name of the secondaryPerson
            g.setColor(Color.BLACK);
            //get info on the size of the string
            stringWidth = (int)g.getFontMetrics().getStringBounds(secondaryPersonName, g).getWidth();
            stringHeight = (int)g.getFontMetrics().getStringBounds(secondaryPersonName, g).getHeight();
            //center the string by subtracting half of its width from the x value and adding half of its height to the y value
            g.drawString(secondaryPersonName, getCenterXForObject(i,relationships.size())-stringWidth/2, getCenterYForObject(i,relationships.size())+stringHeight/2);
            
            
            //clear a bit of area to draw the string
            //draw a grey box to erase part of hte line - it will be the same dimensions as the string that will be drawn
            g.setColor(Color.LIGHT_GRAY);
            //get info on the size of the string
            stringWidth = (int)g.getFontMetrics().getStringBounds(relationTypeName, g).getWidth();
            stringHeight = (int)g.getFontMetrics().getStringBounds(relationTypeName, g).getHeight();
            //center the grey box by subtracting half of its width from the x value and half of its height from its y value
            g.fillRect(getCenterXForObjectHalfDistance(i,relationships.size())-stringWidth/2, getCenterYForObjectHalfDistance(i,relationships.size())-stringHeight/2, stringWidth, stringHeight);
            
            //draw the relationTypeName string in the space you cleared out
            g.setColor(Color.BLACK);
            //draw the string and center it by subtracting half of its width from the x value and adding half of its height to the y value
            g.drawString(relationTypeName, getCenterXForObjectHalfDistance(i,relationships.size())-stringWidth/2, getCenterYForObjectHalfDistance(i,relationships.size())+stringHeight/2);
            
            
        }
        
        
        g.setColor(subjectColor);
        g.fillOval(width/2-circleDiam/2,height/2-circleDiam/2,circleDiam,circleDiam);
        
        // Get the name of the current person, and set 'mainName' to it.
        // TODO: You do this! (paintComponent - mainName)
        String mainName = currentPerson.getFullName(); //set the center circle's text to the name of currentPerson
        
        g.setColor(Color.BLACK);
        nameWidth = g.getFontMetrics().stringWidth(mainName);
        g.drawString(mainName, width/2-nameWidth/2, height/2+5);
        
    }
    
    /**
     * a custom "internal class" to deal with the mouse. It simply defers the
     *   click to the handleMouseClick() method in PersonalMapPane.
     */
    public class PanelListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent evt)
        {
            handleMouseClick(evt.getX(),evt.getY());
        }
    }
}
