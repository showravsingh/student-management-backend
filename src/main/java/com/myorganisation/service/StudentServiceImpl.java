package com.myorganisation.service;

import com.myorganisation.dto.request.StudentRequestDTO;
import com.myorganisation.dto.response.GenericResponseDTO;
import com.myorganisation.dto.response.StudentResponseDTO;
import com.myorganisation.model.Student;
import com.myorganisation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public com.myorganisation.dto.response.StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();


        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setGender(studentRequestDTO.getGender());
        student.setCourse(studentRequestDTO.getCourse());

        studentRepository.save(student);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setGender(student.getGender());
        studentResponseDTO.setCourse(student.getCourse());

        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setGender(student.getGender());
        studentResponseDTO.setCourse(student.getCourse());

        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();

        for(Student student : studentList) {
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

            studentResponseDTO.setId(student.getId());
            studentResponseDTO.setName(student.getName());
            studentResponseDTO.setEmail(student.getEmail());
            studentResponseDTO.setGender(student.getGender());
            studentResponseDTO.setCourse(student.getCourse());

            studentResponseDTOList.add(studentResponseDTO);
        }

        return studentResponseDTOList;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(id).orElse(null);

        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setGender(studentRequestDTO.getGender());
        student.setCourse(studentRequestDTO.getCourse());

        studentRepository.save(student);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setGender(student.getGender());
        studentResponseDTO.setCourse(student.getCourse());

        return studentResponseDTO;
    }

    @Override
    public GenericResponseDTO removeStudent(Long id) {
        String name = studentRepository.findById(id).orElse(null).getName();
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO();

        if(name != null) {
            studentRepository.deleteById(id);
            String message = "Student name: " + name + " (" + id + ") has been removed successfully";
            genericResponseDTO.setSuccess(true);
            genericResponseDTO.setMessage(message);
        } else {
            genericResponseDTO.setSuccess(false);
            genericResponseDTO.setMessage("Student Id: " + id + " doesn't exist");
        }

        return genericResponseDTO;
    }
}
