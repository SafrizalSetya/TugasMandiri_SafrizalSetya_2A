package Network;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import Model2.ResponseModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TM01 extends JFrame {
    private JPanel TM01;
    private JTextField txMessage;
    private JTextField txStatus;
    private JTextField txComment;
    private JButton btnSubmit;
    private JButton btnClose;
    private JButton btnJumKata;

    public TM01(JFrame frame) {
            setContentPane(TM01);
            setTitle("TM01_22090044_SafrizalSetyawb");
            setMaximumSize(new Dimension(450, 474));
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);

            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnSubmit) {
                        try {
                            URL url = new URL("https://harber.mimoapps.xyz/api/getaccess.php");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String inputLine;
                            StringBuffer response = new StringBuffer();
                            while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                            }
                            in.close();
                            JSONArray jsonArray = new JSONArray(response.toString());
                            ArrayList<ResponseModel> parsedList = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                ResponseModel responseModel = new ResponseModel();
                                JSONObject myJSONObject = jsonArray.getJSONObject(i);
                                responseModel.setMassage(myJSONObject.getString("message"));
                                responseModel.setStatus(myJSONObject.getString("status"));
                                responseModel.setComment(myJSONObject.getString("comment"));
                                parsedList.add(responseModel);
                            }
                            for (int index = 0; index < parsedList.size(); index++) {
                                txStatus.setText(parsedList.get(index).getStatus());
                                txMessage.setText(parsedList.get(index).getMassage());
                                txComment.setText(parsedList.get(index).getComment());

                                btnJumKata.setText(String.valueOf(parsedList.get(index).getMassage().length()));
                            }
                        } catch (IOException ex) {
                            System.out.println("Data Tidak Terbaca");
                        } catch (JSONException ex) {
                            System.out.println("Data Tidak Valid");
                        }
                    }
                }
            });

            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    frame.dispose();
                }
            });
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("test");
            TM01 tm01 = new TM01(frame);
            tm01.setVisible(true);
        }
    }

