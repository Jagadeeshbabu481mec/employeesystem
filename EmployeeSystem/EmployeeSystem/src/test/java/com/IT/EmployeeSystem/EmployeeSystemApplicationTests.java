package com.IT.EmployeeSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeSystemApplicationTests {
	@Test void validEmployeeIsAdded() {
        EmployeeService service = new EmployeeService();
        Employee e = service.addEmployee("Rahul", "CSE");
        assertEquals("Rahul", e.getName());
        assertEquals("CSE", e.getDepartment());
        assertEquals(1, service.getEmployees().size());
    }

    @Test void blankNameIsRejected() {
        EmployeeService service = new EmployeeService();
        assertThrows(IllegalArgumentException.class,
                () -> service.addEmployee(" ", "CSE"));
    }
}
