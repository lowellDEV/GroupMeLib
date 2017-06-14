/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rider X2
 */
import org.json.*;

public class GroupMe {

    public static final String baseURL = "https://api.groupme.com/v3";
    private String token;
    private String groupID;
    private String baseGUID;

    public static boolean sendMessage(Message msg, String token, Boolean isBot) {
        JSONObject json = new JSONObject();
        String url;
        if (isBot) {
            url = baseURL + "/post";
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

    public static boolean sendMessage(Message msg, String token, String groupID, Boolean isBot) {
        String url = baseURL + "/groups/" + groupID + "/messages";
        JSONObject message = new JSONObject();
        message.put("souce_id", msg.getSource_guid());
        message.put("text", msg.getText());
        String attachString = "";
        for (Attachment attachment : msg.getAttachments()) {
            attachString += attachment.toString();
        }
        message.put("attachments", '[' + attachString + ']');
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

    public boolean sendMessage(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Message[] getMessages(String tokenID, String groupID) {
        Message[] messages = new Message[20];
        return messages;
    }

    public Message[] getMessages(String groupID) {
        Message[] messages = new Message[20];
        return messages;
    }
    /**
     * To be implemented
     * @return 
     */
    public Message[] getMessages() {
        Message[] messages = new Message[20];
        return messages;
    }

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
