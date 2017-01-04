
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Prj4Gui extends JFrame {

    //Declare Variables
    private final JTextField IdField;
    private final JButton computeBtn;
    private JTextField nameField;
    private JTextField majorField;
    
    int task = 2;
    HashMap<Integer, Student> hashmap = new HashMap<>();
   

    //constructor without an argument
    public Prj4Gui() {

        super("Factorial");
        IdField = new JTextField(16);
        nameField = new JTextField(16);
        majorField = new JTextField(16);
        computeBtn = new JButton();
        String[] dropdown = {"Insert", "Delete", "Find", "Update"};
        JComboBox dropdownBox = new JComboBox(dropdown);
        setLayout(new GridLayout(6, 2));
        hashmap.put(1234, new Student("Hanna D", "Business"));
        hashmap.put(1235, new Student("Brian C", "Finance"));

        //add labels and fields
        add(new JLabel("Id: "));
        add(IdField);
        add(new JLabel("Name: "));
        add(nameField);
        nameField.setEditable(false);
        add(new JLabel("Major: "));
        add(majorField);
        majorField.setEditable(false);
        add(new JLabel("Choose Selection: "));
        add(dropdownBox);
        dropdownBox.setSelectedItem("Find");
        computeBtn.setText("Process Request");
        add(computeBtn);
       

        //create action listener for compute button
        HandlerClass handler = new HandlerClass();
        computeBtn.addActionListener(handler);

        //create action listener for comboBox dropdownBox
        dropdownBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox comboBox = (JComboBox) event.getSource();

                Object selected = comboBox.getSelectedItem();
                if (selected.toString().equals("Insert")) {
                    task = 0;
                    majorField.setEditable(true);
                    nameField.setEditable(true);
                } else if (selected.toString().equals("Delete")) {
                    task = 1;
                    majorField.setEditable(false);
                    nameField.setEditable(false);
                } else if (selected.toString().equals("Find")) {
                    task = 2;
                    majorField.setEditable(false);
                    nameField.setEditable(false);
                } else {
                    task = 3;
                    majorField.setEditable(false);
                    nameField.setEditable(false);
                }

            }
        });

    }//end of Prj4Gui

    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            int number = 0;
        
            try {

                number = Integer.parseInt(IdField.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Enter numeric value for ID");
            }
            switch (task) {
                case 0://Insert into hashmap database
                    if (hashmap.containsKey(number)){
                        JOptionPane.showMessageDialog(rootPane, "Database already contains ID number: " + number );
                    }
                    else{
                    String insertName = nameField.getText();
                    String insertMajor = majorField.getText();
                    hashmap.put(number, new Student(insertName, insertMajor));
                    Integer ikey = number;
                    Student ivalue = hashmap.get(ikey);
                    System.out.println("Following inserted to map " + ivalue);
                    JOptionPane.showMessageDialog(rootPane, "Inserted " + ivalue);
                    }
                    break;
                case 1://Delete from hashmap database
                    if (!hashmap.containsKey(number)){
                        JOptionPane.showMessageDialog(rootPane, "Database does not contain ID number: " + number );
                    }
                    else{
                    Integer dkey = number;
                    Student dvalue = hashmap.remove(dkey);
                    System.out.println("Following removed from map " + dvalue);
                    JOptionPane.showMessageDialog(rootPane, "Deleted" + dvalue);
                    }
                    break;
                case 2://Find in hashmap database
                    if (!hashmap.containsKey(number)){
                        JOptionPane.showMessageDialog(rootPane, "Database does not contain ID number: " + number );
                    }
                    else{
                    Integer key = number;
                    Student value = hashmap.get(key);
                    System.out.println("Found in map " + value);
                    JOptionPane.showMessageDialog(rootPane, value);
                    }
                    break;
                default:// update a value in the hashmap
                    if (!hashmap.containsKey(number)){
                        JOptionPane.showMessageDialog(rootPane, "Database does not contain ID number: " + number );
                    }
                    else{
                        Integer key = number;
                        Student uvalue = hashmap.get(key);
                        System.out.println("Found in delete map " + uvalue);
                        Component source = (Component) event.getSource();
                        Object response = JOptionPane.showInputDialog(source,
                                "Choose Grade", "JOptionPane Sample",
                                JOptionPane.QUESTION_MESSAGE, null, new String[]{"A", "B", "C", "D", "F"},
                                "B");
                        System.out.println("Response: " + response);
                        Component source2 = (Component) event.getSource();
                        Object response2 = JOptionPane.showInputDialog(source2,
                                "Choose Credits", "JOptionPane Sample",
                                JOptionPane.QUESTION_MESSAGE, null, new String[]{"3", "6"},
                                "B");
                        uvalue.courseCompleted(response.toString(), response2.toString());
                        JOptionPane.showMessageDialog(rootPane, "Updated" + uvalue);
                        System.out.println("Response: " + response2);
                    }
                    break;
            }

        }//END OF ACTION PERFORMED

    }//END OF HANDLER CLASS*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Prj4Gui fact = new Prj4Gui();
        
       
        
        fact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fact.pack();
        fact.setVisible(true);
    }

}//END OF CLASS
