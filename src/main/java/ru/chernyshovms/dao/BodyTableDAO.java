package ru.chernyshovms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.chernyshovms.models.BodyTable;

import java.util.List;

@Component
public class BodyTableDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BodyTableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<BodyTable> index(Pageable pageable) {
        String rowCountSql = "SELECT count(*) from user_request";
        int count = jdbcTemplate.queryForObject(
                rowCountSql, Integer.class);
        String querySql = "select * from user_request " +
                "LIMIT " + pageable.getPageSize() + " " +
                "OFFSET " + pageable.getOffset();
        List<BodyTable> page = jdbcTemplate.query(querySql, new BodyTableMapper());
        return new PageImpl<>(page, pageable, count);
    }

    public BodyTable show(int id) {
        return jdbcTemplate.query("SELECT * FROM user_request WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(BodyTable.class)).stream().findAny().orElse(null); // можно указать обьект с ошибкой

    }

    public Page<BodyTable> search(String keyword, Pageable pageable) {
        String rowCountSql = "SELECT count(*) FROM user_request, " +
                "to_tsvector(user_request.title || user_request.body) document," +
                "  to_tsquery('" +  keyword  + "') query " +
                "WHERE query @@ document";
        int count = jdbcTemplate.queryForObject(
                rowCountSql, Integer.class);

        String querySql = "SELECT * FROM user_request, " +
                "to_tsvector(user_request.title || user_request.body) document," +
                "  to_tsquery('" +  keyword  + "') query " +
                "WHERE query @@ document " +
                "LIMIT " + pageable.getPageSize() + " " +
                "OFFSET " + pageable.getOffset();

        List<BodyTable> page = jdbcTemplate.query(querySql, new BodyTableMapper());
        return new PageImpl<>(page, pageable, count);
    }

    public void save(BodyTable bodyTable){
        jdbcTemplate.update("INSERT INTO  user_request(id, posttypeid, acceptedanswerid, creationdate, score, viewcount," +
                                " body, owneruserid, lasteditoruserid, lasteditordisplayname, lasteditdate, lastactivitydate, title," +
                                " tags, answercount, commentcount, favoritecount, communityowneddate, contentlicense, parentid," +
                                " ownerdisplayname, closeddate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                bodyTable.getId(), bodyTable.getPostTypeId(), bodyTable.getAcceptedAnswerId(), bodyTable.getCreationDate(),
                bodyTable.getScore(), bodyTable.getViewCount(), bodyTable.getBody(), bodyTable.getOwnerUserId(),
                bodyTable.getLastEditorUserId(), bodyTable.getLastEditorDisplayName(), bodyTable.getLastEditDate(),
                bodyTable.getLastActivityDate(), bodyTable.getTitle(), bodyTable.getTags(), bodyTable.getAnswerCount(),
                bodyTable.getCommentCount(), bodyTable.getFavoriteCount(), bodyTable.getCommunityOwnedDate(),
                bodyTable.getContentLicense(), bodyTable.getParentId(), bodyTable.getOwnerDisplayName(), bodyTable.getClosedDate());
    }

    public void update (int id, BodyTable updatedBodyTable){
        jdbcTemplate.update("UPDATE user_request SET posttypeid=?, acceptedanswerid=?, creationdate=?, score=?, viewcount=?," +
                        " body=?, owneruserid=?, lasteditoruserid=?, lasteditordisplayname=?, lasteditdate=?, lastactivitydate=?," +
                        " title=?, tags=?, answercount=?, commentcount=?, favoritecount=?, communityowneddate=?, contentlicense=?," +
                        " parentid=?, ownerdisplayname=?, closeddate=?  WHERE id=?",
                updatedBodyTable.getPostTypeId(), updatedBodyTable.getAcceptedAnswerId(),
                updatedBodyTable.getCreationDate(), updatedBodyTable.getScore(), updatedBodyTable.getViewCount(),
                updatedBodyTable.getBody(), updatedBodyTable.getOwnerUserId(), updatedBodyTable.getLastEditorUserId(),
                updatedBodyTable.getLastEditorDisplayName(), updatedBodyTable.getLastEditDate(), updatedBodyTable.getLastActivityDate(),
                updatedBodyTable.getTitle(), updatedBodyTable.getTags(), updatedBodyTable.getAnswerCount(),
                updatedBodyTable.getCommentCount(), updatedBodyTable.getFavoriteCount(), updatedBodyTable.getCommunityOwnedDate(),
                updatedBodyTable.getContentLicense(), updatedBodyTable.getParentId(), updatedBodyTable.getOwnerDisplayName(),
                updatedBodyTable.getClosedDate(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM user_request where id=?", id);

    }
}
