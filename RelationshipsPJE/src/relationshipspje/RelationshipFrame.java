/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipspje;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author harlan.howe
 */
public final class RelationshipFrame extends javax.swing.JFrame {
    /**
     * which person is currently selected, or -1 if none are.
     */
    private int currentPersonIndex; 
    private Controller controller;
    private PeopleClass currentPerson;
    
    /**
     * Creates new form RelationshipFrame
     */
    public RelationshipFrame() {
        initComponents(); // This line is essential. Do not delete it. It must
                            // go first in the constructor. 

        // I recommend you create an instance of your controller... and give
        // a copy to your "specialty" views.
        // TODO  you do this! (constructor)
        
        
        controller = new Controller();
        controller.openPeople();
        controller.openRelTypes();
        controller.openRelationships();
        
        personalMapPane1.setData(controller);
        
        // then send the lists on screen whatever information they need to start.
        currentPersonIndex = -1;  // nobody is selected.
        currentPerson = null;
        updatePeopleList();
        updateRelationshipList();
        
    }

    /**
     * refreshes the leftmost JList on the page with new information, most often
     * at the start of the program, or when a person is added/removed.
     */
    public void updatePeopleList()
    {
        // create a new array of Strings the size of the number of people to
        //   display.
        
        // fill the array in with your names, from whatever data structure you 
        //   have.
        // TODO: You do this! (updatePeopleList - size and fill list)
        
        ArrayList<PeopleClass> people = controller.getAllPeople(); //gets all people from controller
        ArrayList<String> peopleNames = new ArrayList<String>(); //new arraylist to store names only
        for (int i = 0;i<people.size();i++){ //loops through each person and builds a string using the person's firstname and lastname while adding it to peopleNames
            peopleNames.add(people.get(i).getLastName()+", "+people.get(i).getFirstName());          
        }
        String[] names = (String[]) peopleNames.toArray(new String[peopleNames.size()]); //converts peopleNames to a primitive type
        
        
        
        // send the array of Strings to the JList of people onscreen:
        personList.setListData(names);
    }
    
    /**
     * refreshes the right hand list (the one in the "list view") with the 
     * relationships for the current person - most often at the start of the
     * program, when the selected person has changed, or when a relationship
     * is added/removed.
     */
    public void updateRelationshipList()
    {
        // create a new array of Strings the size of the number of people to
        //  display ... which might be zero if there is no selected person.
        String[] relationshipStrings;
        
        // fill the array with Strings describing each relationship for the 
        // selected person.
        // TODO: You do this! (updateRelationshipList - fill array)
        if (currentPerson!=null){
            ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson); //get all relationships for person
            ArrayList<String> relationshipInfos = new ArrayList<String>(); //create arraylist to hold information about strings.
            for (int i = 0;i<relationships.size();i++){ //iterate through each relationship

                    Relationship relationship = relationships.get(i);
                    RelationType type = relationship.getRelationType(); //get the type of the relationship
                    PeopleClass secondaryPerson = relationship.getSecondaryPerson();//get the secondary person of the relationship

                    String relationshipTypeName;
                    if (secondaryPerson.getIsMale()) //depending on the gender of the secondary person, the title will be different
                            relationshipTypeName = type.getFwdMaleName();
                    else
                            relationshipTypeName = type.getFwdFemaleName();

                    //build the 'currentPerson' has a 'relationshipTypeName', 'secondaryPerson' statement
                    String relationshipInfo = currentPerson.getLastName()+", "+currentPerson.getFirstName()+" has a "+
                            relationshipTypeName+", "+
                            relationship.getSecondaryPerson().getLastName()+", "+relationship.getSecondaryPerson().getFirstName();
                    relationshipInfos.add(relationshipInfo); //add the statement to the arraylist that stores them


            }
            relationshipStrings = (String[]) relationshipInfos.toArray(new String[relationshipInfos.size()]); //convert the arraylist of relationship infos to an string[]
            
            
        }else{
            relationshipStrings = new String[0]; //otherwise sets the relationship infos to an empty array
        }
        
        
        
        
        
