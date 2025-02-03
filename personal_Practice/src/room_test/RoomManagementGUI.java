package room_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RoomManagementGUI extends JFrame {
    private RoomDAO roomDAO = new RoomDAOImple();
    private JTextArea roomDisplayArea;

    public RoomManagementGUI() {
        setTitle("Hotel Room Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        roomDisplayArea = new JTextArea();
        roomDisplayArea.setEditable(false);
        add(new JScrollPane(roomDisplayArea), BorderLayout.CENTER);

        JButton viewButton = new JButton("View All Rooms");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllRooms();
            }
        });

        add(viewButton, BorderLayout.SOUTH);
    }

    private void viewAllRooms() {
        roomDisplayArea.setText("");
        List<RoomVO> rooms = roomDAO.selectAllRooms();
        for (RoomVO room : rooms) {
            roomDisplayArea.append("Room ID: " + room.getRoomId() + ", Type: " + room.getRoomType() + 
                                   ", Price: " + room.getRoomPrice() + 
                                   ", Available: " + room.isRoomAvailability() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoomManagementGUI gui = new RoomManagementGUI();
            gui.setVisible(true);
        });
    }
}
