package com.myorganisation.service;

import com.myorganisation.dto.request.StudentRequestDTO;
import com.myorganisation.dto.response.GenericResponseDTO;
import com.myorganisation.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudentById(Long id);
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO);
    GenericResponseDTO removeStudent(Long id);
}