        // tell the onscreen JList about the array of strings and tell it to
        // update its appearance.
        relationshipList.setListData(relationshipStrings);
        relationshipList.validate();
        
    }
    /**
     * updates the appearance of the Personal map, most often at the start of
     * the program, when the selected person changes, or when a relationship
     * is added/removed.
     */
    public void updatePersonalMap()
    {
        // make sure that the personal map has the up-to-date info and tell it
        // to update its appearance.
        // TODO: you do this! (updatePersonalMap)
       
        
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        newPersonPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        genderMaleButton = new javax.swing.JRadioButton();
        genderFemaleButton = new javax.swing.JRadioButton();
        genderButtonGroup = new javax.swing.ButtonGroup();
        newRelationshipPanel = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        relatedPersonList = new javax.swing.JList();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        addTypeButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        relTypeList = new javax.swing.JList();
        reciprocateCheckbox = new javax.swing.JCheckBox();
        addTypePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        genericRTNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fwdMaleRTNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fwdFemaleRTNameField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        revMaleRTNameField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        revFemaleRTNameField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addPersonButton = new javax.swing.JButton();
        removePersonButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        personList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        relationshipTabPanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        relationshipList = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        personalMapPane1 = new relationshipspje.PersonalMapPane();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        addRelationshipButton = new javax.swing.JButton();
        removeRelationshipButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SaveMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jLabel3.setText("First");

        firstNameField.setToolTipText("first name");

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(firstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(firstNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );

        jLabel4.setText("Last");

        lastNameField.setToolTipText("Last Name");

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .add(18, 18, 18)
                .add(lastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(lastNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .add(jLabel4))
        );

        genderButtonGroup.add(genderMaleButton);
        genderMaleButton.setText("Male");

        genderButtonGroup.add(genderFemaleButton);
        genderFemaleButton.setText("Female");

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(genderMaleButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(genderFemaleButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(genderMaleButton)
                    .add(genderFemaleButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout newPersonPanelLayout = new org.jdesktop.layout.GroupLayout(newPersonPanel);
        newPersonPanel.setLayout(newPersonPanelLayout);
        newPersonPanelLayout.setHorizontalGroup(
            newPersonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        newPersonPanelLayout.setVerticalGroup(
            newPersonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(newPersonPanelLayout.createSequentialGroup()
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Person");

        relatedPersonList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(relatedPersonList);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3)
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel7);

        jLabel6.setText("Relationship Type");

        addTypeButton.setText("+");
        addTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTypeButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(addTypeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, addTypeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        relTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(relTypeList);

        reciprocateCheckbox.setText("Create Reciprocal Relationship");

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .add(reciprocateCheckbox)
                .addContainerGap(280, Short.MAX_VALUE))
            .add(jPanel11Layout.createSequentialGroup()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel11Layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jScrollPane4))
                    .add(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(reciprocateCheckbox)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel11);

        org.jdesktop.layout.GroupLayout newRelationshipPanelLayout = new org.jdesktop.layout.GroupLayout(newRelationshipPanel);
        newRelationshipPanel.setLayout(newRelationshipPanelLayout);
        newRelationshipPanelLayout.setHorizontalGroup(
            newRelationshipPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane2)
        );
        newRelationshipPanelLayout.setVerticalGroup(
            newRelationshipPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane2)
        );

        addTypePanel.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Generic Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel7, gridBagConstraints);

        genericRTNameField.setText("jTextField1");
        genericRTNameField.setMinimumSize(new java.awt.Dimension(300, 28));
        genericRTNameField.setPreferredSize(new java.awt.Dimension(300, 28));
        genericRTNameField.setSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        addTypePanel.add(genericRTNameField, gridBagConstraints);

        jLabel8.setText("(e.g., \"Parent\")");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Name to Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel9, gridBagConstraints);

        fwdMaleRTNameField.setText("jTextField2");
        fwdMaleRTNameField.setMinimumSize(new java.awt.Dimension(300, 28));
        fwdMaleRTNameField.setPreferredSize(new java.awt.Dimension(300, 28));
        fwdMaleRTNameField.setSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        addTypePanel.add(fwdMaleRTNameField, gridBagConstraints);

        jLabel10.setText("(e.g., \"Father\")");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Name to Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel11, gridBagConstraints);

        fwdFemaleRTNameField.setText("jTextField2");
        fwdFemaleRTNameField.setMinimumSize(new java.awt.Dimension(300, 28));
        fwdFemaleRTNameField.setPreferredSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        addTypePanel.add(fwdFemaleRTNameField, gridBagConstraints);

        jLabel12.setText("(e.g., \"Mother\")");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel12, gridBagConstraints);

        jLabel13.setText("Reverse to Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel13, gridBagConstraints);

        revMaleRTNameField.setText("jTextField2");
        revMaleRTNameField.setMinimumSize(new java.awt.Dimension(300, 28));
        revMaleRTNameField.setPreferredSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        addTypePanel.add(revMaleRTNameField, gridBagConstraints);

        jLabel14.setText("(e.g., \"Son\")");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Reverse to Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel15, gridBagConstraints);

        revFemaleRTNameField.setText("jTextField2");
        revFemaleRTNameField.setMinimumSize(new java.awt.Dimension(300, 28));
        revFemaleRTNameField.setPreferredSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        addTypePanel.add(revFemaleRTNameField, gridBagConstraints);

        jLabel16.setText("(e.g., \"Daughter\")");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.25;
        addTypePanel.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Not all answers must be different.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        addTypePanel.add(jLabel17, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        addPersonButton.setText("+");
        addPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addPersonButton);

        removePersonButton.setText("-");
        removePersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePersonButtonActionPerformed(evt);
            }
        });
        jPanel2.add(removePersonButton);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        personList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        personList.setPreferredSize(new java.awt.Dimension(50, 85));
        personList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                personSelectionChanged(evt);
            }
        });
        jScrollPane2.setViewportView(personList);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel1.setText("People");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel5.setLayout(new java.awt.BorderLayout());

        relationshipList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(relationshipList);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        relationshipTabPanel.addTab("ListView", jPanel3);

        org.jdesktop.layout.GroupLayout personalMapPane1Layout = new org.jdesktop.layout.GroupLayout(personalMapPane1);
        personalMapPane1.setLayout(personalMapPane1Layout);
        personalMapPane1Layout.setHorizontalGroup(
            personalMapPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );
        personalMapPane1Layout.setVerticalGroup(
            personalMapPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 379, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(personalMapPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(personalMapPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        relationshipTabPanel.addTab("Graphical View", jPanel4);

        jPanel5.add(relationshipTabPanel, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Relationships");
        jPanel5.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addRelationshipButton.setText("+");
        addRelationshipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationshipButtonActionPerformed(evt);
            }
        });
        jPanel6.add(addRelationshipButton);

        removeRelationshipButton.setText("-");
        removeRelationshipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRelationshipButtonActionPerformed(evt);
            }
        });
        jPanel6.add(removeRelationshipButton);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setRightComponent(jPanel5);

        jMenu1.setText("File");

        SaveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        SaveMenuItem.setText("Save");
        SaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(SaveMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * the user has just pressed the removePerson Button, and it's time to respond.
     * @param evt - a description of the event (e.g., when did they click, exactly;
     * were they holding the option button, etc.) You probably won't use this
     * variable.
     */
    private void removePersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePersonButtonActionPerformed
        // find out which # row on the list is selected, starting at zero
        // (or -1, if no row is selected).
        int selectedRow = personList.getSelectedIndex();
        
        // do whatever you have to to remove the person in question.
        // TODO: you do this! (removePersonButton)
        
        if (selectedRow != -1){
            ArrayList<PeopleClass> people = controller.getAllPeople();
            PeopleClass personToDelete = people.get(selectedRow);
            if(personToDelete.getId() == this.currentPerson.getId())
                personalMapPane1.setCurrentPerson(null);
            controller.deletePerson(personToDelete);
            currentPerson = null;
        }
        
        
        
        // refresh the JLists on screen and clear their selections.
        updatePeopleList();
        updateRelationshipList();
        personList.setSelectedIndices(new int[0]);
        relationshipList.setSelectedIndices(new int[0]);
    }//GEN-LAST:event_removePersonButtonActionPerformed
