package com.company.Client1.View.Panel;

import com.company.Client1.Message.ResponseMessage;
import com.company.Client1.model.ClientSocket;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.*;
import java.net.Socket;


/**
 *
 * @author ti
 */
public class ChatPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ChatPanel(ClientSocket toUser, Socket currentSocket, String currentUser) {
        this.toUser = toUser;
        this.currentSocket = currentSocket;
        this.currentUser = currentUser;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        sendBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        sendBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imageTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        sendBtn.setText("File");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        sendBtn1.setText("Send");
        sendBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(sendBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(sendBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)))
                                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        imageTxt.setText("Image");

        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Online");

        usernameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameTxt.setText(toUser.getUsername());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(671, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(imageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Gson gson = new Gson();
        //Step 1 : Get File
        File fileToSend;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Choose a file to send");

        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            fileToSend = jFileChooser.getSelectedFile();

            //Step 2 : Initialize Response Message
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setType("File");
            responseMessage.setToUser(toUser);
            responseMessage.setFromUser(new ClientSocket(currentSocket.getLocalPort(), currentUser));

            String msgResponse = gson.toJson(responseMessage);

            //Step 3 : Send msgResponse
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));
                bw.write(msgResponse);
                bw.newLine();
                bw.flush();

                //Step 4 : Read File
                FileInputStream fis = new FileInputStream(fileToSend.getAbsoluteFile());
                String fileName = fileToSend.getName();

                //Convert to byte[]
                //Name File
                byte[] fileNameBytes = fileName.getBytes();

                //Content File
                byte[] fileContentBytes = new byte[(int)fileToSend.length()];
                fis.read(fileContentBytes);

                DataOutputStream dos = new DataOutputStream(currentSocket.getOutputStream());

                //Step 5 : Send File
                //Send fileName
                dos.writeInt(fileNameBytes.length);
                dos.write(fileNameBytes);

                //Send file Content
                dos.writeInt(fileContentBytes.length);
                dos.write(fileContentBytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void sendBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            Gson gson = new Gson();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setType("Chat");
            responseMessage.setToUser(toUser);
            responseMessage.setFromUser(new ClientSocket(currentSocket.getLocalPort(),  currentUser));
            String message = textArea.getText();
            responseMessage.setMessage(message);

            String msgResponse = gson.toJson(responseMessage);
            bw.write(msgResponse);
            bw.newLine();
            bw.flush();

            System.out.println("-----------------------------------------------");
            System.out.println("Current User : " + currentUser);
            System.out.println("Send : ");
            System.out.println(msgResponse);
            System.out.println("-----------------------------------------------");

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Document doc = jTextPane1.getDocument();
                    try {
                        textArea.setText("");
                        String username = "Me\n";
                        String newMessage = message + "\n";
                        doc.insertString(doc.getLength(), username, null);
                        doc.insertString(doc.getLength(), newMessage, null);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientSocket getToUser() {
        return toUser;
    }

    public void setMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Document doc = jTextPane1.getDocument();
                String username = toUser.getUsername() + "\n";
                String newMessage = message + "\n";
                try {
                    doc.insertString(doc.getLength(), username, null);
                    doc.insertString(doc.getLength(), newMessage, null);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setFile(){
        //Find file Name
        try {
            //Get FileNameLength
            System.out.println("Before");
            DataInputStream dis = new DataInputStream(currentSocket.getInputStream());
            int fileNameLength = dis.readInt();
            System.out.println("File Name Length : " + fileNameLength);

            byte[] fileNameBytes = new byte[fileNameLength];
            dis.readFully(fileNameBytes, 0, fileNameLength);

            String fileName = new String(fileNameBytes);
            System.out.println("FileName : " + fileName);
            //        Show dialog
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to receive file : " + fileName + " from " + toUser.getUsername(),
                    "Authenticate",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION){
                //Get content Length File
                int fileContentLength = dis.readInt();
                byte[] fileContentBytes = new byte[fileContentLength];
                dis.readFully(fileContentBytes, 0, fileContentLength);

                //Write file
                File fileToDownload = new File(fileName);
                FileOutputStream fos = new FileOutputStream(fileToDownload);
                fos.write(fileContentBytes);
                fos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify
    private javax.swing.JLabel imageTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton sendBtn1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel usernameTxt;

    ClientSocket toUser;
    Socket currentSocket;
    String currentUser;


    // End of variables declaration
}