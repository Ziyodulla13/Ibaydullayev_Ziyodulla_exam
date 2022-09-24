package uz.pdp.ibaydullayev_ziyodulla_exam.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.ibaydullayev_ziyodulla_exam.employee.Employee;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployee() {
        String sql = "select e.*, p.name, d.name from employee e join position p on p.id = e.position_id join department d on d.id = e.department_id";
        return jdbcTemplate.query(sql, (resultSet, row) ->
                Employee.builder()
                        .id(resultSet.getInt(1))
                        .fullName(resultSet.getString(2))
                        .positionId(resultSet.getString(3))
                        .departmentId(resultSet.getString(4))
                        .positionName(resultSet.getString(5))
                        .departmentName(resultSet.getString(6))
                        .build()
        );
    }

    public void addNewEmployee(Employee employee) {
        String sql = "insert into employee (full_name, position_id, department_id)\n" +
                "values ('"+employee.getFullName()+"','"+employee.getPositionId()+"','"+employee.getDepartmentId()+"');";
        jdbcTemplate.update(sql);
    }

    public void editEmployee(Employee employee){
        String sql = "update employee set full_name='"+employee.getFullName()
                +"',position_id='"+employee.getPositionId()+"',department_id='"
                +employee.getDepartmentId()+"' where id ="+employee.getId();
        jdbcTemplate.update(sql);
    }

    public void deleteEmployee(Integer id){
        String sql="delete from employee where id ="+id;
        jdbcTemplate.update(sql);
    }

    public Employee getEmployeeById(Integer id){
        String sql="select e.*, p.name, d.name from employee e join position p on p.id = e.position_id " +
                "join department d on d.id = e.department_id where e.id = "+id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }
}
