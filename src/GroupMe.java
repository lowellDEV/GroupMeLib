/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rider X2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class GroupMe {

    public static final String baseURL = "https://api.groupme.com/v3";
    private String token;
    private String groupID;
    private String baseGUID;
    /**
     * 
     * @param token the user access token
     * @param groupID the id of the default group
     * @param baseGUID A custom string to mark mod the guid 
     */
    public GroupMe(String token, String groupID,String baseGUID){
        
    }
    /**
     * Sends a message to a given group via Groupme api
     * @param msg A message object
     * @param token This should be the botID
     * @param isBot is the sender a bot? (wrong method if false)
     * @return Boolean indicating Success/Fail 
     */
    public static boolean sendMessage(Message msg, String token, Boolean isBot) {
        JSONObject json = new JSONObject();
        String url;
        if (isBot) {
            url = baseURL + "/bots/post";
            json = new JSONObject()
                    .put("bot_id", token)
                    .put("text", msg.getText())
                    .put("attachments", msg.getAttachments());
        } else {
            System.out.println("Incorrect Method for human/ HTTP ERROR");
            return false;
        }
        if (HTTP.SendPOST(url, new JSONObject(), json.toString()) != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Sends a message to a given group via Groupme api
     * @param msg A message object
     * @param token The access token given to users
     * @param groupID The group number 
     * @param isBot is the sender a bot?
     * @return Boolean indicating Success/Fail 
     */
    public static boolean sendMessage(Message msg, String token, String groupID, Boolean isBot) {
        String url = baseURL + "/groups/" + groupID + "/messages";
        JSONObject message = new JSONObject();
        message.put("text", msg.getText());
        
        message.put("attachments", msg.getAttachments());
        message.put("source_guid", msg.getSource_guid());
        JSONObject json = new JSONObject();
        json.put("message", message);
        if (isBot) {
            return sendMessage(msg, token, isBot);
        } else if (HTTP.SendPOST(url, new JSONObject().put("token", token), json.toString()) != null) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * Sends a message to the objects set group via Groupme api
     * @param text the text to send
     * @return 
     */
    public boolean sendMessage(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Gets the last 20 messages of a given group
     * @param tokenID The access token given to users
     * @param groupID The group number 
     * @return 
     */
    public static Message[] getMessages(String tokenID, String groupID) {
        Message[] messages =new Message[0];
        String url = baseURL + "/groups/" + groupID + "/messages";
        InputStream response =HTTP.sendGET(url, new JSONObject().put("token", tokenID));
        StringBuilder responseBld = new StringBuilder();
        BufferedReader read = new BufferedReader(new InputStreamReader(response));
        if (response == null){
            messages = new Message[0];
            return messages;
        }
        else{
            try {
                String jsonStr;
                while((jsonStr=read.readLine())!=null){
                    responseBld.append(jsonStr);
                }
                JSONObject json = new JSONObject(responseBld.toString()).getJSONObject("response");
                //System.out.println(json.toString());
                JSONArray messageArray = json.getJSONArray("messages");
                int count =messageArray.length();
                messages = new Message[count];
                int i =0;
                for (Object message:messageArray){
                    JSONObject messageI =(JSONObject)message;
                    messages[i] = new Message("");
                    messages[i].setCreated_at(messageI.getInt("created_at")+"");
                    String[] favorited= new String[messageI.getJSONArray("favorited_by").length()];
                    Iterator<?> favObj = messageI.getJSONArray("favorited_by").iterator();
                    int z =0;
                    while(favObj.hasNext()){
                        favorited[z] =(String) favObj.next();
                        z++;
                    }
                    messages[i].setFavorited(favorited);
                    messages[i].setGroupID(groupID);
                    messages[i].setId(messageI.getString("id"));
                    messages[i].setSource_guid(messageI.getString("source_guid"));
                    messages[i].setSystem(messageI.getBoolean("system"));
                    messages[i].setText(messageI.getString("text"));
                    User tempUser =new User(messageI.getString("name"),
                    messageI.getString("user_id"));
                    messages[i].setUser(tempUser);
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(GroupMe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return messages;
    }
    /**
     *  Gets the last 20 messages of a given group
     * @param groupID The group number 
     * @return 
     */
    public Message[] getMessages(String groupID) {
        Message[] messages = new Message[20];
        return messages;
    }
    /**
     * Gets the last 20 messages of the set group
     * @return 
     */
    public Message[] getMessages() {
        Message[] messages = new Message[20];
        return messages;
    }
    /**
     * Not implemented yet
     * @param attribute
     * @param choice
     * @return 
     */
    public boolean update(String attribute, int choice) {
        return false;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the groupID
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupID the groupID to set
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    /**
     * @return the baseGUID
     */
    public String getBaseGUID() {
        return baseGUID;
    }

    /**
     * @param baseGUID the baseGUID to set
     */
    public void setBaseGUID(String baseGUID) {
        this.baseGUID = baseGUID;
    }

}
