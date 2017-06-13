/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rider X2
 */
public class GroupMe {
    private final String baseURL ="https://api.groupme.com/v3";
    private String token;
    private String groupID;
    private String baseGUID;
    public static boolean sendMessage(String text, String userID,Boolean isBot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static boolean sendMessage(String text, String userID,User[] users, Boolean isBot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean sendMessage(String text,User[] users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean sendMessage(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static Message[] getMessages(String tokenID,String groupID){
        Message[] messages = new Message[20];
        return messages;
    }
    public Message[] getMessages(String groupID){
        Message[] messages = new Message[20];
        return messages;
    }
    public Message[] getMessages(){
        Message[] messages = new Message[20];
        return messages;
    }
    public boolean update(String attribute,int choice){
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
