package ua.dimalutsyuk.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.iasasc.teacher.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
