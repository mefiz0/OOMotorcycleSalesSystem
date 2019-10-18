/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import database.UpdateUIView;
import database.UpdateUISQL;
import static database.UpdateUISQL.*;
import static database.UpdateUIView.updateComboBoxView;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import oomotorcyclesalessystem.Customer;
import oomotorcyclesalessystem.InventoryMotorcycle;
import oomotorcyclesalessystem.Payments;
import oomotorcyclesalessystem.PurchaseAndInstallment;
import oomotorcyclesalessystem.SoldMotorcycle;
import oomotorcyclesalessystem.User;

/**
 *
 * @author sath
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    boolean isMakeSalePanelActive;
    boolean isInventoryPanelActive;
    boolean isCustomersTableActive;
    boolean isSalesHistoryTableActive;
    boolean isViewInstallmentsTableActive;
    boolean isUsersSettingsPanelActive;
    public Home() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //if installment is not selected these are hidden*****
        installmentPeriodLabel.setVisible(false);
        InstallmentPeriodDropDownMenu.setVisible(false);
        downPaymentLabel.setVisible(false);
        downPaymentField.setVisible(false);
        monthsLabel.setVisible(false);
        //****************************************************
        
        buttonVisibilityBasedOnRoles(); //changes the ui based on the roles of the currently logged in person
    }
    
    //changes the ui based on the role of the currently logged in person
    public final void buttonVisibilityBasedOnRoles(){
        //create a users object
        User userRole = new User();
        
        try {
            if(userRole.getUserRole().equals("Administrator") == false){ //if the user is not an admin, hide the user settings
                usersSettingsButton.setVisible(false);
            }//end if
            
            if(userRole.getUserRole().equals("Sales") == true){ //if the user is sales hide the inventory menus
             inventoryMenu.setVisible(false);
            inventoryPanelParent.setVisible(false);
            
            }else if(userRole.getUserRole().equals("Procument") == true){ //if the user is proc disable all the buttons excep inventory
            makeSaleButton.setEnabled(false);
            customersButton.setEnabled(false);
            salesHistoryButton.setEnabled(false);
            viewInstallmentsButton.setEnabled(false);
            
            //update the view
            parentPanel.removeAll();
            parentPanel.add(inventoryPanel);
            parentPanel.repaint();
            parentPanel.revalidate();
        
            resetButtonsColors();
            inventoryButton.setBackground(new Color(197, 223, 185));
            
            try {
            //update the table
            database.UpdateUIView.updateTableView(inventoryTable, database.UpdateUISQL.VIEW_INVENTORY_TABLE_SQL);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            
            } //end if
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end buttonVisibilityBasedOnRoles()
    
    //resets the colors of the left menu buttons
    public void resetButtonsColors(){
        makeSaleButton.setBackground(new Color(244, 244, 244));
        inventoryButton.setBackground(new Color(244, 244, 244));
        customersButton.setBackground(new Color(244, 244, 244));
        salesHistoryButton.setBackground(new Color(244, 244, 244));
        viewInstallmentsButton.setBackground(new Color(244, 244, 244));
        usersSettingsButton.setBackground(new Color(244, 244, 244));
    }
    
    //These methods reset the text fields.
    public void resetFields(JTextField fieldOne, JTextField fieldTwo, JFormattedTextField fieldThree, JFormattedTextField fieldFour){
        fieldOne.setText("");
        fieldTwo.setText("");
        fieldThree.setText("");
        fieldFour.setText("");
    }
    public void resetFields(JTextField fieldOne, JTextField fieldTwo, JTextField fieldThree, JTextField fieldFour,
                            JTextField fieldFive, JFormattedTextField fieldSix, JFormattedTextField fieldSeven){
        fieldOne.setText("");
        fieldTwo.setText("");
        fieldThree.setText("");
        fieldFour.setText("");
        fieldFive.setText("");
        fieldSix.setText("");
        fieldSeven.setText("");
    }
    //end reset fields
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jToolBar1 = new javax.swing.JToolBar();
        menu = new javax.swing.JPanel();
        makeSaleButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        customersButton = new javax.swing.JButton();
        salesHistoryButton = new javax.swing.JButton();
        viewInstallmentsButton = new javax.swing.JButton();
        usersSettingsButton = new javax.swing.JButton();
        parentPanel = new javax.swing.JPanel();
        makeSalePanel = new javax.swing.JScrollPane();
        makeSalePane = new javax.swing.JPanel();
        customerDetailsLabel = new javax.swing.JLabel();
        customerDetailsSeperator = new javax.swing.JSeparator();
        idNumLabel = new javax.swing.JLabel();
        idNumField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        contactNumLabel = new javax.swing.JLabel();
        contactNumberField = new javax.swing.JFormattedTextField();
        bankAccountNumLabel = new javax.swing.JLabel();
        bankAccountNumField = new javax.swing.JFormattedTextField();
        permanentAddressLabel = new javax.swing.JLabel();
        permanentAddressField = new javax.swing.JTextField();
        currentAddressLabel = new javax.swing.JLabel();
        currentAddressField = new javax.swing.JTextField();
        contentSepratorOne = new javax.swing.JSeparator();
        motorcycleDetailsLabel = new javax.swing.JLabel();
        motorcycleDetailsSeparator = new javax.swing.JSeparator();
        brandLabel = new javax.swing.JLabel();
        brandComboBox = new javax.swing.JComboBox<>();
        modelLabel = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox<>();
        boardNumLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        currentPriceLabel = new javax.swing.JLabel();
        installmentLabel = new javax.swing.JLabel();
        installmentCheckBox = new javax.swing.JCheckBox();
        installmentPeriodLabel = new javax.swing.JLabel();
        InstallmentPeriodDropDownMenu = new javax.swing.JComboBox<>();
        confirmSaleButton = new javax.swing.JButton();
        downPaymentLabel = new javax.swing.JLabel();
        boardNumField = new javax.swing.JTextField();
        downPaymentField = new javax.swing.JFormattedTextField();
        monthsLabel = new javax.swing.JLabel();
        inventoryPanel = new javax.swing.JPanel();
        inventoryTablePane = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        inventoryMenu = new javax.swing.JPanel();
        modifyInventoryButton = new javax.swing.JButton();
        addToInventoryButton = new javax.swing.JButton();
        removeInventoryButton = new javax.swing.JButton();
        inventoryPanelParent = new javax.swing.JPanel();
        addNewMotorcycles = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        brandInputField = new javax.swing.JTextField();
        modelInputField = new javax.swing.JTextField();
        quantityInputField = new javax.swing.JFormattedTextField();
        priceInputField = new javax.swing.JFormattedTextField();
        confirmAddToInventoryButton = new javax.swing.JButton();
        removeMotorcycle = new javax.swing.JPanel();
        removeMotorcycleLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        brandLabel1 = new javax.swing.JLabel();
        brandComboBoxInventory = new javax.swing.JComboBox<>();
        modelLabel1 = new javax.swing.JLabel();
        modelComboBoxInventory = new javax.swing.JComboBox<>();
        confirmRemoveFromInventoryButton = new javax.swing.JButton();
        modifyInventoryPanel = new javax.swing.JPanel();
        removeMotorcycleLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        brandLabel2 = new javax.swing.JLabel();
        brandComboBoxInventory1 = new javax.swing.JComboBox<>();
        modelLabel2 = new javax.swing.JLabel();
        modelComboBoxInventory1 = new javax.swing.JComboBox<>();
        confirmRemoveFromInventoryButton1 = new javax.swing.JButton();
        quantityInputField1 = new javax.swing.JFormattedTextField();
        priceInputField1 = new javax.swing.JFormattedTextField();
        modelLabel3 = new javax.swing.JLabel();
        modelLabel4 = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        customersScrollPane = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        salesHistoryPane = new javax.swing.JScrollPane();
        salesHistoryTable = new javax.swing.JTable();
        usersSettingsPanel = new javax.swing.JPanel();
        usersTablePane = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        usersMenu = new javax.swing.JPanel();
        viewUsersAccess = new javax.swing.JButton();
        modifyUserBUtton = new javax.swing.JButton();
        removeUserButton = new javax.swing.JButton();
        addUsersButton = new javax.swing.JButton();
        userSettingsParentPanel = new javax.swing.JPanel();
        usersAccessHistoryPanel = new javax.swing.JScrollPane();
        usersAccessHistoryTable = new javax.swing.JTable();
        addNewUserPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        usernameInputField = new javax.swing.JTextField();
        passwordInputField = new javax.swing.JTextField();
        confirmAddUser = new javax.swing.JButton();
        roleSelectDropDownMenu = new javax.swing.JComboBox<>();
        removeUsersPanel = new javax.swing.JPanel();
        removeUserLabel = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        brandLabel3 = new javax.swing.JLabel();
        usernameSelectDropDownMenu = new javax.swing.JComboBox<>();
        confirmRemoveUser = new javax.swing.JButton();
        modifyUsersPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        newPasswordInputField = new javax.swing.JTextField();
        confirmModifyUser = new javax.swing.JButton();
        modifyUsernameDropDownMenu = new javax.swing.JComboBox<>();
        modifyRoleDropDownMenu = new javax.swing.JComboBox<>();
        installmentsPanel = new javax.swing.JPanel();
        installmentsPane = new javax.swing.JScrollPane();
        installmentsTable = new javax.swing.JTable();
        payInstallmentsPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        confirmPayInstallment = new javax.swing.JButton();
        idNumberDropDownMenu = new javax.swing.JComboBox<>();
        boardNumDropDownMenu = new javax.swing.JComboBox<>();
        paymentsField = new javax.swing.JFormattedTextField();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setBackground(new java.awt.Color(19, 15, 64));

        makeSaleButton.setBackground(new java.awt.Color(161, 202, 141));
        makeSaleButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        makeSaleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/make_sale.png"))); // NOI18N
        makeSaleButton.setText("  Sale                            ");
        makeSaleButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        makeSaleButton.setContentAreaFilled(false);
        makeSaleButton.setOpaque(true);
        makeSaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                makeSaleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                makeSaleButtonMouseExited(evt);
            }
        });
        makeSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeSaleButtonActionPerformed(evt);
            }
        });

        inventoryButton.setBackground(new java.awt.Color(244, 244, 244));
        inventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        inventoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inventory.png"))); // NOI18N
        inventoryButton.setText("  Inventory                     ");
        inventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inventoryButton.setContentAreaFilled(false);
        inventoryButton.setOpaque(true);
        inventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryButtonMouseExited(evt);
            }
        });
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });

        customersButton.setBackground(new java.awt.Color(244, 244, 244));
        customersButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        customersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customers.png"))); // NOI18N
        customersButton.setText("  Customers                   ");
        customersButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        customersButton.setContentAreaFilled(false);
        customersButton.setOpaque(true);
        customersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customersButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customersButtonMouseExited(evt);
            }
        });
        customersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersButtonActionPerformed(evt);
            }
        });

        salesHistoryButton.setBackground(new java.awt.Color(244, 244, 244));
        salesHistoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        salesHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sales_history.png"))); // NOI18N
        salesHistoryButton.setText("  Sales History                ");
        salesHistoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        salesHistoryButton.setContentAreaFilled(false);
        salesHistoryButton.setOpaque(true);
        salesHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesHistoryButtonMouseExited(evt);
            }
        });
        salesHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesHistoryButtonActionPerformed(evt);
            }
        });

        viewInstallmentsButton.setBackground(new java.awt.Color(244, 244, 244));
        viewInstallmentsButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        viewInstallmentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/installments.png"))); // NOI18N
        viewInstallmentsButton.setText(" Installments                 ");
        viewInstallmentsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewInstallmentsButton.setContentAreaFilled(false);
        viewInstallmentsButton.setOpaque(true);
        viewInstallmentsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewInstallmentsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewInstallmentsButtonMouseExited(evt);
            }
        });
        viewInstallmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewInstallmentsButtonActionPerformed(evt);
            }
        });

        usersSettingsButton.setBackground(new java.awt.Color(244, 244, 244));
        usersSettingsButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        usersSettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_settings.png"))); // NOI18N
        usersSettingsButton.setText("  Users                           ");
        usersSettingsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        usersSettingsButton.setContentAreaFilled(false);
        usersSettingsButton.setOpaque(true);
        usersSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersSettingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersSettingsButtonMouseExited(evt);
            }
        });
        usersSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersSettingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(makeSaleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(salesHistoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewInstallmentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usersSettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(makeSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salesHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewInstallmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usersSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        parentPanel.setBackground(new java.awt.Color(223, 249, 251));
        parentPanel.setLayout(new java.awt.CardLayout());

        makeSalePanel.setBackground(new java.awt.Color(255, 255, 255));
        makeSalePanel.setBorder(null);
        makeSalePanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        makeSalePane.setBackground(new java.awt.Color(255, 255, 255));

        customerDetailsLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        customerDetailsLabel.setText("Customer Details");

        customerDetailsSeperator.setBackground(new java.awt.Color(204, 204, 204));

        idNumLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        idNumLabel.setText("NID/Passport No:");

        idNumField.setBackground(new java.awt.Color(229, 229, 229));
        idNumField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        idNumField.setBorder(null);
        idNumField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idNumFieldFocusLost(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name:");

        firstNameField.setBackground(new java.awt.Color(229, 229, 229));
        firstNameField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        firstNameField.setBorder(null);

        lastNameLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name:");

        lastNameField.setBackground(new java.awt.Color(229, 229, 229));
        lastNameField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        lastNameField.setBorder(null);

        contactNumLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        contactNumLabel.setText("Contact No:");

        contactNumberField.setBackground(new java.awt.Color(229, 229, 229));
        contactNumberField.setBorder(null);
        contactNumberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        bankAccountNumLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        bankAccountNumLabel.setText("Bank Account No:");

        bankAccountNumField.setBackground(new java.awt.Color(229, 229, 229));
        bankAccountNumField.setBorder(null);
        bankAccountNumField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("################0"))));

        permanentAddressLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        permanentAddressLabel.setText("Parmenent Address:");

        permanentAddressField.setBackground(new java.awt.Color(229, 229, 229));
        permanentAddressField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        permanentAddressField.setBorder(null);

        currentAddressLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        currentAddressLabel.setText("Current Address:");

        currentAddressField.setBackground(new java.awt.Color(229, 229, 229));
        currentAddressField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        currentAddressField.setBorder(null);

        contentSepratorOne.setBackground(new java.awt.Color(204, 204, 204));

        motorcycleDetailsLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        motorcycleDetailsLabel.setText("Motorcycle Details");

        motorcycleDetailsSeparator.setBackground(new java.awt.Color(204, 204, 204));

        brandLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        brandLabel.setText("Brand:");

        brandComboBox.setBackground(new java.awt.Color(229, 229, 229));
        brandComboBox.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandComboBox.setBorder(null);
        brandComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxPopupMenuWillBecomeVisible(evt);
            }
        });

        modelLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        modelLabel.setText("Model:");

        modelComboBox.setBackground(new java.awt.Color(229, 229, 229));
        modelComboBox.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelComboBox.setBorder(null);
        modelComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                modelComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        boardNumLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        boardNumLabel.setText("Board No:");

        priceLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        priceLabel.setText("Price:");

        currentPriceLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        currentPriceLabel.setText("Motorcycle Price");

        installmentLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        installmentLabel.setText("Installment:");

        installmentCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        installmentCheckBox.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        installmentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installmentCheckBoxActionPerformed(evt);
            }
        });

        installmentPeriodLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        installmentPeriodLabel.setText("Installment Period:");

        InstallmentPeriodDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        InstallmentPeriodDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        InstallmentPeriodDropDownMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "12", "18", "24" }));
        InstallmentPeriodDropDownMenu.setBorder(null);

        confirmSaleButton.setBackground(new java.awt.Color(209, 229, 199));
        confirmSaleButton.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmSaleButton.setText("Confirm");
        confirmSaleButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmSaleButton.setContentAreaFilled(false);
        confirmSaleButton.setOpaque(true);
        confirmSaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmSaleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmSaleButtonMouseExited(evt);
            }
        });
        confirmSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSaleButtonActionPerformed(evt);
            }
        });

        downPaymentLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        downPaymentLabel.setText("Down Payment:");

        boardNumField.setBackground(new java.awt.Color(229, 229, 229));
        boardNumField.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        boardNumField.setBorder(null);

        downPaymentField.setBackground(new java.awt.Color(229, 229, 229));
        downPaymentField.setBorder(null);
        downPaymentField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        monthsLabel.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        monthsLabel.setText("Months");

        javax.swing.GroupLayout makeSalePaneLayout = new javax.swing.GroupLayout(makeSalePane);
        makeSalePane.setLayout(makeSalePaneLayout);
        makeSalePaneLayout.setHorizontalGroup(
            makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentSepratorOne)
            .addGroup(makeSalePaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerDetailsLabel)
                    .addComponent(customerDetailsSeperator)
                    .addComponent(idNumLabel))
                .addGap(93, 93, 93))
            .addGroup(makeSalePaneLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motorcycleDetailsLabel)
                            .addGroup(makeSalePaneLayout.createSequentialGroup()
                                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                                        .addComponent(brandLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeSalePaneLayout.createSequentialGroup()
                                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(makeSalePaneLayout.createSequentialGroup()
                                                .addComponent(priceLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeSalePaneLayout.createSequentialGroup()
                                                .addGap(0, 4, Short.MAX_VALUE)
                                                .addComponent(boardNumLabel)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(currentPriceLabel)
                                            .addComponent(boardNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2)))
                                .addGap(43, 43, 43)
                                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                                        .addComponent(modelLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                                        .addComponent(installmentPeriodLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InstallmentPeriodDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(monthsLabel))
                                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                                        .addComponent(installmentLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(installmentCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                                        .addComponent(downPaymentLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(downPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(111, 111, 111))
                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                        .addComponent(motorcycleDetailsSeparator)
                        .addGap(66, 66, 66))))
            .addGroup(makeSalePaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bankAccountNumLabel)
                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(contactNumLabel))
                        .addGap(85, 85, 85)
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeSalePaneLayout.createSequentialGroup()
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(permanentAddressLabel)
                            .addComponent(currentAddressLabel))
                        .addGap(34, 34, 34)
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(permanentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bankAccountNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
            .addComponent(confirmSaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        makeSalePaneLayout.setVerticalGroup(
            makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makeSalePaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(customerDetailsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerDetailsSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumLabel)
                    .addComponent(idNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addGap(38, 38, 38)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel))
                .addGap(37, 37, 37)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNumLabel)
                    .addComponent(contactNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankAccountNumLabel)
                    .addComponent(bankAccountNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(permanentAddressLabel)
                    .addComponent(permanentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentAddressLabel)
                    .addComponent(currentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(contentSepratorOne, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(motorcycleDetailsLabel)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(makeSalePaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motorcycleDetailsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brandLabel)
                            .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelLabel)
                            .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boardNumLabel)
                            .addComponent(installmentLabel)
                            .addComponent(boardNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, makeSalePaneLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(installmentCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPriceLabel)
                    .addComponent(priceLabel)
                    .addComponent(installmentPeriodLabel)
                    .addComponent(InstallmentPeriodDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(makeSalePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(downPaymentLabel)
                    .addComponent(downPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(confirmSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        makeSalePanel.setViewportView(makeSalePane);

        parentPanel.add(makeSalePanel, "card2");

        inventoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        inventoryTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        inventoryTable.setEnabled(false);
        inventoryTablePane.setViewportView(inventoryTable);

        inventoryMenu.setBackground(new java.awt.Color(19, 15, 64));

        modifyInventoryButton.setBackground(new java.awt.Color(244, 244, 244));
        modifyInventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modifyInventoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/modify.png"))); // NOI18N
        modifyInventoryButton.setText("  Modify           ");
        modifyInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modifyInventoryButton.setContentAreaFilled(false);
        modifyInventoryButton.setOpaque(true);
        modifyInventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modifyInventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modifyInventoryButtonMouseExited(evt);
            }
        });
        modifyInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyInventoryButtonActionPerformed(evt);
            }
        });

        addToInventoryButton.setBackground(new java.awt.Color(244, 244, 244));
        addToInventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        addToInventoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addToInventoryButton.setText("    Add         ");
        addToInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addToInventoryButton.setContentAreaFilled(false);
        addToInventoryButton.setOpaque(true);
        addToInventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addToInventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addToInventoryButtonMouseExited(evt);
            }
        });
        addToInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToInventoryButtonActionPerformed(evt);
            }
        });

        removeInventoryButton.setBackground(new java.awt.Color(244, 244, 244));
        removeInventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        removeInventoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        removeInventoryButton.setText("  Remove       ");
        removeInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        removeInventoryButton.setContentAreaFilled(false);
        removeInventoryButton.setOpaque(true);
        removeInventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeInventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeInventoryButtonMouseExited(evt);
            }
        });
        removeInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeInventoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventoryMenuLayout = new javax.swing.GroupLayout(inventoryMenu);
        inventoryMenu.setLayout(inventoryMenuLayout);
        inventoryMenuLayout.setHorizontalGroup(
            inventoryMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryMenuLayout.createSequentialGroup()
                .addComponent(addToInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170)
                .addComponent(removeInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(201, 201, 201)
                .addComponent(modifyInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inventoryMenuLayout.setVerticalGroup(
            inventoryMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryMenuLayout.createSequentialGroup()
                .addGroup(inventoryMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyInventoryButton)
                    .addComponent(addToInventoryButton)
                    .addComponent(removeInventoryButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inventoryPanelParent.setBackground(new java.awt.Color(255, 255, 255));
        inventoryPanelParent.setLayout(new java.awt.CardLayout());

        addNewMotorcycles.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        jLabel2.setText("Add New Motorcycle");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel3.setText("Brand:");

        jLabel4.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel4.setText("Model:");

        jLabel5.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel6.setText("Price:");

        brandInputField.setBackground(new java.awt.Color(229, 229, 229));
        brandInputField.setBorder(null);

        modelInputField.setBackground(new java.awt.Color(229, 229, 229));
        modelInputField.setBorder(null);

        quantityInputField.setBackground(new java.awt.Color(229, 229, 229));
        quantityInputField.setBorder(null);
        quantityInputField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        priceInputField.setBackground(new java.awt.Color(229, 229, 229));
        priceInputField.setBorder(null);
        priceInputField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        confirmAddToInventoryButton.setBackground(new java.awt.Color(161, 202, 141));
        confirmAddToInventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmAddToInventoryButton.setText("Confirm");
        confirmAddToInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmAddToInventoryButton.setContentAreaFilled(false);
        confirmAddToInventoryButton.setFocusPainted(false);
        confirmAddToInventoryButton.setOpaque(true);
        confirmAddToInventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmAddToInventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmAddToInventoryButtonMouseExited(evt);
            }
        });
        confirmAddToInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddToInventoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addNewMotorcyclesLayout = new javax.swing.GroupLayout(addNewMotorcycles);
        addNewMotorcycles.setLayout(addNewMotorcyclesLayout);
        addNewMotorcyclesLayout.setHorizontalGroup(
            addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmAddToInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addNewMotorcyclesLayout.createSequentialGroup()
                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewMotorcyclesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(brandInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNewMotorcyclesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modelInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNewMotorcyclesLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNewMotorcyclesLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(priceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNewMotorcyclesLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        addNewMotorcyclesLayout.setVerticalGroup(
            addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewMotorcyclesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(brandInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(modelInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantityInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewMotorcyclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(confirmAddToInventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inventoryPanelParent.add(addNewMotorcycles, "card2");

        removeMotorcycle.setBackground(new java.awt.Color(255, 255, 255));

        removeMotorcycleLabel.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        removeMotorcycleLabel.setText("Remove Motorcycle");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

        brandLabel1.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandLabel1.setText("Brand:");

        brandComboBoxInventory.setBackground(new java.awt.Color(229, 229, 229));
        brandComboBoxInventory.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandComboBoxInventory.setBorder(null);
        brandComboBoxInventory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxInventoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxInventoryPopupMenuWillBecomeVisible(evt);
            }
        });

        modelLabel1.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelLabel1.setText("Model:");

        modelComboBoxInventory.setBackground(new java.awt.Color(229, 229, 229));
        modelComboBoxInventory.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelComboBoxInventory.setBorder(null);
        modelComboBoxInventory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                modelComboBoxInventoryPopupMenuWillBecomeVisible(evt);
            }
        });

        confirmRemoveFromInventoryButton.setBackground(new java.awt.Color(209, 229, 199));
        confirmRemoveFromInventoryButton.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmRemoveFromInventoryButton.setText("Confirm");
        confirmRemoveFromInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmRemoveFromInventoryButton.setContentAreaFilled(false);
        confirmRemoveFromInventoryButton.setFocusPainted(false);
        confirmRemoveFromInventoryButton.setOpaque(true);
        confirmRemoveFromInventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmRemoveFromInventoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmRemoveFromInventoryButtonMouseExited(evt);
            }
        });
        confirmRemoveFromInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRemoveFromInventoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout removeMotorcycleLayout = new javax.swing.GroupLayout(removeMotorcycle);
        removeMotorcycle.setLayout(removeMotorcycleLayout);
        removeMotorcycleLayout.setHorizontalGroup(
            removeMotorcycleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmRemoveFromInventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(removeMotorcycleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(removeMotorcycleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(removeMotorcycleLayout.createSequentialGroup()
                        .addComponent(modelLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(modelComboBoxInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(removeMotorcycleLabel)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(removeMotorcycleLayout.createSequentialGroup()
                        .addComponent(brandLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(brandComboBoxInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        removeMotorcycleLayout.setVerticalGroup(
            removeMotorcycleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeMotorcycleLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(removeMotorcycleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(removeMotorcycleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandLabel1)
                    .addComponent(brandComboBoxInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(removeMotorcycleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelComboBoxInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(confirmRemoveFromInventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        inventoryPanelParent.add(removeMotorcycle, "card3");

        modifyInventoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        removeMotorcycleLabel1.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        removeMotorcycleLabel1.setText("Remove Motorcycle");

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));

        brandLabel2.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandLabel2.setText("Brand:");

        brandComboBoxInventory1.setBackground(new java.awt.Color(229, 229, 229));
        brandComboBoxInventory1.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandComboBoxInventory1.setBorder(null);
        brandComboBoxInventory1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxInventory1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                brandComboBoxInventory1PopupMenuWillBecomeVisible(evt);
            }
        });

        modelLabel2.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelLabel2.setText("Model:");

        modelComboBoxInventory1.setBackground(new java.awt.Color(229, 229, 229));
        modelComboBoxInventory1.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelComboBoxInventory1.setBorder(null);
        modelComboBoxInventory1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                modelComboBoxInventory1PopupMenuWillBecomeVisible(evt);
            }
        });

        confirmRemoveFromInventoryButton1.setBackground(new java.awt.Color(209, 229, 199));
        confirmRemoveFromInventoryButton1.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmRemoveFromInventoryButton1.setText("Confirm");
        confirmRemoveFromInventoryButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmRemoveFromInventoryButton1.setContentAreaFilled(false);
        confirmRemoveFromInventoryButton1.setFocusPainted(false);
        confirmRemoveFromInventoryButton1.setOpaque(true);
        confirmRemoveFromInventoryButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmRemoveFromInventoryButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmRemoveFromInventoryButton1MouseExited(evt);
            }
        });
        confirmRemoveFromInventoryButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRemoveFromInventoryButton1ActionPerformed(evt);
            }
        });

        quantityInputField1.setBackground(new java.awt.Color(229, 229, 229));
        quantityInputField1.setBorder(null);
        quantityInputField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        priceInputField1.setBackground(new java.awt.Color(229, 229, 229));
        priceInputField1.setBorder(null);
        priceInputField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        modelLabel3.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelLabel3.setText("Quantity:");

        modelLabel4.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modelLabel4.setText("Price:");

        javax.swing.GroupLayout modifyInventoryPanelLayout = new javax.swing.GroupLayout(modifyInventoryPanel);
        modifyInventoryPanel.setLayout(modifyInventoryPanelLayout);
        modifyInventoryPanelLayout.setHorizontalGroup(
            modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmRemoveFromInventoryButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(modifyInventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeMotorcycleLabel1)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(modifyInventoryPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(brandLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brandComboBoxInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modifyInventoryPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(priceInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(modifyInventoryPanelLayout.createSequentialGroup()
                                    .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyInventoryPanelLayout.createSequentialGroup()
                                            .addComponent(modelLabel2)
                                            .addGap(32, 32, 32))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyInventoryPanelLayout.createSequentialGroup()
                                            .addComponent(modelLabel4)
                                            .addGap(39, 39, 39))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyInventoryPanelLayout.createSequentialGroup()
                                            .addComponent(modelLabel3)
                                            .addGap(18, 18, 18)))
                                    .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(quantityInputField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(modelComboBoxInventory1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        modifyInventoryPanelLayout.setVerticalGroup(
            modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyInventoryPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(removeMotorcycleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandComboBoxInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandLabel2))
                .addGap(14, 14, 14)
                .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelComboBoxInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel2))
                .addGap(18, 18, 18)
                .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(modifyInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel4))
                .addGap(18, 18, 18)
                .addComponent(confirmRemoveFromInventoryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        inventoryPanelParent.add(modifyInventoryPanel, "card3");

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventoryTablePane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(inventoryPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryTablePane, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventoryMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventoryPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parentPanel.add(inventoryPanel, "card3");

        customersTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customersScrollPane.setViewportView(customersTable);

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addComponent(customersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        parentPanel.add(customersPanel, "card8");

        salesHistoryTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        salesHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        salesHistoryTable.setEnabled(false);
        salesHistoryPane.setViewportView(salesHistoryTable);

        parentPanel.add(salesHistoryPane, "card5");

        usersTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        usersTable.setEnabled(false);
        usersTablePane.setViewportView(usersTable);

        usersMenu.setBackground(new java.awt.Color(19, 15, 64));

        viewUsersAccess.setBackground(new java.awt.Color(244, 244, 244));
        viewUsersAccess.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        viewUsersAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users_history.png"))); // NOI18N
        viewUsersAccess.setText("    User Access History    ");
        viewUsersAccess.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewUsersAccess.setContentAreaFilled(false);
        viewUsersAccess.setOpaque(true);
        viewUsersAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewUsersAccessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewUsersAccessMouseExited(evt);
            }
        });
        viewUsersAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsersAccessActionPerformed(evt);
            }
        });

        modifyUserBUtton.setBackground(new java.awt.Color(244, 244, 244));
        modifyUserBUtton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modifyUserBUtton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/modify.png"))); // NOI18N
        modifyUserBUtton.setText("  Modify  ");
        modifyUserBUtton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modifyUserBUtton.setContentAreaFilled(false);
        modifyUserBUtton.setOpaque(true);
        modifyUserBUtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modifyUserBUttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modifyUserBUttonMouseExited(evt);
            }
        });
        modifyUserBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyUserBUttonActionPerformed(evt);
            }
        });

        removeUserButton.setBackground(new java.awt.Color(244, 244, 244));
        removeUserButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        removeUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        removeUserButton.setText("  Remove  ");
        removeUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        removeUserButton.setContentAreaFilled(false);
        removeUserButton.setOpaque(true);
        removeUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeUserButtonMouseExited(evt);
            }
        });
        removeUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUserButtonActionPerformed(evt);
            }
        });

        addUsersButton.setBackground(new java.awt.Color(244, 244, 244));
        addUsersButton.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        addUsersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addUsersButton.setText("    Add    ");
        addUsersButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addUsersButton.setContentAreaFilled(false);
        addUsersButton.setOpaque(true);
        addUsersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUsersButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUsersButtonMouseExited(evt);
            }
        });
        addUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usersMenuLayout = new javax.swing.GroupLayout(usersMenu);
        usersMenu.setLayout(usersMenuLayout);
        usersMenuLayout.setHorizontalGroup(
            usersMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewUsersAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifyUserBUtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        usersMenuLayout.setVerticalGroup(
            usersMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usersMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyUserBUtton)
                    .addComponent(removeUserButton)
                    .addComponent(viewUsersAccess)
                    .addComponent(addUsersButton))
                .addContainerGap())
        );

        userSettingsParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        userSettingsParentPanel.setLayout(new java.awt.CardLayout());

        usersAccessHistoryTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        usersAccessHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        usersAccessHistoryTable.setEnabled(false);
        usersAccessHistoryPanel.setViewportView(usersAccessHistoryTable);

        userSettingsParentPanel.add(usersAccessHistoryPanel, "card2");

        addNewUserPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        jLabel7.setText("Add New User");

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel8.setText("Username:");

        jLabel9.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel9.setText("Password:");

        jLabel10.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel10.setText("Role:");

        usernameInputField.setBackground(new java.awt.Color(229, 229, 229));
        usernameInputField.setBorder(null);

        passwordInputField.setBackground(new java.awt.Color(229, 229, 229));
        passwordInputField.setBorder(null);

        confirmAddUser.setBackground(new java.awt.Color(161, 202, 141));
        confirmAddUser.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmAddUser.setText("Confirm");
        confirmAddUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmAddUser.setContentAreaFilled(false);
        confirmAddUser.setFocusPainted(false);
        confirmAddUser.setOpaque(true);
        confirmAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmAddUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmAddUserMouseExited(evt);
            }
        });
        confirmAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddUserActionPerformed(evt);
            }
        });

        roleSelectDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        roleSelectDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        roleSelectDropDownMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Sales", "Procument" }));
        roleSelectDropDownMenu.setSelectedIndex(-1);
        roleSelectDropDownMenu.setBorder(null);

        javax.swing.GroupLayout addNewUserPanelLayout = new javax.swing.GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(addNewUserPanelLayout);
        addNewUserPanelLayout.setHorizontalGroup(
            addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(usernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addNewUserPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roleSelectDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        addNewUserPanelLayout.setVerticalGroup(
            addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleSelectDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(51, 51, 51)
                .addComponent(confirmAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userSettingsParentPanel.add(addNewUserPanel, "card2");

        removeUsersPanel.setBackground(new java.awt.Color(255, 255, 255));

        removeUserLabel.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        removeUserLabel.setText("Remove User");

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));

        brandLabel3.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        brandLabel3.setText("Username:");

        usernameSelectDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        usernameSelectDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        usernameSelectDropDownMenu.setBorder(null);
        usernameSelectDropDownMenu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                usernameSelectDropDownMenuPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                usernameSelectDropDownMenuPopupMenuWillBecomeVisible(evt);
            }
        });
        usernameSelectDropDownMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameSelectDropDownMenuActionPerformed(evt);
            }
        });

        confirmRemoveUser.setBackground(new java.awt.Color(209, 229, 199));
        confirmRemoveUser.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmRemoveUser.setText("Confirm");
        confirmRemoveUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmRemoveUser.setContentAreaFilled(false);
        confirmRemoveUser.setFocusPainted(false);
        confirmRemoveUser.setOpaque(true);
        confirmRemoveUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmRemoveUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmRemoveUserMouseExited(evt);
            }
        });
        confirmRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRemoveUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout removeUsersPanelLayout = new javax.swing.GroupLayout(removeUsersPanel);
        removeUsersPanel.setLayout(removeUsersPanelLayout);
        removeUsersPanelLayout.setHorizontalGroup(
            removeUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(removeUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(removeUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeUserLabel)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(removeUsersPanelLayout.createSequentialGroup()
                        .addComponent(brandLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(usernameSelectDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        removeUsersPanelLayout.setVerticalGroup(
            removeUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeUsersPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(removeUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(removeUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandLabel3)
                    .addComponent(usernameSelectDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(confirmRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userSettingsParentPanel.add(removeUsersPanel, "card3");

        modifyUsersPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        jLabel11.setText("Modify User");

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel12.setText("Username:");

        jLabel13.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel13.setText("Password:");

        jLabel14.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel14.setText("Role:");

        newPasswordInputField.setBackground(new java.awt.Color(229, 229, 229));
        newPasswordInputField.setBorder(null);

        confirmModifyUser.setBackground(new java.awt.Color(161, 202, 141));
        confirmModifyUser.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmModifyUser.setText("Confirm");
        confirmModifyUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmModifyUser.setContentAreaFilled(false);
        confirmModifyUser.setFocusPainted(false);
        confirmModifyUser.setOpaque(true);
        confirmModifyUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmModifyUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmModifyUserMouseExited(evt);
            }
        });
        confirmModifyUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmModifyUserActionPerformed(evt);
            }
        });

        modifyUsernameDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        modifyUsernameDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modifyUsernameDropDownMenu.setBorder(null);

        modifyRoleDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        modifyRoleDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        modifyRoleDropDownMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Sales", "Procument" }));
        modifyRoleDropDownMenu.setSelectedIndex(-1);
        modifyRoleDropDownMenu.setSelectedItem(null);
        modifyRoleDropDownMenu.setBorder(null);

        javax.swing.GroupLayout modifyUsersPanelLayout = new javax.swing.GroupLayout(modifyUsersPanel);
        modifyUsersPanel.setLayout(modifyUsersPanelLayout);
        modifyUsersPanelLayout.setHorizontalGroup(
            modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmModifyUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(modifyUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modifyUsersPanelLayout.createSequentialGroup()
                        .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modifyUsersPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modifyUsernameDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modifyUsersPanelLayout.createSequentialGroup()
                                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modifyRoleDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        modifyUsersPanelLayout.setVerticalGroup(
            modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(modifyUsernameDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(modifyUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(modifyRoleDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(confirmModifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        userSettingsParentPanel.add(modifyUsersPanel, "card2");

        javax.swing.GroupLayout usersSettingsPanelLayout = new javax.swing.GroupLayout(usersSettingsPanel);
        usersSettingsPanel.setLayout(usersSettingsPanelLayout);
        usersSettingsPanelLayout.setHorizontalGroup(
            usersSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersSettingsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(usersSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usersSettingsPanelLayout.createSequentialGroup()
                        .addComponent(userSettingsParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(usersTablePane)))
            .addGroup(usersSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usersSettingsPanelLayout.setVerticalGroup(
            usersSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usersMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userSettingsParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        parentPanel.add(usersSettingsPanel, "card3");

        installmentsPanel.setBackground(new java.awt.Color(255, 255, 255));

        installmentsTable.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        installmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        installmentsTable.setEnabled(false);
        installmentsPane.setViewportView(installmentsTable);

        payInstallmentsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 18)); // NOI18N
        jLabel15.setText("Pay Installment");

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel16.setText("Id Number:");

        jLabel17.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel17.setText("Payment:");

        jLabel18.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        jLabel18.setText("Board Number:");

        confirmPayInstallment.setBackground(new java.awt.Color(161, 202, 141));
        confirmPayInstallment.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        confirmPayInstallment.setText("Confirm");
        confirmPayInstallment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmPayInstallment.setContentAreaFilled(false);
        confirmPayInstallment.setFocusPainted(false);
        confirmPayInstallment.setOpaque(true);
        confirmPayInstallment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmPayInstallmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmPayInstallmentMouseExited(evt);
            }
        });
        confirmPayInstallment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPayInstallmentActionPerformed(evt);
            }
        });

        idNumberDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        idNumberDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        idNumberDropDownMenu.setBorder(null);

        boardNumDropDownMenu.setBackground(new java.awt.Color(229, 229, 229));
        boardNumDropDownMenu.setFont(new java.awt.Font("NewsGoth Lt BT", 0, 14)); // NOI18N
        boardNumDropDownMenu.setSelectedIndex(-1);
        boardNumDropDownMenu.setSelectedItem(null);
        boardNumDropDownMenu.setBorder(null);

        paymentsField.setBackground(new java.awt.Color(229, 229, 229));
        paymentsField.setBorder(null);
        paymentsField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####0.###"))));

        javax.swing.GroupLayout payInstallmentsPanelLayout = new javax.swing.GroupLayout(payInstallmentsPanel);
        payInstallmentsPanel.setLayout(payInstallmentsPanelLayout);
        payInstallmentsPanelLayout.setHorizontalGroup(
            payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmPayInstallment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                        .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                        .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idNumberDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boardNumDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paymentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15))
                        .addContainerGap(221, Short.MAX_VALUE))))
        );
        payInstallmentsPanelLayout.setVerticalGroup(
            payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payInstallmentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(idNumberDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boardNumDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(payInstallmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmPayInstallment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout installmentsPanelLayout = new javax.swing.GroupLayout(installmentsPanel);
        installmentsPanel.setLayout(installmentsPanelLayout);
        installmentsPanelLayout.setHorizontalGroup(
            installmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installmentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(installmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(installmentsPanelLayout.createSequentialGroup()
                        .addComponent(installmentsPane)
                        .addGap(8, 8, 8))
                    .addGroup(installmentsPanelLayout.createSequentialGroup()
                        .addComponent(payInstallmentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        installmentsPanelLayout.setVerticalGroup(
            installmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, installmentsPanelLayout.createSequentialGroup()
                .addComponent(installmentsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payInstallmentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        parentPanel.add(installmentsPanel, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(parentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 713, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeSaleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeSaleButtonMouseEntered
        // TODO add your handling code here:
        if(isMakeSalePanelActive == true){
            makeSaleButton.setBackground(new Color(178, 229, 153));
        }else{
            makeSaleButton.setBackground(new Color(229, 229, 229));
        }
        
            
    }//GEN-LAST:event_makeSaleButtonMouseEntered

    private void makeSaleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeSaleButtonMouseExited
        // TODO add your handling code here:
        if(isMakeSalePanelActive == true){
            makeSaleButton.setBackground(new Color(161,202,141));
        }else{
            makeSaleButton.setBackground(new Color(244,244,244));
        }
        
        
        
    }//GEN-LAST:event_makeSaleButtonMouseExited

    private void salesHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoryButtonMouseEntered
        // TODO add your handling code here:
        if(isSalesHistoryTableActive == true){
            salesHistoryButton.setBackground(new Color(178, 229, 153));
        }else{
            salesHistoryButton.setBackground(new Color(229, 229, 229));
        }
    }//GEN-LAST:event_salesHistoryButtonMouseEntered

    private void salesHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoryButtonMouseExited
        // TODO add your handling code here:
        if(isSalesHistoryTableActive == true){
            salesHistoryButton.setBackground(new Color(161,202,141));
        }else{
            salesHistoryButton.setBackground(new Color(244, 244, 244));
        }
    }//GEN-LAST:event_salesHistoryButtonMouseExited

    private void inventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryButtonMouseEntered
        // TODO add your handling code here:
        if(isInventoryPanelActive == true){
            inventoryButton.setBackground(new Color(178, 229, 153));
        }else{
            inventoryButton.setBackground(new Color(229, 229, 229));
        }
    }//GEN-LAST:event_inventoryButtonMouseEntered

    private void inventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryButtonMouseExited
        // TODO add your handling code here:
        if(isInventoryPanelActive == true){
            inventoryButton.setBackground(new Color(161,202,141));
        }else{
            inventoryButton.setBackground(new Color(244, 244, 244));
        }
    }//GEN-LAST:event_inventoryButtonMouseExited

    private void customersButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersButtonMouseEntered
        // TODO add your handling code here:
        if(isCustomersTableActive == true){
            customersButton.setBackground(new Color(178, 229, 153));
        }else{
            customersButton.setBackground(new Color(229, 229, 229));
        }
    }//GEN-LAST:event_customersButtonMouseEntered

    private void customersButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersButtonMouseExited
        // TODO add your handling code here:
        if(isCustomersTableActive == true){
            customersButton.setBackground(new Color(161,202,141));
        }else{
            customersButton.setBackground(new Color(244, 244, 244));
        }
    }//GEN-LAST:event_customersButtonMouseExited

    private void usersSettingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersSettingsButtonMouseEntered
        // TODO add your handling code here:
       if(isViewInstallmentsTableActive == true){
            usersSettingsButton.setBackground(new Color(178, 229, 153));
        }else{
            usersSettingsButton.setBackground(new Color(229, 229, 229));
        }
    }//GEN-LAST:event_usersSettingsButtonMouseEntered

    private void usersSettingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersSettingsButtonMouseExited
        // TODO add your handling code here:
        if(isViewInstallmentsTableActive == true){
            usersSettingsButton.setBackground(new Color(161,202,141));
        }else{
            usersSettingsButton.setBackground(new Color(244, 244, 244));
        }
    }//GEN-LAST:event_usersSettingsButtonMouseExited

    private void salesHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesHistoryButtonActionPerformed
        // TODO add your handling code here:
        parentPanel.removeAll();
        parentPanel.add(salesHistoryPane);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        resetButtonsColors();
        salesHistoryButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = false;
        isInventoryPanelActive = false;
        isCustomersTableActive = false;
        isSalesHistoryTableActive = true;
        isViewInstallmentsTableActive = false;
        isUsersSettingsPanelActive = false;
        
        try {
            database.UpdateUIView.updateTableView(salesHistoryTable, database.UpdateUISQL.VIEW_SALES_HISTORY_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_salesHistoryButtonActionPerformed

    private void viewInstallmentsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInstallmentsButtonMouseEntered
        // TODO add your handling code here:
        if(isUsersSettingsPanelActive == true){
            viewInstallmentsButton.setBackground(new Color(178, 229, 153));
        }else{
            viewInstallmentsButton.setBackground(new Color(229, 229, 229));
        }
    }//GEN-LAST:event_viewInstallmentsButtonMouseEntered

    private void viewInstallmentsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInstallmentsButtonMouseExited
        // TODO add your handling code here:
        if(isUsersSettingsPanelActive == true){
            viewInstallmentsButton.setBackground(new Color(161,202,141));
        }else{
            viewInstallmentsButton.setBackground(new Color(244, 244, 244));
        }
    }//GEN-LAST:event_viewInstallmentsButtonMouseExited

    private void makeSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeSaleButtonActionPerformed
        // TODO add your handling code here:
        parentPanel.removeAll();
        parentPanel.add(makeSalePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        resetButtonsColors();
        makeSaleButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = true;
        isInventoryPanelActive = false;
        isCustomersTableActive = false;
        isSalesHistoryTableActive = false;
        isViewInstallmentsTableActive = false;
        isUsersSettingsPanelActive = false;
    }//GEN-LAST:event_makeSaleButtonActionPerformed

    private void confirmSaleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmSaleButtonMouseEntered
        // TODO add your handling code here:
         confirmSaleButton.setBackground(new Color(182, 215, 168));
        
    }//GEN-LAST:event_confirmSaleButtonMouseEntered

    private void confirmSaleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmSaleButtonMouseExited
        // TODO add your handling code here:
        confirmSaleButton.setBackground(new Color(209, 229, 199));
    }//GEN-LAST:event_confirmSaleButtonMouseExited

    private void confirmSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSaleButtonActionPerformed
        /*
        if the customer is new update the customer database
        */
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String identityNumber = idNumField.getText();
        String permanentAddress = permanentAddressField.getText();
        String currentAddress = currentAddressField.getText();
        int contactNumber = Integer.parseInt(contactNumberField.getText());
        System.out.println(contactNumber);
        int bankAccountNum = Integer.parseInt(bankAccountNumField.getText());
        System.out.println(bankAccountNum);
        
        Customer updateCustomers = new Customer(
                                             firstName, lastName, identityNumber,
                                             permanentAddress, currentAddress,
                                             contactNumber, bankAccountNum);
        
        //update the database
        try {
            updateCustomers.updateCustomerDatabase();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        } catch (Exception e){
            System.out.println("An error updating the customers table");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.redefineErrorMessage("An error occured while updating customers!");
            errorMessage.setVisible(true);
        }
        
        //update the sold motorcycles
        String brand = brandComboBox.getSelectedItem().toString();
        String model = modelComboBox.getSelectedItem().toString();
        String boardNumber = boardNumField.getText();
        int soldAmount = Integer.parseInt(currentPriceLabel.getText());
        boolean installmentChecked = installmentCheckBox.isSelected();
        
        if(installmentChecked == true){ //if it is taken for installment
            int downPayment = Integer.parseInt(downPaymentField.getText());
            int installmentPeriod = Integer.parseInt(InstallmentPeriodDropDownMenu.getSelectedItem().toString());
            
            //create sold motorcycle object
            SoldMotorcycle installmentSoldMotorcycle = new SoldMotorcycle(brand, model, boardNumber, downPayment,
                                                                          installmentPeriod, installmentChecked);
            try {
                if(installmentSoldMotorcycle.soldIDNumber() == 0){
                    //deduct from inventory and update sold motorcycle table
                    installmentSoldMotorcycle.deductMotorcycleFromInventory();
                    installmentSoldMotorcycle.updateSoldMotorcycleTable();

                    
                    //update the purchases and installments tables
                    PurchaseAndInstallment installment = new PurchaseAndInstallment(); //default empty constructor
                    //update purchase table
                    installment.updatePurchaseTable(boardNumber, identityNumber);
                    
                    //update installments
                    installment.updateInstallmentsTable(boardNumber, identityNumber, installmentPeriod, soldAmount, downPayment);

                } else if(installmentSoldMotorcycle.soldIDNumber() > 0){
                    System.out.println("BoardNumber Exists!");
                    ErrorMessage errorMessage = new ErrorMessage();
                    errorMessage.redefineErrorMessage("A Motorcycle with that BoardNumber exists");
                    errorMessage.setVisible(true);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.setVisible(true);
            } catch (Exception e){
                System.out.println("Error updating installments");
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.redefineErrorMessage("An error occured while updating installments!");
                errorMessage.setVisible(true);
                
            }

        } else if(installmentChecked == false){ //it is taken for fullpayment
            
            //create sold motorcycle object
            SoldMotorcycle fullPaidMotorcycle = new SoldMotorcycle(brand, model, boardNumber, soldAmount, installmentChecked);
            try {
                //deduct from inventory and update the motorcycle table
                if(fullPaidMotorcycle.soldIDNumber() == 0){
                    fullPaidMotorcycle.deductMotorcycleFromInventory();
                    fullPaidMotorcycle.updateSoldMotorcycleTable();
                    
                    //update the purchases table
                    PurchaseAndInstallment updatePurchases = new PurchaseAndInstallment(); //default empty constructor
                    updatePurchases.updatePurchaseTable(boardNumber, identityNumber);
                
                }else if(fullPaidMotorcycle.soldIDNumber() > 0){
                    System.out.println("Motorcycle with BoardNumber Exists!");
                    ErrorMessage errorMessage = new ErrorMessage();
                    errorMessage.redefineErrorMessage("Motorcycle with that BoardNumber Exists!");
                    errorMessage.setVisible(true);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.setVisible(true);
            }
        }//end if
        
        //reset the fields
        
        resetFields(firstNameField, lastNameField, idNumField, permanentAddressField, currentAddressField, contactNumberField,
                    bankAccountNumField);
        brandComboBox.setSelectedIndex(-1);
        modelComboBox.setSelectedIndex(-1);
        boardNumField.setText("");
        currentPriceLabel.setText("Motorcycle Price");
        if(installmentCheckBox.isSelected() == true){
            downPaymentField.setText("");
            InstallmentPeriodDropDownMenu.setSelectedIndex(1);
            installmentCheckBox.setSelected(false);
        }
        
    }//GEN-LAST:event_confirmSaleButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        // update the user interface
        parentPanel.removeAll();
        parentPanel.add(inventoryPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        resetButtonsColors();
        inventoryButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = false;
        isInventoryPanelActive = true;
        isCustomersTableActive = false;
        isSalesHistoryTableActive = false;
        isViewInstallmentsTableActive = false;
        isUsersSettingsPanelActive = false;
        
        try {
            //update the table
            database.UpdateUIView.updateTableView(inventoryTable, database.UpdateUISQL.VIEW_INVENTORY_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
        
        
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void customersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersButtonActionPerformed
        // update the user interface
        parentPanel.removeAll();
        parentPanel.add(customersPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        resetButtonsColors();
        customersButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = false;
        isInventoryPanelActive = false;
        isCustomersTableActive = true;
        isSalesHistoryTableActive = false;
        isViewInstallmentsTableActive = false;
        isUsersSettingsPanelActive = false;
        
        try {
            database.UpdateUIView.updateTableView(customersTable, database.UpdateUISQL.VIEW_CUSTOMERS_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_customersButtonActionPerformed

    private void usersSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSettingsButtonActionPerformed
        // Update the user interface
        parentPanel.removeAll();
        parentPanel.add(usersSettingsPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        resetButtonsColors();
        usersSettingsButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = false;
        isInventoryPanelActive = false;
        isCustomersTableActive = false;
        isSalesHistoryTableActive = false;
        isViewInstallmentsTableActive = true;
        isUsersSettingsPanelActive = false;
        
        try {
            database.UpdateUIView.updateTableView(usersTable, database.UpdateUISQL.VIEW_USERS_TABLE_SQL);
            database.UpdateUIView.updateTableView(usersAccessHistoryTable, database.UpdateUISQL.VIEW_USERS_ACCESS_HISTORY_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_usersSettingsButtonActionPerformed

    private void viewInstallmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewInstallmentsButtonActionPerformed
        // update the user interface
        parentPanel.removeAll();
        parentPanel.add(installmentsPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        
        resetButtonsColors();
        viewInstallmentsButton.setBackground(new Color(197, 223, 185));
        
        isMakeSalePanelActive = false;
        isInventoryPanelActive = false;
        isCustomersTableActive = false;
        isSalesHistoryTableActive = false;
        isViewInstallmentsTableActive = false;
        isUsersSettingsPanelActive = true;
        
        try {
            database.UpdateUIView.updateTableView(installmentsTable, database.UpdateUISQL.VIEW_INSTALLMENTS_TABLE_SQL);
            updateComboBoxView(idNumberDropDownMenu, INSERT_CUSTOMER_COMBO_BOX_INSTALLMENT, "NID");
            updateComboBoxView(idNumberDropDownMenu,boardNumDropDownMenu, INSERT_BRAND_TO_COMBO_BOX_INSTALLMENT, "BoardNumber");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_viewInstallmentsButtonActionPerformed

    private void modifyUserBUttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyUserBUttonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyUserBUttonMouseEntered

    private void modifyUserBUttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyUserBUttonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyUserBUttonMouseExited

    private void modifyUserBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyUserBUttonActionPerformed
        userSettingsParentPanel.removeAll();
        userSettingsParentPanel.add(modifyUsersPanel);
        userSettingsParentPanel.repaint();
        userSettingsParentPanel.revalidate();
        
        //add the  users to the combo box
        try {
            updateComboBoxView(modifyUsernameDropDownMenu, database.UpdateUISQL.INSERT_USER_TO_COMBO_BOX, "Username");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_modifyUserBUttonActionPerformed

    private void removeUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeUserButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_removeUserButtonMouseEntered

    private void removeUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeUserButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_removeUserButtonMouseExited

    private void removeUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserButtonActionPerformed
        userSettingsParentPanel.removeAll();
        userSettingsParentPanel.add(removeUsersPanel);
        userSettingsParentPanel.repaint();
        userSettingsParentPanel.revalidate();

        try {
            updateComboBoxView(usernameSelectDropDownMenu, database.UpdateUISQL.INSERT_USER_TO_COMBO_BOX, "Username");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_removeUserButtonActionPerformed

    private void installmentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installmentCheckBoxActionPerformed
        // TODO add your handling code here:
        if(installmentCheckBox.isSelected() == true){
            installmentPeriodLabel.setVisible(true);
            InstallmentPeriodDropDownMenu.setVisible(true);
            downPaymentLabel.setVisible(true);
            downPaymentField.setVisible(true);
            monthsLabel.setVisible(true);

        }else{
            installmentPeriodLabel.setVisible(false);
            InstallmentPeriodDropDownMenu.setVisible(false);
            downPaymentLabel.setVisible(false);
            downPaymentField.setVisible(false);
            monthsLabel.setVisible(false);
        }
    }//GEN-LAST:event_installmentCheckBoxActionPerformed

    private void idNumFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idNumFieldFocusLost
        //autocomplete the entire thing if customer exists in the database
        try {
            database.CustomerFormAutoComplete.autoCompleteSalesForm(idNumField, firstNameField, lastNameField, contactNumberField, bankAccountNumField, permanentAddressField, currentAddressField);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_idNumFieldFocusLost

    private void brandComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxPopupMenuWillBecomeInvisible
        //update the drop down menus based on which brand of motorcycle is selected
        try {
            modelComboBox.removeAllItems();
            UpdateUIView.updateComboBoxView(brandComboBox, modelComboBox, UpdateUISQL.INSERT_MODEL_TO_COMBO_BOX, "Model");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }        
    }//GEN-LAST:event_brandComboBoxPopupMenuWillBecomeInvisible

    private void modelComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_modelComboBoxPopupMenuWillBecomeInvisible
        try {
            currentPriceLabel.setText((UpdateUIView.updatePriceLabel(modelComboBox)));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.out.println("No items");
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.redefineErrorMessage("No items to add!");
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_modelComboBoxPopupMenuWillBecomeInvisible

    private void brandComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxPopupMenuWillBecomeVisible
        //update the combo box views
        try {
            UpdateUIView.updateComboBoxView(brandComboBox, UpdateUISQL.INSERT_BRAND_TO_COMBO_BOX, "Brand");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_brandComboBoxPopupMenuWillBecomeVisible

    private void addToInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToInventoryButtonActionPerformed
        inventoryPanelParent.removeAll();
        inventoryPanelParent.add(addNewMotorcycles);
        inventoryPanelParent.repaint();
        inventoryPanelParent.revalidate();
    }//GEN-LAST:event_addToInventoryButtonActionPerformed

    private void addToInventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToInventoryButtonMouseExited
        // TODO add your handling code here:
        addToInventoryButton.setBackground(new Color(209, 229, 199));
    }//GEN-LAST:event_addToInventoryButtonMouseExited

    private void addToInventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToInventoryButtonMouseEntered
        // TODO add your handling code here:
        addToInventoryButton.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_addToInventoryButtonMouseEntered

    private void removeInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeInventoryButtonActionPerformed
        inventoryPanelParent.removeAll();
        inventoryPanelParent.add(removeMotorcycle);
        inventoryPanelParent.repaint();
        inventoryPanelParent.revalidate();
    }//GEN-LAST:event_removeInventoryButtonActionPerformed

    private void removeInventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeInventoryButtonMouseExited
        // TODO add your handling code here:
        removeInventoryButton.setBackground(new Color(209, 229, 199));
    }//GEN-LAST:event_removeInventoryButtonMouseExited

    private void removeInventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeInventoryButtonMouseEntered
        // TODO add your handling code here:
        removeInventoryButton.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_removeInventoryButtonMouseEntered

    private void modifyInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyInventoryButtonActionPerformed
        inventoryPanelParent.removeAll();
        inventoryPanelParent.add(modifyInventoryPanel);
        inventoryPanelParent.repaint();
        inventoryPanelParent.revalidate();
    }//GEN-LAST:event_modifyInventoryButtonActionPerformed

    private void modifyInventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyInventoryButtonMouseExited
        // TODO add your handling code here:
        modifyInventoryButton.setBackground(new Color(209, 229, 199));
    }//GEN-LAST:event_modifyInventoryButtonMouseExited

    private void modifyInventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyInventoryButtonMouseEntered
        // TODO add your handling code here:
        modifyInventoryButton.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_modifyInventoryButtonMouseEntered

    private void confirmAddToInventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmAddToInventoryButtonMouseEntered
        // TODO add your handling code here:
        confirmAddToInventoryButton.setBackground(new Color(178, 229, 153));
    }//GEN-LAST:event_confirmAddToInventoryButtonMouseEntered

    private void confirmAddToInventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmAddToInventoryButtonMouseExited
        // TODO add your handling code here:
        confirmAddToInventoryButton.setBackground(new Color(161,202,141));
    }//GEN-LAST:event_confirmAddToInventoryButtonMouseExited

    private void confirmAddToInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddToInventoryButtonActionPerformed
        //get the input
        String brand = brandInputField.getText();
        String model = modelInputField.getText();
        int quantityInStock = Integer.parseInt(quantityInputField.getText());
        int price = Integer.parseInt(priceInputField.getText());
        
        //create the update inventory object
        InventoryMotorcycle updateInventory = new InventoryMotorcycle(brand, model, quantityInStock, price);
        
        //update the database
        try {
            updateInventory.updateMotorcycleDatabase();
            database.UpdateUIView.updateTableView(inventoryTable, database.UpdateUISQL.VIEW_INVENTORY_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        } catch (Exception e){
            System.out.println("Error in beep boop land");
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.redefineErrorMessage("The model already exists!");
            errorMessage.setVisible(true);
        }
        
        //reset the fields
        resetFields(brandInputField, modelInputField, quantityInputField, priceInputField);
        
    }//GEN-LAST:event_confirmAddToInventoryButtonActionPerformed

    private void brandComboBoxInventoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxInventoryPopupMenuWillBecomeInvisible
        //update view from database
        try {
            UpdateUIView.updateComboBoxView(brandComboBoxInventory, modelComboBoxInventory, UpdateUISQL.INSERT_MODEL_TO_COMBO_BOX, "Model");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_brandComboBoxInventoryPopupMenuWillBecomeInvisible

    private void confirmRemoveFromInventoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButtonMouseEntered
        // TODO add your handling code here:
        confirmAddToInventoryButton.setBackground(new Color(178, 229, 153));
    }//GEN-LAST:event_confirmRemoveFromInventoryButtonMouseEntered

    private void confirmRemoveFromInventoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButtonMouseExited
        // TODO add your handling code here:
        confirmAddToInventoryButton.setBackground(new Color(161,202,141));
    }//GEN-LAST:event_confirmRemoveFromInventoryButtonMouseExited

    private void confirmRemoveFromInventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButtonActionPerformed
        //get the values
        String model = modelComboBoxInventory.getSelectedItem().toString();
        System.out.println(model);
        //create the deletion object
        InventoryMotorcycle deleteFromInventory = new InventoryMotorcycle(model);
        
        //delete from db
        try {
            deleteFromInventory.deleteFromMotorcycleDatabase();
            database.UpdateUIView.updateTableView(inventoryTable, database.UpdateUISQL.VIEW_INVENTORY_TABLE_SQL); //update view
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_confirmRemoveFromInventoryButtonActionPerformed

    private void brandComboBoxInventoryPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxInventoryPopupMenuWillBecomeVisible
        try {
            UpdateUIView.updateComboBoxView(brandComboBoxInventory, UpdateUISQL.INSERT_BRAND_TO_COMBO_BOX, "Brand");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_brandComboBoxInventoryPopupMenuWillBecomeVisible

    private void modelComboBoxInventoryPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_modelComboBoxInventoryPopupMenuWillBecomeVisible
        //update view from database
        try {
            UpdateUIView.updateComboBoxView(brandComboBoxInventory, modelComboBoxInventory, UpdateUISQL.INSERT_MODEL_TO_COMBO_BOX, "Model");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_modelComboBoxInventoryPopupMenuWillBecomeVisible

    private void brandComboBoxInventory1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxInventory1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboBoxInventory1PopupMenuWillBecomeInvisible

    private void brandComboBoxInventory1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_brandComboBoxInventory1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_brandComboBoxInventory1PopupMenuWillBecomeVisible

    private void modelComboBoxInventory1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_modelComboBoxInventory1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_modelComboBoxInventory1PopupMenuWillBecomeVisible

    private void confirmRemoveFromInventoryButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmRemoveFromInventoryButton1MouseEntered

    private void confirmRemoveFromInventoryButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmRemoveFromInventoryButton1MouseExited

    private void confirmRemoveFromInventoryButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmRemoveFromInventoryButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmRemoveFromInventoryButton1ActionPerformed

    private void viewUsersAccessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewUsersAccessMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUsersAccessMouseEntered

    private void viewUsersAccessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewUsersAccessMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUsersAccessMouseExited

    private void viewUsersAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsersAccessActionPerformed
        userSettingsParentPanel.removeAll();
        userSettingsParentPanel.add(usersAccessHistoryPanel);
        userSettingsParentPanel.repaint();
        userSettingsParentPanel.revalidate();
        
        try {
            database.UpdateUIView.updateTableView(usersAccessHistoryTable, database.UpdateUISQL.VIEW_USERS_ACCESS_HISTORY_TABLE_SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_viewUsersAccessActionPerformed

    private void addUsersButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUsersButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addUsersButtonMouseEntered

    private void addUsersButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUsersButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addUsersButtonMouseExited

    private void addUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUsersButtonActionPerformed
        userSettingsParentPanel.removeAll();
        userSettingsParentPanel.add(addNewUserPanel);
        userSettingsParentPanel.repaint();
        userSettingsParentPanel.revalidate();  
    }//GEN-LAST:event_addUsersButtonActionPerformed

    private void confirmAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmAddUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmAddUserMouseEntered

    private void confirmAddUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmAddUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmAddUserMouseExited

    private void confirmAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddUserActionPerformed
        //get the input
        String username = usernameInputField.getText();
        String password = passwordInputField.getText();
        String role = roleSelectDropDownMenu.getSelectedItem().toString();
        
        //create the users object
        User addUser = new User(username, password, role);
        
        //add a new user
        try {
            addUser.insertNewUser();
            database.UpdateUIView.updateTableView(customersTable, database.UpdateUISQL.VIEW_CUSTOMERS_TABLE_SQL);            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
        
        usernameInputField.setText("");
        passwordInputField.setText("");
        roleSelectDropDownMenu.setSelectedIndex(-1);
    }//GEN-LAST:event_confirmAddUserActionPerformed

    private void usernameSelectDropDownMenuPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_usernameSelectDropDownMenuPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameSelectDropDownMenuPopupMenuWillBecomeInvisible

    private void usernameSelectDropDownMenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_usernameSelectDropDownMenuPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameSelectDropDownMenuPopupMenuWillBecomeVisible

    private void confirmRemoveUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmRemoveUserMouseEntered

    private void confirmRemoveUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmRemoveUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmRemoveUserMouseExited

    private void confirmRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmRemoveUserActionPerformed
        String username = usernameSelectDropDownMenu.getSelectedItem().toString(); //get the input
        
        User deleteUser = new User();
        deleteUser.setUsername(username);
        
        //delete the user
        try {
            deleteUser.removeUser();
            database.UpdateUIView.updateTableView(customersTable, database.UpdateUISQL.VIEW_CUSTOMERS_TABLE_SQL);            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
    }//GEN-LAST:event_confirmRemoveUserActionPerformed

    private void usernameSelectDropDownMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameSelectDropDownMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameSelectDropDownMenuActionPerformed

    private void confirmModifyUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmModifyUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmModifyUserMouseEntered

    private void confirmModifyUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmModifyUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmModifyUserMouseExited

    private void confirmModifyUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmModifyUserActionPerformed
        //get the input
        String username = modifyUsernameDropDownMenu.getSelectedItem().toString();
        String password = newPasswordInputField.getText();
        String role = modifyRoleDropDownMenu.getSelectedItem().toString();
        
        User modifyUser = new User(username, password, role);
        
        //update the user
        try {
            modifyUser.updateUser();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setVisible(true);
        }
        
        modifyUsernameDropDownMenu.setSelectedIndex(-1);
        newPasswordInputField.setText("");
        modifyRoleDropDownMenu.setSelectedIndex(-1);
    }//GEN-LAST:event_confirmModifyUserActionPerformed

    private void confirmPayInstallmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPayInstallmentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPayInstallmentMouseEntered

    private void confirmPayInstallmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPayInstallmentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPayInstallmentMouseExited

    private void confirmPayInstallmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPayInstallmentActionPerformed
        String idNumber = idNumberDropDownMenu.getSelectedItem().toString();
        String boardNumber = boardNumDropDownMenu.getSelectedItem().toString();
        BigDecimal installmentPaid = new BigDecimal(paymentsField.getText());
        
        Payments payInstallment = new Payments(idNumber, boardNumber, installmentPaid);
        
        //update the payments
        try {
            payInstallment.updatePayments();
            database.UpdateUIView.updateTableView(installmentsTable, database.UpdateUISQL.VIEW_INSTALLMENTS_TABLE_SQL);
            idNumberDropDownMenu.setSelectedIndex(-1);
            boardNumDropDownMenu.setSelectedIndex(-1);
            paymentsField.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idNumberDropDownMenu.setSelectedIndex(-1);
        boardNumDropDownMenu.setSelectedIndex(-1);
        paymentsField.setText("");
    }//GEN-LAST:event_confirmPayInstallmentActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> InstallmentPeriodDropDownMenu;
    private javax.swing.JPanel addNewMotorcycles;
    private javax.swing.JPanel addNewUserPanel;
    private javax.swing.JButton addToInventoryButton;
    private javax.swing.JButton addUsersButton;
    private javax.swing.JFormattedTextField bankAccountNumField;
    private javax.swing.JLabel bankAccountNumLabel;
    private javax.swing.JComboBox<String> boardNumDropDownMenu;
    private javax.swing.JTextField boardNumField;
    private javax.swing.JLabel boardNumLabel;
    private javax.swing.JComboBox<String> brandComboBox;
    private javax.swing.JComboBox<String> brandComboBoxInventory;
    private javax.swing.JComboBox<String> brandComboBoxInventory1;
    private javax.swing.JTextField brandInputField;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JLabel brandLabel1;
    private javax.swing.JLabel brandLabel2;
    private javax.swing.JLabel brandLabel3;
    private javax.swing.JButton confirmAddToInventoryButton;
    private javax.swing.JButton confirmAddUser;
    private javax.swing.JButton confirmModifyUser;
    private javax.swing.JButton confirmPayInstallment;
    private javax.swing.JButton confirmRemoveFromInventoryButton;
    private javax.swing.JButton confirmRemoveFromInventoryButton1;
    private javax.swing.JButton confirmRemoveUser;
    private javax.swing.JButton confirmSaleButton;
    private javax.swing.JLabel contactNumLabel;
    private javax.swing.JFormattedTextField contactNumberField;
    private javax.swing.JSeparator contentSepratorOne;
    private javax.swing.JTextField currentAddressField;
    private javax.swing.JLabel currentAddressLabel;
    private javax.swing.JLabel currentPriceLabel;
    private javax.swing.JLabel customerDetailsLabel;
    private javax.swing.JSeparator customerDetailsSeperator;
    private javax.swing.JButton customersButton;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JScrollPane customersScrollPane;
    private javax.swing.JTable customersTable;
    private javax.swing.JFormattedTextField downPaymentField;
    private javax.swing.JLabel downPaymentLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField idNumField;
    private javax.swing.JLabel idNumLabel;
    private javax.swing.JComboBox<String> idNumberDropDownMenu;
    private javax.swing.JCheckBox installmentCheckBox;
    private javax.swing.JLabel installmentLabel;
    private javax.swing.JLabel installmentPeriodLabel;
    private javax.swing.JScrollPane installmentsPane;
    private javax.swing.JPanel installmentsPanel;
    private javax.swing.JTable installmentsTable;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JPanel inventoryMenu;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JPanel inventoryPanelParent;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JScrollPane inventoryTablePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton makeSaleButton;
    private javax.swing.JPanel makeSalePane;
    private javax.swing.JScrollPane makeSalePanel;
    private javax.swing.JPanel menu;
    private javax.swing.JComboBox<String> modelComboBox;
    private javax.swing.JComboBox<String> modelComboBoxInventory;
    private javax.swing.JComboBox<String> modelComboBoxInventory1;
    private javax.swing.JTextField modelInputField;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JLabel modelLabel1;
    private javax.swing.JLabel modelLabel2;
    private javax.swing.JLabel modelLabel3;
    private javax.swing.JLabel modelLabel4;
    private javax.swing.JButton modifyInventoryButton;
    private javax.swing.JPanel modifyInventoryPanel;
    private javax.swing.JComboBox<String> modifyRoleDropDownMenu;
    private javax.swing.JButton modifyUserBUtton;
    private javax.swing.JComboBox<String> modifyUsernameDropDownMenu;
    private javax.swing.JPanel modifyUsersPanel;
    private javax.swing.JLabel monthsLabel;
    private javax.swing.JLabel motorcycleDetailsLabel;
    private javax.swing.JSeparator motorcycleDetailsSeparator;
    private javax.swing.JTextField newPasswordInputField;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JTextField passwordInputField;
    private javax.swing.JPanel payInstallmentsPanel;
    private javax.swing.JFormattedTextField paymentsField;
    private javax.swing.JTextField permanentAddressField;
    private javax.swing.JLabel permanentAddressLabel;
    private javax.swing.JFormattedTextField priceInputField;
    private javax.swing.JFormattedTextField priceInputField1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JFormattedTextField quantityInputField;
    private javax.swing.JFormattedTextField quantityInputField1;
    private javax.swing.JButton removeInventoryButton;
    private javax.swing.JPanel removeMotorcycle;
    private javax.swing.JLabel removeMotorcycleLabel;
    private javax.swing.JLabel removeMotorcycleLabel1;
    private javax.swing.JButton removeUserButton;
    private javax.swing.JLabel removeUserLabel;
    private javax.swing.JPanel removeUsersPanel;
    private javax.swing.JComboBox<String> roleSelectDropDownMenu;
    private javax.swing.JButton salesHistoryButton;
    private javax.swing.JScrollPane salesHistoryPane;
    private javax.swing.JTable salesHistoryTable;
    private javax.swing.JPanel userSettingsParentPanel;
    private javax.swing.JTextField usernameInputField;
    private javax.swing.JComboBox<String> usernameSelectDropDownMenu;
    private javax.swing.JScrollPane usersAccessHistoryPanel;
    private javax.swing.JTable usersAccessHistoryTable;
    private javax.swing.JPanel usersMenu;
    private javax.swing.JButton usersSettingsButton;
    private javax.swing.JPanel usersSettingsPanel;
    private javax.swing.JTable usersTable;
    private javax.swing.JScrollPane usersTablePane;
    private javax.swing.JButton viewInstallmentsButton;
    private javax.swing.JButton viewUsersAccess;
    // End of variables declaration//GEN-END:variables
}

