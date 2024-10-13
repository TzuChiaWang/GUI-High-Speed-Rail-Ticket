package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketBookingController extends JFrame {
    private JComboBox<String> startStationComboBox;
    private JComboBox<String> endStationComboBox;
    private JRadioButton singleTicketRadioButton;
    private JRadioButton returnTicketRadioButton;
    private JRadioButton oneTicketRadioButton;
    private JRadioButton twoTicketsRadioButton;
    private JRadioButton threeTicketsRadioButton;
    private JRadioButton fourticketsRadioButton;
    private JButton bookButton;

    public TicketBookingController() {
        setTitle("高鐵訂票系統");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 6));

        // 起訖站
        JLabel startStationLabel = new JLabel("出發站:");
        startStationComboBox = new JComboBox<>(new String[]{"南港", "台北", "板橋", "桃園", "新竹", "苗栗", "台中", "彰化", "雲林", "嘉義", "台南", "左營"});
        JLabel endStationLabel = new JLabel("到達站:");
        endStationComboBox = new JComboBox<>(new String[]{"南港", "台北", "板橋", "桃園", "新竹", "苗栗", "台中", "彰化", "雲林", "嘉義", "台南", "左營"});

        // 票種
        JLabel ticketTypeLabel = new JLabel("票種:");
        singleTicketRadioButton = new JRadioButton("單程票");
        returnTicketRadioButton = new JRadioButton("來回票");
        ButtonGroup ticketTypeGroup = new ButtonGroup();
        ticketTypeGroup.add(singleTicketRadioButton);
        ticketTypeGroup.add(returnTicketRadioButton);

        // 張數
        JLabel ticketCountLabel = new JLabel("張數:");
        oneTicketRadioButton = new JRadioButton("1張");
        twoTicketsRadioButton = new JRadioButton("2張");
        threeTicketsRadioButton = new JRadioButton("3張");
        fourticketsRadioButton = new JRadioButton("4張");
        ButtonGroup ticketCountGroup = new ButtonGroup();
        ticketCountGroup.add(oneTicketRadioButton);
        ticketCountGroup.add(twoTicketsRadioButton);
        ticketCountGroup.add(threeTicketsRadioButton);
        ticketCountGroup.add(fourticketsRadioButton);

        // 訂票按鈕
        bookButton = new JButton("訂票");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startStation = (String) startStationComboBox.getSelectedItem();
                String endStation = (String) endStationComboBox.getSelectedItem();
                String ticketType = singleTicketRadioButton.isSelected() ? "單程票" : 
                                    returnTicketRadioButton.isSelected() ? "來回票" : "";
                String ticketCount = oneTicketRadioButton.isSelected() ? "1張" : 
                                    twoTicketsRadioButton.isSelected() ? "2張" : 
                                    threeTicketsRadioButton.isSelected() ? "3張" : 
                                    fourticketsRadioButton.isSelected() ? "4張" : "";

                if(ticketType.equals("") || ticketCount.equals("")) {
                    JOptionPane.showMessageDialog(null, "請選擇票種及張數!");
                    return;
                }

                JOptionPane.showMessageDialog(null, "您要訂的是從 " + startStation + " 到 " + endStation + " 的 " + ticketType + "，共 " + ticketCount + "。");
                
                int option = JOptionPane.showConfirmDialog(null, "確定要訂票嗎?", "訂票確認", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "訂票成功!");
                }

                int option2 = JOptionPane.showConfirmDialog(null, "是否要繼續訂票?", "繼續訂票", JOptionPane.YES_NO_OPTION);
                if (option2 == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        // 加入元件到介面
        add(startStationLabel);
        add(startStationComboBox);
        add(endStationLabel);
        add(endStationComboBox);
        add(ticketTypeLabel);
        add(singleTicketRadioButton);
        add(new JLabel()); // 空白佔位
        add(returnTicketRadioButton);
        add(ticketCountLabel);
        add(oneTicketRadioButton);
        add(new JLabel()); // 空白佔位
        add(twoTicketsRadioButton);
        add(new JLabel()); // 空白佔位
        add(threeTicketsRadioButton);
        add(new JLabel()); // 空白佔位
        add(fourticketsRadioButton);
        add(new JLabel()); // 空白佔位
        add(bookButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicketBookingController().setVisible(true);
            }
        });
    }
}

