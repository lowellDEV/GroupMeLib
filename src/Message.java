/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rider X2
 */
public class Message {
    private String id;
    private String source_guid;
    private String created_at;
    private User user;
    private String groupID;
    private String text;
    private Boolean system;
    private String[] favorited;
    private Attachment[] attachments;
    
    public Message(){
        
    }
}
