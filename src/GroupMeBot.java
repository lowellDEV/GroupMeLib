/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rider X2
 */
public class GroupMeBot {
    private String name;
    private String botID;
    private String groupID;
    private String avatarURL;
    private String callBackURL;
    private Boolean DMNotification;
    
    
    public GroupMeBot(String name,String botID,String group){
        this.name = name;
        this.botID = botID;
        this.groupID = group;
    }
    public GroupMeBot(String name,String botID,String group,String avatar,String callback, Boolean DMNotification){
        this(name,botID,group);
        this.avatarURL = avatar;
        this.callBackURL = callback;
        this.DMNotification =DMNotification;
    }
    public static GroupMeBot createBot(String token, String botName, String GroupID){
        
        return new GroupMeBot("placehold","placehold","placehold"); //should return a newly created bot
    }
    public boolean sendMessage(String text){
        return GroupMe.sendMessage(text,this.botID,true);
    }
    public boolean sendMessage(String text,User[] users){
        return GroupMe.sendMessage(text,this.botID,users,true);
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the avatarURL
     */
    public String getAvatarURL() {
        return avatarURL;
    }

    /**
     * @param avatarURL the avatarURL to set
     */
    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    /**
     * @return the callBackURL
     */
    public String getCallBackURL() {
        return callBackURL;
    }

    /**
     * @param callBackURL the callBackURL to set
     */
    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    /**
     * @return the DMNotification
     */
    public Boolean getDMNotification() {
        return DMNotification;
    }

    /**
     * @param DMNotification the DMNotification to set
     */
    public void setDMNotification(Boolean DMNotification) {
        this.DMNotification = DMNotification;
    }
    
}
