package uz.pdp.ibaydullayev_ziyodulla_exam.position;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PositionDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Position> getAllPosition() {
        String sql = "select * from position";
        return jdbcTemplate.query(sql, (resultSet, row) ->
                Position.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build()
        );
    }

    public void addNewPosition(Position position) {
        String sql = "insert into position (name, description) values ('" + position.getName() + "','" + position.getDescription() + "')";
        jdbcTemplate.update(sql);
    }

    public void editPosition(Position position){
        String sql = "update position set name='"+position.getName()+"', description='"+position.getDescription()
                +"' where id ="+position.getId();
        jdbcTemplate.update(sql);
    }

    public void deletePosition(Integer id){
        String sql="delete from position where id ="+id;
        jdbcTemplate.update(sql);
    }

    public Position getPositionById(Integer id){
        String sql="select * from position where id = "+id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Position.class));
    }
}
