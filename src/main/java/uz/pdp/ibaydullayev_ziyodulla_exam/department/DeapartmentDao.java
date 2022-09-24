package uz.pdp.ibaydullayev_ziyodulla_exam.department;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeapartmentDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Department> getAllDepartment() {
        String sql = "select * from department";
        return jdbcTemplate.query(sql, (resultSet, row) ->
                Department.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build()
        );
    }

    public void addNewDepartment(Department department) {
        String sql = "insert into department (name, description) values ('" + department.getName() + "','" + department.getDescription() + "')";
        jdbcTemplate.update(sql);
    }

    public void editDepartment(Department department){
        String sql = "update department set name='"+department.getName()+"', description='"+department.getDescription()
                +"' where id ="+department.getId();
        jdbcTemplate.update(sql);
    }

    public void deleteDepartment(Integer id){
        String sql="delete from department where id ="+id;
        jdbcTemplate.update(sql);
    }

    public Department getDepartmentById(Integer id){
        String sql="select * from department where id = "+id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Department.class));
    }
}
