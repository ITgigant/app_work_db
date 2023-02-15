package ru.chernyshovms.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.chernyshovms.models.BodyTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BodyTableMapper implements RowMapper<BodyTable> {

    @Override
    public BodyTable mapRow(ResultSet resultSet, int i) throws SQLException {
        BodyTable bodyTable = new BodyTable();
        bodyTable.setId(resultSet.getInt("Id"));
        bodyTable.setPostTypeId(resultSet.getInt("PostTypeId"));
        bodyTable.setAcceptedAnswerId(resultSet.getInt("AcceptedAnswerId"));
        bodyTable.setCreationDate(resultSet.getTimestamp("CreationDate"));
        bodyTable.setScore(resultSet.getInt("Score"));
        bodyTable.setViewCount(resultSet.getInt("ViewCount"));
        bodyTable.setBody(resultSet.getString("Body"));
        bodyTable.setOwnerUserId(resultSet.getInt("OwnerUserId"));
        bodyTable.setLastEditorUserId(resultSet.getInt("LastEditorUserId"));
        bodyTable.setLastEditorDisplayName(resultSet.getString("LastEditorDisplayName"));
        bodyTable.setLastEditDate(resultSet.getTimestamp("LastEditDate"));
        bodyTable.setLastActivityDate(resultSet.getTimestamp("LastActivityDate"));
        bodyTable.setTitle(resultSet.getString("Title"));
        bodyTable.setTags(resultSet.getString("Tags"));
        bodyTable.setAnswerCount(resultSet.getInt("AnswerCount"));
        bodyTable.setCommentCount(resultSet.getInt("CommentCount"));
        bodyTable.setFavoriteCount(resultSet.getInt("FavoriteCount"));
        bodyTable.setCommunityOwnedDate(resultSet.getTimestamp("CommunityOwnedDate"));
        bodyTable.setContentLicense(resultSet.getString("ContentLicense"));
        bodyTable.setParentId(resultSet.getInt("ParentId"));
        bodyTable.setOwnerDisplayName(resultSet.getString("OwnerDisplayName"));
        bodyTable.setClosedDate(resultSet.getTimestamp("ClosedDate"));
        return bodyTable;
    }
}
