/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotelfinder.frames;


import thehotelfinder.databaseutil.Hotel;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import thehotelfinder.MyDate;
import thehotelfinder.TheHotelFinder;

/**
 *
 * @author divakar
 */
public class HotelCard extends javax.swing.JPanel {

    /**
     * Creates new form HotelCard
     */
    public HotelCard(Hotel hotel, int noRoomsUser, int noPeople, int nights, Date checkInDate, Date checkOutDate) {
        this.hotel = hotel;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noPeople = noPeople;
        this.nights = nights;
        initComponents();
        
        double rating = hotel.getAvgRating();
        int ratingWidth = (int)((rating/5)*165);
        System.out.println(rating + " " + ratingWidth);
        starsBgPanel.setBounds(0, 0, ratingWidth, 30);
        
        this.availableRoomsArr = TheHotelFinder.getDb().getMaxRooms(hotel.getName(), MyDate.toStringInit(checkInDate), MyDate.toStringInit(checkOutDate));
        
        singleSpinner.setModel(new javax.swing.SpinnerNumberModel(0,0,availableRoomsArr[0],1));
        doubleSpinner.setModel(new javax.swing.SpinnerNumberModel(0,0,availableRoomsArr[1],1));
        
        locationLabel.setText(hotel.getCity() + ", " + hotel.getState());
        hotelNameLabel.setText(hotel.getName());
        DecimalFormat df = new DecimalFormat("#.##");
        ratingValueLabel.setText("" + df.format(hotel.getAvgRating()) + "/5");
        reviewsLabel.setText("( " + hotel.getRatingArr().size() + " ratings)");
        singlePriceLabel.setText("\u20B9" + hotel.getCostArr()[0]);
        doublePriceLabel.setText("\u20B9" + hotel.getCostArr()[1]);
        
        singleAvailableLabel.setText("(" + availableRoomsArr[0] + " available)");
        doubleAvailableLabel.setText("(" + availableRoomsArr[1] + " available)");
        int nsingle = 0;
        int ndouble = 0;
        nsingle = noRoomsUser;
        ndouble = 0;
        singleSpinner.setValue(nsingle);
        doubleSpinner.setValue(ndouble);
        double total = ((nsingle * hotel.getCostArr()[0] + ndouble * hotel.getCostArr()[1])*nights);
        
        System.out.println("Total : " + total +" "+nights+" " +  " " +hotel.getCostArr()[1] + " " +hotel.getCostArr()[0] );
        priceValueLabel.setText("\u20B9" + total);
        waitListBtn.setVisible(false);
        if((availableRoomsArr[0]==0 && availableRoomsArr[1]==0 ) || 
           (noPeople>availableRoomsArr[0] && noPeople>(2*availableRoomsArr[1]))
           ){
            waitListBtn.setVisible(true);
            dealBtn.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        hotelNameLabel = new javax.swing.JLabel();
        ratingValueLabel = new javax.swing.JLabel();
        priceValueLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        reviewsLabel = new javax.swing.JLabel();
        dealBtn = new javax.swing.JButton();
        singleSpinner = new javax.swing.JSpinner();
        doubleSpinner = new javax.swing.JSpinner();
        singleRoomLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        doubleAvailableLabel = new javax.swing.JLabel();
        singleAvailableLabel = new javax.swing.JLabel();
        singlePriceLabel = new javax.swing.JLabel();
        doublePriceLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        waitListBtn = new javax.swing.JButton();
        ratingPanel = new javax.swing.JPanel();
        stars = new javax.swing.JLabel();
        starsBgPanel = new javax.swing.JPanel();
        hotelImgLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 1, new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(850, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hotelNameLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        hotelNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        hotelNameLabel.setText("The Taj Hotel");
        hotelNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hotelNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotelNameLabelMouseClicked(evt);
            }
        });
        add(hotelNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        ratingValueLabel.setBackground(new java.awt.Color(255, 0, 51));
        ratingValueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ratingValueLabel.setForeground(new java.awt.Color(204, 204, 204));
        ratingValueLabel.setText("0/5");
        add(ratingValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));

        priceValueLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        priceValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceValueLabel.setText("VALUE");
        add(priceValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(204, 204, 204));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel.setText("Total Cost:");
        add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, -1));

        locationLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 16)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(204, 204, 204));
        locationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        locationLabel.setText("Location");
        add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 235, 39));

        reviewsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reviewsLabel.setForeground(new java.awt.Color(204, 204, 204));
        reviewsLabel.setText("(65 Reviews)");
        add(reviewsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        dealBtn.setBackground(new java.awt.Color(51, 51, 51));
        dealBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dealBtn.setForeground(new java.awt.Color(51, 51, 51));
        dealBtn.setText("View Deal");
        dealBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealBtnActionPerformed(evt);
            }
        });
        add(dealBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        singleSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        singleSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                roomsSpinnerStateChanged(evt);
            }
        });
        add(singleSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        doubleSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        doubleSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                roomsSpinnerStateChanged(evt);
            }
        });
        add(doubleSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, 20));

        singleRoomLabel.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        singleRoomLabel.setForeground(new java.awt.Color(204, 204, 204));
        singleRoomLabel.setText("Single Rooms");
        add(singleRoomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 40));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Double rooms");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 40));

        doubleAvailableLabel.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        doubleAvailableLabel.setForeground(new java.awt.Color(204, 204, 204));
        doubleAvailableLabel.setText("(X available)");
        add(doubleAvailableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, 40));

        singleAvailableLabel.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        singleAvailableLabel.setForeground(new java.awt.Color(204, 204, 204));
        singleAvailableLabel.setText("(X available)");
        add(singleAvailableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 40));

        singlePriceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        singlePriceLabel.setForeground(new java.awt.Color(204, 204, 204));
        singlePriceLabel.setText("Rs XXXX");
        add(singlePriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        doublePriceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        doublePriceLabel.setForeground(new java.awt.Color(204, 204, 204));
        doublePriceLabel.setText("Rs XXXX");
        add(doublePriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>Price per room <br>per night</html>");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        waitListBtn.setText("Enroll in waiting list");
        waitListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitListBtnActionPerformed(evt);
            }
        });
        add(waitListBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, 30));

        ratingPanel.setBackground(new java.awt.Color(204, 204, 204));
        ratingPanel.setLayout(null);

        stars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thehotelfinder/imgs/stars_bluebg.png"))); // NOI18N
        ratingPanel.add(stars);
        stars.setBounds(0, 0, 165, 31);

        starsBgPanel.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout starsBgPanelLayout = new javax.swing.GroupLayout(starsBgPanel);
        starsBgPanel.setLayout(starsBgPanelLayout);
        starsBgPanelLayout.setHorizontalGroup(
            starsBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        starsBgPanelLayout.setVerticalGroup(
            starsBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        ratingPanel.add(starsBgPanel);
        starsBgPanel.setBounds(0, 0, 0, 30);

        add(ratingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 100, 165, 30));

        hotelImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thehotelfinder/imgs/bluebg.jpg"))); // NOI18N
        add(hotelImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hotelNameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelNameLabelMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelFrame(hotel).setVisible(true);
            }
        });
        
    }//GEN-LAST:event_hotelNameLabelMouseClicked

    private void dealBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealBtnActionPerformed
        // TODO add your handling code here:
        int nsingle = (int)singleSpinner.getValue();
        int ndouble = (int)doubleSpinner.getValue();
        int noRoomsUserArr[] = new int[2];
        noRoomsUserArr[0] = nsingle;
        noRoomsUserArr[1] = ndouble;
        if(nsingle==0 && ndouble==0){
            JOptionPane.showMessageDialog(this, "Please select atleast one room.");
            return;
        }
        if(availableRoomsArr[0]>=nsingle && availableRoomsArr[1]>=ndouble){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new BookingFrame(hotel, noRoomsUserArr, noPeople, nights, checkInDate, checkOutDate).setVisible(true);
                }
            });
        }else{
            JOptionPane.showMessageDialog(this,"Rooms are not available.");
        }
        
    }//GEN-LAST:event_dealBtnActionPerformed

    private void roomsSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_roomsSpinnerStateChanged
        // TODO add your handling code here:
        int nsingle = (int)singleSpinner.getValue();
        int ndouble = (int)doubleSpinner.getValue();
        
        if((nsingle==0 && ndouble==0)){
            jOptionPane1.showMessageDialog(this,"Please select atleast one room");
            return;
        }
        double total = (nsingle * hotel.getCostArr()[0] + ndouble * hotel.getCostArr()[1])*nights;
        System.out.println("totalPrice: \n" + total);
        priceValueLabel.setText("\u20B9" + total);
    }//GEN-LAST:event_roomsSpinnerStateChanged

    private void waitListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitListBtnActionPerformed
        // TODO add your handling code here:
        TheHotelFinder.getDb().addToWaitingList(TheHotelFinder.getCurUser().getUsername(), hotel.getName(), noPeople,
                                           MyDate.toStringInit(checkInDate),  MyDate.toStringInit(checkOutDate));
        JOptionPane.showMessageDialog(this, "Added to waiting list");
        
    }//GEN-LAST:event_waitListBtnActionPerformed

    private Hotel hotel;
    private int noPeople;
    private int nights;
    private Date checkInDate;
    private Date checkOutDate;
    private int availableRoomsArr[];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dealBtn;
    private javax.swing.JLabel doubleAvailableLabel;
    private javax.swing.JLabel doublePriceLabel;
    private javax.swing.JSpinner doubleSpinner;
    private javax.swing.JLabel hotelImgLabel;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceValueLabel;
    private javax.swing.JPanel ratingPanel;
    private javax.swing.JLabel ratingValueLabel;
    private javax.swing.JLabel reviewsLabel;
    private javax.swing.JLabel singleAvailableLabel;
    private javax.swing.JLabel singlePriceLabel;
    private javax.swing.JLabel singleRoomLabel;
    private javax.swing.JSpinner singleSpinner;
    private javax.swing.JLabel stars;
    private javax.swing.JPanel starsBgPanel;
    private javax.swing.JButton waitListBtn;
    // End of variables declaration//GEN-END:variables
}
