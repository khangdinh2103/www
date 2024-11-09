package com.example.demo.repositories;

import com.example.demo.models.Candidate;
import com.example.demo.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c JOIN c.candidateSkills cs JOIN cs.skill s WHERE s IN :skills")
    List<Candidate> findCandidatesBySkills(@Param("skills") List<Skill> skills);

    @Query("SELECT c FROM Candidate c LEFT JOIN FETCH c.candidateSkills cs LEFT JOIN FETCH cs.skill WHERE c.id = :id")
    Candidate findByIdWithSkills(@Param("id") Long id);
}