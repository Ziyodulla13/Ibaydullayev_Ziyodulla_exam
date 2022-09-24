package uz.pdp.ibaydullayev_ziyodulla_exam.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private Integer id;
    private String fullName;
    private String positionId;
    private String departmentId;
    private String positionName;
    private String departmentName;
}
