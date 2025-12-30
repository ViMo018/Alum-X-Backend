package com.opencode.alumxbackend.users.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.opencode.alumxbackend.users.dto.UserAuraResponse;
import com.opencode.alumxbackend.users.model.User;
import com.opencode.alumxbackend.users.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuraServiceImpl implements UserAuraService {

    private final UserRepository userRepository;

    @Override
    public UserAuraResponse getAuraResponse(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserAuraResponse.builder()
                .skills(nullSafe(user.getSkills()))
                .education(nullSafe(user.getEducation()))
                .techStack(nullSafe(user.getTechStack()))
                .languages(nullSafe(user.getLanguages()))
                .frameworks(nullSafe(user.getFrameworks()))
                .communicationSkills(nullSafe(user.getCommunicationSkills()))
                .certifications(nullSafe(user.getCertifications()))
                .projects(nullSafe(user.getProjects()))
                .softSkills(nullSafe(user.getSoftSkills()))
                .hobbies(nullSafe(user.getHobbies()))
                .experience(nullSafe(user.getExperience()))
                .internships(nullSafe(user.getInternships()))
                .build();
    }

    private <T> java.util.List<T> nullSafe(java.util.List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }
}
