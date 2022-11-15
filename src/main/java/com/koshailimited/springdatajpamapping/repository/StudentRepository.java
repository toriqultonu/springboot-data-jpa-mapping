package com.koshailimited.springdatajpamapping.repository;

import com.koshailimited.springdatajpamapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameIsNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByGuardianNameContaining(String guardianName);
    @Query("select s.guardian.name from Student s where s.emailId = ?1 and s.firstName= ?2")
    public String getStudentByEmailAddress(String email, String firstName);
    @Query(value = "Select * from tbl_student where tbl_student.email_address = ?1", nativeQuery = true)
    Student getStudentEmailAddressNative(String email);

    @Query(value = "Select * from tbl_student where tbl_student.email_address = :email", nativeQuery = true)
    Student getStudentEmailAddressNativeNameParam(@Param("email") String email);
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name= ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstName, String email);

}
