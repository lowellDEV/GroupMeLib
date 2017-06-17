
import org.json.JSONObject;

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
    
    /**
     * Create a bot object
     * @param name the name of the bot
     * @param botID the id given to the bot by GroupMe
     * @param group the group the bot resides in
     */
    public GroupMeBot(String name,String botID,String group){
        this.name = name;
        this.botID = botID;
        this.groupID = group;
    }
    /**
     *  Create a bot object
     * @param name the name of the bot
     * @param botID the id given to the bot by GroupMe
     * @param group the group the bot resides in@param name
     * @param avatar the url of the bot picture
     * @param callback the url to send messages to
     * @param DMNotification Boolean to represent if notifications are accepted
     */
    public GroupMeBot(String name,String botID,String group,String avatar,String callback, Boolean DMNotification){
        this(name,botID,group);
        this.avatarURL = avatar;
        this.callBackURL = callback;
        this.DMNotification =DMNotification;
    }/**
     * Not implemented
     * @param token the creator's token
     * @param botName the name of the bot
     * @param GroupID the id of the group to add the bot to
     * @return 
     */
    public static GroupMeBot createBot(String token, String botName, String GroupID){
        
        return new GroupMeBot("placehold","placehold","placehold"); //should return a newly created bot
    }
    public boolean sendMessage(String text){
        return GroupMe.sendMessage(new Message(text),this.botID,true);
    }
    public boolean sendMessage(String text,User[] users){
        Message message = new Message(text);
        JSONObject info = new JSONObject(); 
        int count =0;
        String loci[]= new String[users.length];
        String userids[]= new String[users.length];
        for(int i=0;i<users.length;i++){
            userids[i] = users[i].getUserID();
            loci[i] = "["+count+","+(users[i].getName().length()+1)+"]";
            text = "@"+users[i]+" "+text;
            count+= ((users[i].getName().length()+1)+2);
        }
        info.put("user_ids", JSONArray(userids));
        info.put("loci", JSONArray(loci));
        Attachment attachment = new Attachment(AttachmentType.MENTION,info);
        message.setText(text);
        message.addAttachment(attachment);
        return GroupMe.sendMessage(message,this.botID,true);
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

    private boolean JSONArray(String[] userids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