/**
 * the user has just clicked the "removeRelationshipButton", and it's time to
 * do something about it.
 * @param evt - a description of the event (e.g., when did they click, exactly;
     * were they holding the option button, etc.) You probably won't use this
     * variable.
 */
    private void removeRelationshipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRelationshipButtonActionPerformed
        
        
        Relationship selectedRelationship = null;
        if (relationshipTabPanel.getSelectedIndex()==0) // if we are showing
                                                        // the list view
        {
            if (relationshipList.getSelectedIndex()== -1) // bail if no
                                                // relationship is selected.
                return;
            // Identify which relationship is selected, and do what you need to
            // to remove it.
            // TODO: you do this! (removeRelationship - list view.)
            ArrayList<Relationship> relationships = controller.getAllRelationshispForPerson(currentPerson);
            selectedRelationship = relationships.get(relationshipList.getSelectedIndex());
        
            
            
            
            
            
            
        }
        else if (relationshipTabPanel.getSelectedIndex() ==1 ) // if we are
                                              // showing the personal map view 
        {
            if (personalMapPane1.getSelectedObjectId()==-1)// bail if no
                                                // relationship is selected.
                return;
            // Identify which relationship is selected, and do what you need to
            // to remove it.
            // TODO: you do this! (removeRelationship - personal map view.)    
            
            
            
            
            
            
            
            
        }
        if (selectedRelationship == null)
            return;
        String whichThingToDelete = "";
        int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete"+whichThingToDelete+"?",
                whichThingToDelete,
                JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.CANCEL_OPTION)
            return;
        else{
            controller.deleteRelationship(selectedRelationship);
        }
        // Have the controller remove the relationship.
        // TODO: You do this (removeRelationship - theWork.)
        
        
        
        
        
        // refresh the onscreen relationship List and personal Map.
        updateRelationshipList();
        updatePersonalMap();
    }//GEN-LAST:event_removeRelationshipButtonActionPerformed
