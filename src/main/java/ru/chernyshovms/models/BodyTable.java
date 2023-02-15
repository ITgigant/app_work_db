package ru.chernyshovms.models;
import java.sql.Timestamp;

public class BodyTable {

    private Integer id;
    private Integer postTypeId;
    private Integer acceptedAnswerId;
    private Timestamp creationDate;
    private Integer score;
    private Integer viewCount;
    private String body;
    private Integer ownerUserId;
    private Integer lastEditorUserId;
    private String lastEditorDisplayName;
    private Timestamp lastEditDate;
    private Timestamp lastActivityDate;
    private String title;
    private String tags;
    private Integer answerCount;
    private Integer commentCount;
    private Integer favoriteCount;
    private Timestamp communityOwnedDate;
    private String contentLicense;
    private Integer parentId;
    private String ownerDisplayName;
    private Timestamp closedDate;


    public BodyTable(){

    }

    public BodyTable(Integer id, Integer postTypeId, Integer acceptedAnswerId, Timestamp creationDate,
                     Integer score, Integer viewCount, String body, Integer ownerUserId, Integer lastEditorUserId,
                     String lastEditorDisplayName, Timestamp lastEditDate, Timestamp lastActivityDate,
                     String title, String tags, Integer answerCount, Integer commentCount, Integer favoriteCount,
                     Timestamp communityOwnedDate, String contentLicense, Integer parentId, String ownerDisplayName,
                     Timestamp closedDate)
    {
        this.postTypeId = postTypeId;
        this.acceptedAnswerId = acceptedAnswerId;
        this.creationDate = creationDate;
        this.score = score;
        this.viewCount = viewCount;
        this.body = body;
        this.ownerUserId = ownerUserId;
        this.lastEditorUserId = lastEditorUserId;
        this.lastEditorDisplayName = lastEditorDisplayName;
        this.lastEditDate = lastEditDate;
        this.lastActivityDate = lastActivityDate;
        this.title = title;
        this.tags = tags;
        this.answerCount = answerCount;
        this.commentCount = commentCount;
        this.favoriteCount = favoriteCount;
        this.communityOwnedDate = communityOwnedDate;
        this.contentLicense = contentLicense;
        this.parentId = parentId;
        this.ownerDisplayName = ownerDisplayName;
        this.closedDate = closedDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setPostTypeId(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public void setLastEditorUserId(Integer lastEditorUserId) {
        this.lastEditorUserId = lastEditorUserId;
    }

    public Integer getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        this.lastEditorDisplayName = lastEditorDisplayName;
    }

    public String getLastEditorDisplayName() {
        return lastEditorDisplayName;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastActivityDate(Timestamp lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Timestamp getLastActivityDate() {
        return lastActivityDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setCommunityOwnedDate(Timestamp communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public Timestamp getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }

    public String getContentLicense() {
        return contentLicense;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setClosedDate(Timestamp closedDate) {
        this.closedDate = closedDate;
    }

    public Timestamp getClosedDate() {
        return closedDate;
    }
}