/**
 * the user (or the program) just altered which row of the list of people is
 * selected - or deselected every one; now it's time to respond to this.
 * @param evt a description of the event (e.g., when did they click, exactly;
     * were they holding the option button, etc.) You probably won't use this
     * variable.
 */
    private void personSelectionChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_personSelectionChanged
        
        // determine the index of which row in personList is newly selected (or
        //   -1, if nothing is selected).
        // (uses personList.getSelectedIndex().)
        // TODO: You do this! (personSelectionChanged)
        
        
        int clickIndex = personList.getSelectedIndex();
        if(clickIndex!=-1){
            currentPerson = controller.getAllPeople().get(clickIndex);
            personalMapPane1.setCurrentPerson(currentPerson);
        }
        else
            clickIndex=0;
        
        
        
        // update the relationship List and the personal map to reflect this change.
        updateRelationshipList();
        updatePersonalMap();
    }//GEN-LAST:event_personSelectionChanged
/**
 * the user just clicked on the addPersonButton, and now it's time to respond.
 * @param evt a description of the event (e.g., when did they click, exactly;
 * were they holding the option button, etc.) You probably won't use this
 * variable.
 */
    private void addPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonButtonActionPerformed
 
        /* the general strategy for this method is:
            #1: Clear out the existing text fields and buttons.
            #2: Show the user a dialog with the fields and buttons.
            #3: If the user didn't click "cancel" read the text fields and respond.
        (Note: The text fields and buttons still exist, even when they aren't visible onscreen)
        */
        
        //--------- STEP 1
        firstNameField.setText("");
        lastNameField.setText("");
        genderMaleButton.setSelected(true);
        genderFemaleButton.setSelected(false);
        
        //--------- STEP 2
        int result = JOptionPane.showConfirmDialog(this,newPersonPanel,"Add Person",JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.CANCEL_OPTION) // if the user clicked "cancel"
                                                // then bail out....
            return;
        
        if (firstNameField.getText().equals("") || lastNameField.getText().equals(""))
        {
            System.out.println("Please fill out both name fields, thanks!");
            return;
        }
        
        //--------- STEP 3
        String first = firstNameField.getText();
        String last = lastNameField.getText();
        boolean isMale = genderMaleButton.isSelected();
        
        // Create a new person and add them to your list of people.
        // TODO: You do this! (addPersonButton)
        controller.addPerson(first, last, isMale);
        
        updatePeopleList();
        updateRelationshipList();
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_addPersonButtonActionPerformed
/**
 * the user just pressed the addRelationshipButton, and now its time to respond.
 * @param evt a description of the event (e.g., when did they click, exactly;
 * were they holding the option button, etc.) You probably won't use this
 * variable.
 */
    private void addRelationshipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationshipButtonActionPerformed
        /*
        The general strategy here is:
            #1: Set up the UI elements in the existing JPanel
            #2: Show the JPanel to the user and let the user fill it out.
            #3: If the user didn't click cancel, read the UI elements and create
                the relationship.
        (Note: The text fields and buttons still exist, even when they aren't visible onscreen)
        */
        
        // --------- STEP 1
        // Create an array of Strings for the relatedPersonList - most likely,
        //       you don't want it to include the selected person.
        // Create an array of Strings for the relationship types
        // TODO: You do this! (addRelationshipButton - setup UI)
        if (currentPerson == null)
            return;
        String[] names;
        String[] typeStrings;
        
        //List of people WITHOUT currentPerson
        ArrayList<PeopleClass> people = new ArrayList<PeopleClass>(controller.getAllPeople());
        people.remove(this.currentPerson);
        
        ArrayList<RelationType> relationTypes = controller.getAllRelationshipTypes();
        ArrayList<String> peopleNames = new ArrayList<String>();
        ArrayList<String> relationTypeNames = new ArrayList<String>();
        for (int i = 0;i<people.size();i++){
            peopleNames.add(people.get(i).getLastName()+", "+people.get(i).getFirstName());
        }
        for (int i= 0;i<relationTypes.size();i++){
            relationTypeNames.add(relationTypes.get(i).getGenericName());
        }
        
        
        
        names = new String[peopleNames.size()];
        names = peopleNames.toArray(names);
        typeStrings= new String[relationTypeNames.size()];
        typeStrings = relationTypeNames.toArray(typeStrings);
        
        
        
        // update the JLists in the JPanel for the dialog with names and typeStrings
        relatedPersonList.setListData(names);
        relTypeList.setListData(typeStrings);
        // --------- STEP 2
        // show interface
        int response = JOptionPane.showConfirmDialog(this, newRelationshipPanel, "Add Relationship",JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.CANCEL_OPTION) // if the user pressed cancel,  bail out.
            return;
        if (relatedPersonList.getSelectedIndex() == -1 || relTypeList.getSelectedIndex() == -1)
            return; // bail out also if either list doesn't have a selection.
        
        // --------- STEP 3
        // find the person to connect to and the type of relationship
        int personIndex = relatedPersonList.getSelectedIndex();
        int relTypeIndex = relTypeList.getSelectedIndex();
        // alternately....
        // String relTypeDescription = relTypeList.getSelectedValue();
        
        PeopleClass target= people.get(personIndex);
        RelationType relType = relationTypes.get(relTypeIndex);
        
        if (reciprocateCheckbox.isSelected()){
            //add two relationshps here
            controller.addNewRelationshipAndReciprocal(currentPerson, target, relType);
            
        }
        else{
            controller.addNewRelationship(currentPerson, target, relType);
        }
        personalMapPane1.repaint();
        
        
        
        
        // respond - access interface to create response.
        // Create a relationship and add it to your collection of relationships.
        // TODO: You do this! (addRelationshipButton - create relationship)
        
        
        
        
       
        
        
        
        // update the relationships displayed...
        updateRelationshipList();
        updatePersonalMap();
    }//GEN-LAST:event_addRelationshipButtonActionPerformed
    /**
     * The user has just pressed the addTypeButton (on the new Relationship
     * dialog panel), and now it's time for the program to respond.
     * @param evt a description of the event (e.g., when did they click, exactly;
     * were they holding the option button, etc.) You probably won't use this
     * variable.
     */
    private void addTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTypeButtonActionPerformed
        /*
        Once again, we are going to have a dialog window with a custom panel, so
            #1 reset the UI elements (textFields) in the panel to empty from last time
            #2 show the panel to the user and get his/her feedback
            #3 if the user didn't cancel, get the information from the panel's 
                    textFields and create a new type of Relationship.
        */
        //--------- STEP 1
        // clear the panel's textfields
        genericRTNameField.setText("");
        fwdMaleRTNameField.setText("");
        fwdFemaleRTNameField.setText("");
        revMaleRTNameField.setText("");
        revFemaleRTNameField.setText("");
        
        //--------- STEP 2
        // show the panel in a dialog box.
        int response = JOptionPane.showConfirmDialog(this, addTypePanel, "Add Relationship Type", JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.CANCEL_OPTION) // bail if user cancels.
            return;
        //--------- STEP 3
        // get the information fron the textFields and create a new RelType.
        
        String genericName = genericRTNameField.getText();
        String fwdMaleName = fwdMaleRTNameField.getText();
        String fwdFemaleName = fwdFemaleRTNameField.getText();
        String revMaleName = revMaleRTNameField.getText();
        String revFemaleName = revFemaleRTNameField.getText();
        
        
        
        
        //Ok. Now create a relationship type based on this.
        // TODO: You do this! (addTypeButton)
        
        
        
        controller.addRelType(genericName, fwdMaleName, fwdFemaleName, revMaleName, revFemaleName);
        RelationType newRelationType = controller.getRelationTypeByGenericName(genericName); //get the newly created relationship
        RelationType inverse = controller.getInverseRelationType(newRelationType);
        if (inverse == null){
            if (fwdMaleName.equals(revMaleName) && fwdFemaleName.equals(revFemaleName)){
		 
            }
            else{
                String inverseGenericName = JOptionPane.showInputDialog(null,
                        "Please Enter the Inverse Generic Name for the RelationType",
                        "Enter Inverse Generic Name");
                if (inverseGenericName == null){
                    JOptionPane.showMessageDialog(null, "New RelationType Creation Cancelled.");
                    controller.deleteRelationshipType(newRelationType); //get rid of the relationtype the user just created
                }
                else{
                    controller.addRelType(inverseGenericName, revMaleName, revFemaleName, fwdMaleName, fwdFemaleName);

                }
            }
            
        }
        
        
        
        
        
        // Create a new list of RelationshipType strings and populate it with
        //  your revised list of relationship types.
        // TODO: You do this! (addRelationshipTypeButton update the type list)
        String[] rtListNames;
                
       ArrayList<RelationType> relTypes = controller.getAllRelationshipTypes();
       ArrayList<String> relTypeNames = new ArrayList<String>();
       for (int i = 0;i<relTypes.size();i++){
           relTypeNames.add(relTypes.get(i).getGenericName());
       }
        rtListNames = new String[relTypeNames.size()];
        rtListNames = relTypeNames.toArray(rtListNames);
        
        
        // update the list of relationship types in the previous dialog box.
        relTypeList.setListData(rtListNames);
        
        
    }//GEN-LAST:event_addTypeButtonActionPerformed
    /**
     * The user just chose "Save" from the File menu. It's time to save the data.
     * @param evt a description of the event (e.g., when did they click, exactly;
     * were they holding the option button, etc.) You probably won't use this
     * variable.
     */
    private void SaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMenuItemActionPerformed
        // I suggest that you tell your controller to do the saving, and let it
        // delegate, as needed.
        // TODO: You do this! (SaveMenuItem)
       controller.savePeopleData();
       controller.saveRelTypes();
       controller.saveRelationships();
       System.out.println("WARNING! WARNING! WARNING! WARNING! WARNING! WARNING! WARNING! WARNING!\nYOU HAVE CHANGED THE BASE FILES!");
        
        
        
        
    }//GEN-LAST:event_SaveMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelationshipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelationshipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelationshipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelationshipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RelationshipFrame().setVisible(true);
            }
        });
    }
    
    /*
    What follows is a list of all the UI elements that were created by the UI
    editor for this program. I think you will find that the ones you care about
    have meaningful names; you can safely ignore jLabel1, for example. To get
    a better sense of which things are which, click on the "Design" button at
    the top of this panel, and then look in the "Window...Navigator" panel 
    (probably on the left side of the page.) To get back to the code, click on
    the "Source" button, next to the "Design" button.
    */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JButton addPersonButton;
    private javax.swing.JButton addRelationshipButton;
    private javax.swing.JButton addTypeButton;
    private javax.swing.JPanel addTypePanel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField fwdFemaleRTNameField;
    private javax.swing.JTextField fwdMaleRTNameField;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JRadioButton genderFemaleButton;
    private javax.swing.JRadioButton genderMaleButton;
    private javax.swing.JTextField genericRTNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JPanel newPersonPanel;
    private javax.swing.JPanel newRelationshipPanel;
    private javax.swing.JList personList;
    private relationshipspje.PersonalMapPane personalMapPane1;
    private javax.swing.JCheckBox reciprocateCheckbox;
    private javax.swing.JList relTypeList;
    private javax.swing.JList relatedPersonList;
    private javax.swing.JList relationshipList;
    private javax.swing.JTabbedPane relationshipTabPanel;
    private javax.swing.JButton removePersonButton;
    private javax.swing.JButton removeRelationshipButton;
    private javax.swing.JTextField revFemaleRTNameField;
    private javax.swing.JTextField revMaleRTNameField;
    // End of variables declaration//GEN-END:variables
}
